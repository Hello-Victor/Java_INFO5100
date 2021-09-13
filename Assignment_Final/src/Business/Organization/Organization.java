/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.io.IOException;
import java.util.ArrayList;
import ui.Utilities.BaiduTTS;

/**
 *
 * @author raunak
 */
public class Organization {

    private String name;
    protected WorkQueue workQueue;
    protected WorkQueue workQueueFromResidents;
    private EmployeeDirectory employeeDirectory;
    private Organization upperOrganization;
    private int organizationID;
    protected OrganizationDirectory OrganizationDirectory;
    private Employee adminEmployee;
    private static int counter = 0;

    public Organization(String name, Organization upperOrganization) {
        this.name = name;
        this.upperOrganization = upperOrganization;
        workQueue = new WorkQueue();
        workQueueFromResidents = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        setOrganizationDirectory();
        organizationID = counter;
        ++counter;
    }

    protected void setOrganizationDirectory() {
        this.OrganizationDirectory = null;
    }

    public Organization getUpperOrganization() {
        return upperOrganization;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return OrganizationDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public WorkQueue getResidentWorkQueue() {
        return workQueueFromResidents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public WorkQueue getWorkQueueFromResidents() {
        return workQueueFromResidents;
    }

    public void setWorkQueueFromResidents(WorkQueue workQueueFromResidents) {
        this.workQueueFromResidents = workQueueFromResidents;
    }

    public Employee getAdminEmployee() {
        return adminEmployee;
    }

    public void setAdminEmployee(Employee adminEmployee) {
        this.adminEmployee = adminEmployee;
    }

    public Role getRole() {
        return Role.getInstance();
    }

    @Override
    public String toString() {
        return name;
    }

}
