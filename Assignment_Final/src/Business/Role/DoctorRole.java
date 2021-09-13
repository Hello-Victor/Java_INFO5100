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
import ui.HospitalManager.HospitalMenu;
import ui.HospitalStaff.HospitalStaffMenu;

/**
 *
 * @author raunak
 */
public class DoctorRole extends Role {

    static Role role;

    protected DoctorRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new DoctorRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        return new HospitalStaffMenu(mainWorkArea, account.getEmployee());
    }

}
