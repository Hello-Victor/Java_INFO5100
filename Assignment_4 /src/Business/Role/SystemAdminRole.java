/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.UserAccount.UserAccount;
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role{

     public SystemAdminRole() {
        roleType=Role.RoleType.SysAdmin;
    }
  
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem system) {
        return new SystemAdminWorkAreaJPanel();
    }
    
}
