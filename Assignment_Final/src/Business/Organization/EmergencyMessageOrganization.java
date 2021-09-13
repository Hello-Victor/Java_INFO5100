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
public class EmergencyMessageOrganization extends NewsOrganization{

    public EmergencyMessageOrganization(Organization upperOrganization) {
        super("Local Emergency Message Center", upperOrganization);
    }

     
}
