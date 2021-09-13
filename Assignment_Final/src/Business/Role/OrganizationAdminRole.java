/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ResidentSystem;
import Business.Organization.CarInsuranceOrganization;
import Business.Organization.ElectricityOrganization;
import Business.Organization.EmergencyMessageOrganization;
import Business.Organization.FoodOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.HouseInsuranceOrganization;
import Business.Organization.Organization;
import Business.Organization.RadioOrganization;
import Business.Organization.RescueOrganization;
import Business.Organization.ResidentOrganization;
import Business.Organization.TVOrganization;
import Business.Organization.WaterOrganization;
import Business.UserAccount.UserAccount;
import com.db4o.foundation.NotImplementedException;
import javax.swing.JPanel;
import ui.CarInsuranceManager.CMMenuPanel;
import ui.HospitalManager.HospitalMenu;
import ui.HouseInsuranceManager.HMMenu;
import ui.NewsSystem.LocalEmergencyMessageAdmin;
import ui.NewsSystem.LocalRadioChannel;
import ui.NewsSystem.LocalTVChannel;
import ui.Resident.RMain;
import ui.SupplySystem.LocalElectricitySupplyCenterAdmin;
import ui.SupplySystem.LocalFoodSupplyCenterAdmin;
import ui.SupplySystem.LocalWaterSupplyCenterAdmin;
import ui.UserManagement.UserAccountListManagement;
import ui.nineoneoneManager.nineoneoneManager;

/**
 *
 * @author raunak
 */
public class OrganizationAdminRole extends Role {
    protected Ecosystem ecoSystem = Ecosystem.getInstance();
    protected ResidentSystem residentSystem = ecoSystem.getResidentSystem();
    protected ResidentOrganization residentOrganization = residentSystem.getResidentOrganization();

    static Role role;

    protected OrganizationAdminRole() {
    }

    public static Role getInstance() {
        if (role == null) {
            role = new OrganizationAdminRole();
        }
        return role;
    }

    @Override
    public JPanel createWorkArea(JPanel mainWorkArea, UserAccount account) {
        if (account.getEmployee().getOrganization() instanceof CarInsuranceOrganization) {
            return new CMMenuPanel(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof HouseInsuranceOrganization) {
            return new HMMenu(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof HospitalOrganization) {
            return new HospitalMenu(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof RescueOrganization) {
            return new nineoneoneManager(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof EmergencyMessageOrganization) {
            return new LocalEmergencyMessageAdmin(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof TVOrganization) {
            return new LocalTVChannel(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof RadioOrganization) {
            return new LocalRadioChannel(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof ElectricityOrganization) {
            return new LocalElectricitySupplyCenterAdmin(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof WaterOrganization) {
            return new LocalWaterSupplyCenterAdmin(mainWorkArea);
        } else if (account.getEmployee().getOrganization() instanceof FoodOrganization) {
            return new LocalFoodSupplyCenterAdmin(mainWorkArea);
        }
        return new RMain(mainWorkArea, account.getEmployee());
    }

}
