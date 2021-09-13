/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.RescueOrganization;

/**
 *
 * @author aeloyq
 */
public class RescueSystem extends Enterprise{
    
    RescueOrganization rescueOrganization;
    
    public RescueSystem(Organization upperOrganization) {
        super("Local Hospital System", upperOrganization);
    }

    public RescueOrganization getRescueOrganization() {
        return rescueOrganization;
    }

    public void setRescueOrganization(RescueOrganization rescueOrganization) {
        this.rescueOrganization = rescueOrganization;
    }

    
}
