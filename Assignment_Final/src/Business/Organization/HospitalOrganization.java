/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.FoodSupplierRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class HospitalOrganization extends Organization{

    public HospitalOrganization(Organization upperOrganization) {
        super("Local Hospital Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return DoctorRole.getInstance();
    }

     
}
