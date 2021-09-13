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
import ui.HouseInsuranceManager.HMMenu;
import ui.HouseInsuranceStaff.HSMenu;

/**
 *
 * @author raunak
 */
public class HouseInsurerRole extends Role {

    static Role role;

    protected HouseInsurerRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new HouseInsurerRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        return new HSMenu(mainWorkArea, account.getEmployee());
    }

}
