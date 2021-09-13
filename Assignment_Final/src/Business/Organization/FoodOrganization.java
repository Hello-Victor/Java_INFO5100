/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.CarInsurerRole;
import Business.Role.FoodSupplierRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class FoodOrganization extends Organization{

    public FoodOrganization(Organization upperOrganization) {
        super("Local Food Supply Center", upperOrganization);
    }

    @Override
    public Role getRole() {
        return FoodSupplierRole.getInstance();
    }

     
}
