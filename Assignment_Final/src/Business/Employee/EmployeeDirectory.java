/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name) {
        Employee employee = new Employee();
        employeeList.add(employee);
        return employee;
    }

    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
        employee.setOrganization(null);
        employee.setUserAccount(null);

    }

    public ArrayList<Employee> getIterator() {
        ArrayList<Employee> iteratorArrayList = new ArrayList<Employee>();
        for (Employee e : employeeList) {
            if (e != e.getOrganization().getAdminEmployee()) {
                iteratorArrayList.add(e);
            }
        }
        return iteratorArrayList;
    }

    public ArrayList<Employee> getavailableIterator() {
        ArrayList<Employee> iteratorArrayList = new ArrayList<Employee>();
        for (Employee e : employeeList) {
            if (e != e.getOrganization().getAdminEmployee() && e.isIsAvailable()) {
                iteratorArrayList.add(e);
            }
        }
        return iteratorArrayList;
    }
}
