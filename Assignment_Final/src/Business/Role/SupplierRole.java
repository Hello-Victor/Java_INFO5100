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
import ui.SupplySystem.SupplySystemAdmin;

/**
 *
 * @author raunak
 */
public class SupplierRole extends Role {

    static Role role;

    protected SupplierRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new SupplierRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        return new SupplySystemAdmin(mainWorkArea);
    }

}
