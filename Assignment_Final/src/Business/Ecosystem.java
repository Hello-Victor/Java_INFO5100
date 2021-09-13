/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.HospitalSystem;
import Business.Enterprise.InsuranceSystem;
import Business.Enterprise.NewsSystem;
import Business.Enterprise.RescueSystem;
import Business.Enterprise.ResidentSystem;
import Business.Enterprise.SupplySystem;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author aeloyq
 */
public class Ecosystem extends Organization {

    static Ecosystem ecosystem;
    UserAccountDirectory userAccountDirectory;

    InsuranceSystem insuranceSystem;
    HospitalSystem hospitalSystem;
    RescueSystem rescueSystem;
    NewsSystem newsSystem;
    SupplySystem supplySystem;
    ResidentSystem residentSystem;

    public Ecosystem() {
        super("EcoSystem", null);
        userAccountDirectory = new UserAccountDirectory();
    }

    public static void setEcosystem(Ecosystem ecosystem) {
        Ecosystem.ecosystem = ecosystem;
    }

    @Override
    protected void setOrganizationDirectory() {
        this.OrganizationDirectory = new EnterpriseDirectory();
    }

    public static Ecosystem getInstance() {
        if (ecosystem == null) {
            ecosystem = new Ecosystem();
        }
        return ecosystem;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public InsuranceSystem getInsuranceSystem() {
        return insuranceSystem;
    }

    public void setInsuranceSystem(InsuranceSystem insuranceSystem) {
        this.insuranceSystem = insuranceSystem;
    }

    public HospitalSystem getHospitalSystem() {
        return hospitalSystem;
    }

    public void setHospitalSystem(HospitalSystem hospitalSystem) {
        this.hospitalSystem = hospitalSystem;
    }

    public NewsSystem getNewsSystem() {
        return newsSystem;
    }

    public void setNewsSystem(NewsSystem newsSystem) {
        this.newsSystem = newsSystem;
    }

    public SupplySystem getSupplySystem() {
        return supplySystem;
    }

    public void setSupplySystem(SupplySystem supplySystem) {
        this.supplySystem = supplySystem;
    }

    public RescueSystem getRescueSystem() {
        return rescueSystem;
    }

    public void setRescueSystem(RescueSystem rescueSystem) {
        this.rescueSystem = rescueSystem;
    }

    public ResidentSystem getResidentSystem() {
        return residentSystem;
    }

    public void setResidentSystem(ResidentSystem residentSystem) {
        this.residentSystem = residentSystem;
    }

    public UserAccount verifyAccount(String userName, String password) {
        for (UserAccount ua : userAccountDirectory.getUserAccountList()) {
            if (ua.getUsername().equals(userName) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }
}
