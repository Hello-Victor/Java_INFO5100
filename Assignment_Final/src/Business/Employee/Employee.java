/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author raunak
 */
public class Employee {

    private Organization organization;
    private UserAccount userAccount;
    private Role role;
    private String logoImage;
    private String name;
    private String id;
    private Person person;
    private String carPlan;
    private String housePlan;
    private boolean isAvailable;
    private static int count = 1;
    private WorkQueue workQueue = new WorkQueue();

    public Employee() {
        id = String.format("%08d", count);
        isAvailable = true;
        count++;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return person.getName();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public String getCarPlan() {
        return carPlan;
    }

    public void setCarPlan(String carPlan) {
        this.carPlan = carPlan;
    }

    public String getHousePlan() {
        return housePlan;
    }

    public void setHousePlan(String housePlan) {
        this.housePlan = housePlan;
    }

    @Override
    public String toString() {
        return getName();
    }

}
