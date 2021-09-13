/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Utilities;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import org.json.JSONObject;

/**
 *
 * @author aeloyq
 */
public class BaiduTTS {

    public static final String APP_ID = "24733628";
    public static final String API_KEY = "QzuD5RK7VonHUKlh9sPRr7mh";
    public static final String SECRET_KEY = "rI5uKXPEGqYPXV3E56OHDl6L8PkKL3uG";
    public static final AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    static boolean isContinue = false;

    public static boolean synthesis(String message) {
        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "8");
        options.put("pit", "3");
        options.put("per", "0");
        options.put("aue", "6");
        TtsResponse res = client.synthesis(message, "zh", 1, options);
        JSONObject result = res.getResult();
        byte[] data = res.getData();
        try {
            Util.writeBytesToFileSystem(data, "./src/res/output.mp3");
        } catch (IOException ex) {
            return false;
        }
        return true;
    }

    public static void play() {
        try {
            Clip clip;
            clip = AudioSystem.getClip();
            File f = new File("./src/res/output.mp3");
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
            clip.open(inputStream);
            setIsContinue(true);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            while (isIsContinue()) {
                Thread.sleep(1000);
            }
            clip.stop();
        } catch (Exception ex) {
        }
    }

    public synchronized static boolean isIsContinue() {
        return isContinue;
    }

    public synchronized static void setIsContinue(boolean isContinue) {
        BaiduTTS.isContinue = isContinue;
    }

    public static void main(String[] args) {
        try {
            Thread t = new Thread(BaiduTTS::play);
            t.start();
            Thread.sleep(100000);
            setIsContinue(false);
            t.join();
            System.out.println(t.isAlive());
        } catch (Exception ex) {
        }
    }
}
