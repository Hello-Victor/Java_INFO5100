/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Ecosystem;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import java.util.jar.Attributes;

/**
 *
 * @author MyPC1
 */
public class Enterprise extends Organization{
    
    

    public Enterprise(String name, Organization upperOrganization) {
        super(name, upperOrganization);
    }
    
    @Override
    protected void setOrganizationDirectory() {
        this.OrganizationDirectory = new OrganizationDirectory();
    }

}
