/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.HouseInsurerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HouseInsuranceOrganization extends Organization{

    public HouseInsuranceOrganization(Organization upperOrganization) {
        super("Local House Insurance Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return HouseInsurerRole.getInstance();
    }

     
}
