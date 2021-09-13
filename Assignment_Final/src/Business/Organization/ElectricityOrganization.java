/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.CarInsurerRole;
import Business.Role.ElectricityEngineerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class ElectricityOrganization extends Organization{

    public ElectricityOrganization(Organization upperOrganization) {
        super("Local Electricity Supply Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return ElectricityEngineerRole.getInstance();
    }

     
}
