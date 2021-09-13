/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import Business.WorkQueue.NewsRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Utilities.BaiduTTS;

/**
 *
 * @author raunak
 */
public class RadioOrganization extends NewsOrganization {

    public RadioOrganization(Organization upperOrganization) {
        super("Local Radio Center", upperOrganization);
    }

    @Override
    public void addNewMessage(NewsRequest request) {
        super.addNewMessage(request);
        int retry = 60;
        while (!BaiduTTS.synthesis(request.getMessage()) && retry >= 0) {
            try {
                Thread.sleep(500);
                retry--;
            } catch (InterruptedException ex) {
            }
        };
    }

}
