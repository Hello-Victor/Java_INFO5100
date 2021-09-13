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
import ui.SupplySystem.LocalWaterSupplyCenterStaff;

/**
 *
 * @author raunak
 */
public class WaterEngineerRole extends SupplierRole {

    static Role role;

    protected WaterEngineerRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new WaterEngineerRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        return new LocalWaterSupplyCenterStaff(mainWorkArea, account);
    }

}
