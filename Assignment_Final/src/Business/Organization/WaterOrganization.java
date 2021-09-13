/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.DoctorRole;
import Business.Role.Role;
import Business.Role.WaterEngineerRole;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WaterOrganization extends Organization{

    public WaterOrganization(Organization upperOrganization) {
        super("Local Water Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return WaterEngineerRole.getInstance();
    }

     
}
