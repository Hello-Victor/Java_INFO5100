/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import com.db4o.foundation.NotImplementedException;
import javax.swing.JPanel;
import ui.Administrator.Administrator;
import ui.NewsSystem.LocalRadioChannel;

/**
 *
 * @author raunak
 */
public class SystemAdminRole extends Role {

    static Role role;

    protected SystemAdminRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new SystemAdminRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        return new Administrator(mainWorkArea);
    }

}
