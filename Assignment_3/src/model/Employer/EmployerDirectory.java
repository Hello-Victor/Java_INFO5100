/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Employer;

import model.Persona.Faculty.*;
import model.Persona.*;
import model.Department.Department;
import java.util.ArrayList;
import java.util.HashMap;
import model.Company.Company;

/**
 *
 * @author kal bugrara
 */
public class EmployerDirectory {

    PersonDirectory personDirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    HashMap<String, EmployerProfile> employerMap = new HashMap<String, EmployerProfile>();

    public EmployerDirectory(PersonDirectory personDirectory, AccountDirectory accountDirectory) {
        this.personDirectory = personDirectory;
        this.accountDirectory = accountDirectory;
    }

    public EmployerProfile newEmployerProfile(Person p, String userName, String password, Company c) throws AccountDirectory.AccountNameConflictException {
        EmployerProfile ep = new EmployerProfile(p, c);
        Account ac = accountDirectory.newAccount(userName, password, ep);
        ep.setAccount(ac);
        employerMap.put(p.getId(), ep);
        return ep;
    }

    public EmployerProfile findTeachingFaculty(String id) {
        return employerMap.get(id); //not found after going through the whole list
    }

    public void removeEmployer(String id) {
        EmployerProfile sp = employerMap.get(id);
        employerMap.remove(id);
        personDirectory.removePerson(id);
        accountDirectory.removeAccount(sp.getAccount().getUserName());
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public AccountDirectory getAccountDirectory() {
        return accountDirectory;
    }

    public void setAccountDirectory(AccountDirectory accountDirectory) {
        this.accountDirectory = accountDirectory;
    }

    public HashMap<String, EmployerProfile> getEmployerMap() {
        return employerMap;
    }

}
