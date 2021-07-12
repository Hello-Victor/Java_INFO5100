/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.University;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.College.College;
import model.Department.Department;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.PersonDirectory;

/**
 *
 * @author aeloyq
 */
public class University {

    Account account;
    HashMap<String, College> colleges = new HashMap<String, College>();
    PersonDirectory personDirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    static University university = null;

    public class CollegeNameConflictException extends Exception {
    };

    private University() {
        try {
            UniversityProfile up = new UniversityProfile();
            account = accountDirectory.newAccount("admin", "admin", up);
            up.setAccount(account);
        } catch (AccountDirectory.AccountNameConflictException ex) {
        }
    }

    public Account getAccount() {
        return account;
    }

    public static University getUniversity() {
        return university;
    }

    public static University getInstance() {
        if (university == null) {
            university = new University();
        }
        return university;
    }

    public College newCollege(String name) throws AccountDirectory.AccountNameConflictException {
        College newCollege = new College(name);
        colleges.put(name, newCollege);
        return newCollege;
    }

    public College newCollege(String name, String accountName, String accountPassword) throws AccountDirectory.AccountNameConflictException, CollegeNameConflictException {
        if (colleges.containsKey(name)) {
            throw new CollegeNameConflictException();
        }
        College newCollege = new College(name, accountName, accountPassword);
        colleges.put(name, newCollege);
        return newCollege;
    }

    public void removeCollegeByName(String name) {
        colleges.remove(name);
        String[] nameSplits = name.split(" ");
        accountDirectory.removeAccount(nameSplits[nameSplits.length - 1]);
    }

    public void modifyCollege(College college, String name, String accountName, String accountPassword) throws AccountDirectory.AccountNameConflictException, CollegeNameConflictException {
        if (!name.equals(college.getName()) && colleges.containsKey(name)) {
            throw new CollegeNameConflictException();
        }
        colleges.remove(college.getName());
        college.setName(name);
        colleges.put(name, college);
        accountDirectory.modifyAccountName(college.getAccount(), accountName, accountPassword);
    }

    public College getCollege(String name) {
        return colleges.get(name);
    }

    public HashMap<String, College> getColleges() {
        return colleges;
    }
}
