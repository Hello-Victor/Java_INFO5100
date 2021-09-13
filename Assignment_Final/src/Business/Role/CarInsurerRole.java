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
import ui.CarInsuranceManager.CMMenuPanel;
import ui.CarInsuranceStaff.CMain;

/**
 *
 * @author raunak
 */
public class CarInsurerRole extends InsurerRole {

    static Role role;

    protected CarInsurerRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new CarInsurerRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        return new CMain(mainWorkArea, account.getEmployee());
    }

}
