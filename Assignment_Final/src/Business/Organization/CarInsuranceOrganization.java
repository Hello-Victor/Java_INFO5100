/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.CarInsurerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CarInsuranceOrganization extends Organization {

    public CarInsuranceOrganization(Organization upperOrganization) {
        super("Local Car Insurance Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return CarInsurerRole.getInstance();
    }

}
