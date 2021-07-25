/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.Organization;
import Business.UserAccount.UserAccount;
import userinterface.RestaurantAdminRole.RestaurantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class AdminRole extends Role{
    
   
    public AdminRole() {
        roleType=Role.RoleType.RestaurantAdmin;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new RestaurantWorkAreaJPanel();
    }

    
    
}
