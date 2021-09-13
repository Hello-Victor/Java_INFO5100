/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.*;
import Business.UserAccount.UserAccount;
import com.db4o.foundation.NotImplementedException;
import javax.swing.JPanel;
import ui.Administrator.Hospital;
import ui.Administrator.Insurance;
import ui.Administrator.News;
import ui.Administrator._911;
import ui.CarInsuranceManager.CMMenuPanel;
import ui.HospitalManager.HospitalMenu;
import ui.HouseInsuranceManager.HMMenu;
import ui.NewsSystem.LocalRadioChannel;
import ui.Resident.RMain;
import ui.SupplySystem.SupplySystemAdmin;
import ui.UserManagement.UserAccountListManagement;
import ui.UserManagement.UserAccountManagement;
import ui.nineoneoneManager.nineoneoneManager;

/**
 *
 * @author raunak
 */
public class AdminRole extends Role {

    static Role role;

    protected AdminRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new AdminRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        
        if (account.getEmployee().getOrganization() instanceof InsuranceSystem) {
            return new Insurance(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof HospitalSystem) {
            return new Hospital(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof NewsSystem) {
            return new News(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof SupplySystem) {
            return new SupplySystemAdmin(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof RescueSystem) {
            return new _911(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof ResidentSystem) {
            return new UserAccountListManagement(mainWorkArea,account.getEmployee().getOrganization());
        }
        return new RMain(mainWorkArea, account.getEmployee());
    }

}
