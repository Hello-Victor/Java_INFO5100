/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.College;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import model.Department.Department;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.Faculty.FacultyDirectory;
import model.Persona.PersonDirectory;

/**
 *
 * @author aeloyq
 */
public class College {

    String name;
    Account account;
    PersonDirectory personDirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    HashMap<String, Department> departments = new HashMap<String, Department>();

    public class DepartmentNameConflictException extends Exception {
    };

    public College(String name) throws AccountDirectory.AccountNameConflictException {
        this.name = name;
        CollegeProfile cp = new CollegeProfile(this);
        String[] nameSplits = name.split(" ");
        account = accountDirectory.newAccount(nameSplits[nameSplits.length - 1], "admin", cp);
        cp.setAccount(account);
    }

    public College(String name, String accountName, String accountPassword) throws AccountDirectory.AccountNameConflictException {
        this.name = name;
        CollegeProfile cp = new CollegeProfile(this);
        account = accountDirectory.newAccount(accountName, accountPassword, cp);
        cp.setAccount(account);
    }

    public Department newDepartment(String name, String code) throws AccountDirectory.AccountNameConflictException, DepartmentNameConflictException {
        if (departments.containsKey(name)) {
            throw new DepartmentNameConflictException();
        }
        Department department = new Department(name, code, this);
        departments.put(name, department);
        return department;
    }

    public void modifyDepartment(Department department, String name, String accountName, String accountPassword) throws AccountDirectory.AccountNameConflictException, DepartmentNameConflictException {
        if (!name.equals(department.getName()) && departments.containsKey(name)) {
            throw new DepartmentNameConflictException();
        }
        departments.remove(department.getName());
        department.setName(name);
        departments.put(name, department);
        accountDirectory.modifyAccountName(department.getAccount(), accountName, accountPassword);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void removeDepartmentByName(String name) {
        Department d = getDepartment(name);
        departments.remove(name);
        accountDirectory.removeAccount(d.getAccount().getUserName());
    }

    public Department getDepartment(String name) {
        return departments.get(name);
    }

    public HashMap<String, Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }
}
