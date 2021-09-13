/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import Business.WorkQueue.NewsRequest;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class NewsOrganization extends Organization {

    public NewsOrganization(String name, Organization upperOrganization) {
        super(name, upperOrganization);
    }

    public String getLatestMessage() {
        if (workQueue.getWorkRequestList().size() == 0) {
            return "No Message For Now.";
        } else {
            return workQueue.getWorkRequestList().get(workQueue.getWorkRequestList().size() - 1).getMessage();
        }
    }
    
    public void addNewMessage(NewsRequest request) {
        workQueue.getWorkRequestList().add(request);
    }

}
