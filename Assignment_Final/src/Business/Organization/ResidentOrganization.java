/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.ResidentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ResidentOrganization extends NewsOrganization{

    public ResidentOrganization(Organization upperOrganization) {
        super("Local Residents", upperOrganization);
    }

    @Override
    public Role getRole() {
        return ResidentRole.getInstance();
    }

     
}
