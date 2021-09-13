/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.EmergencyMessageOrganization;
import Business.Organization.Organization;
import Business.Organization.RadioOrganization;
import Business.Organization.TVOrganization;
import Business.WorkQueue.NewsRequest;
import Business.WorkQueue.WorkRequest;

/**
 *
 * @author aeloyq
 */
public class NewsSystem extends Enterprise {

    TVOrganization tvOrganization;
    RadioOrganization radioOrganization;
    EmergencyMessageOrganization emergencyMessageOrganization;

    public NewsSystem(Organization upperOrganization) {
        super("Local News System", upperOrganization);
    }

    public TVOrganization getTvOrganization() {
        return tvOrganization;
    }

    public void setTvOrganization(TVOrganization tvOrganization) {
        this.tvOrganization = tvOrganization;
    }

    public RadioOrganization getRadioOrganization() {
        return radioOrganization;
    }

    public void setRadioOrganization(RadioOrganization radioOrganization) {
        this.radioOrganization = radioOrganization;
    }

    public EmergencyMessageOrganization getEmergencyMessageOrganization() {
        return emergencyMessageOrganization;
    }

    public void setEmergencyMessageOrganization(EmergencyMessageOrganization emergencyMessageOrganization) {
        this.emergencyMessageOrganization = emergencyMessageOrganization;
    }

    public WorkRequest getLatestEvent() {
        return workQueue.getWorkRequestList().get(workQueue.getWorkRequestList().size() - 1);
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
