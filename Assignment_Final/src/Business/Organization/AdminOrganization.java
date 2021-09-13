/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AdminOrganization extends Organization{

    public AdminOrganization(Organization upperOrganization) {
        super("Admin", upperOrganization);
    }

     
}
