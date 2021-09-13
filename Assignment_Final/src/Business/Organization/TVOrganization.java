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
public class TVOrganization extends NewsOrganization{

    public TVOrganization(Organization upperOrganization) {
        super("Local TV Center", upperOrganization);
    }

     
}
