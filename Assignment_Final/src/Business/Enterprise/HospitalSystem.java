/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;

/**
 *
 * @author aeloyq
 */
public class HospitalSystem extends Enterprise{
    
    HospitalOrganization hospitalOrganization;
    
    public HospitalSystem(Organization upperOrganization) {
        super("Local Hospital System", upperOrganization);
    }

    public HospitalOrganization getHospitalOrganization() {
        return hospitalOrganization;
    }

    public void setHospitalOrganization(HospitalOrganization hospitalOrganization) {
        this.hospitalOrganization = hospitalOrganization;
    }

    
}
