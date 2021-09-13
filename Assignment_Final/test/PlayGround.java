/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aeloyq
 */
import Business.DB4OUtil.DB4OUtil;
import Business.Ecosystem;

public class PlayGround {

    public static void main(String[] args) {
        DB4OUtil dB4OUtil = DB4OUtil.getInstance();
        Ecosystem system = dB4OUtil.retrieveSystem();
        dB4OUtil.storeSystem(system);
    }

}
