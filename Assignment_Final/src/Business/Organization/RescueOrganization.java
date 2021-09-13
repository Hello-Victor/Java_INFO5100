/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.RescuerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class RescueOrganization extends Organization{

    public RescueOrganization(Organization upperOrganization) {
        super("Local Rescue Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return RescuerRole.getInstance();
    }

     
}
