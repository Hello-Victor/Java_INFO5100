/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Enterprise.Enterprise;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    protected ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
}
