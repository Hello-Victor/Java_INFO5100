/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.EmergencyMessageOrganization;
import Business.Organization.Organization;
import Business.Organization.RadioOrganization;
import Business.Organization.ResidentOrganization;
import Business.Organization.TVOrganization;

/**
 *
 * @author aeloyq
 */
public class ResidentSystem extends Enterprise {
    
    ResidentOrganization residentOrganization;
    
    public ResidentSystem(Organization upperOrganization) {
        super("Local News System", upperOrganization);
    }

    public ResidentOrganization getResidentOrganization() {
        return residentOrganization;
    }

    public void setResidentOrganization(ResidentOrganization residentOrganization) {
        this.residentOrganization = residentOrganization;
    }

}
