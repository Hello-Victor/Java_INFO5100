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

/**
 *
 * @author raunak
 */
public class InsurerRole extends Role {

    static Role role;

    protected InsurerRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new InsurerRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        throw new NotImplementedException();
    }

}
