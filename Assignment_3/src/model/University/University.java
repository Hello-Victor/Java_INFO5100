/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.University;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    HashSet<College> colleges = new HashSet<College>();
    PersonDirectory personDirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    static University university = null;

    private University() {
        try {
            UniversityProfile up = new UniversityProfile();
            account = accountDirectory.newAccount("admin", "admin", up);
            up.setAccount(account);
        } catch (AccountDirectory.AccountNameConflictException ex) {
        }
    }

    public static University getInstance() {
        if (university == null) {
            university = new University();
        }
        return university;
    }

    public College newCollege(String name) {
        College newCollege = new College(name);
        colleges.add(newCollege);
        return newCollege;
    }

    public void removeCollege(College college) {
        colleges.remove(college);
    }

    public HashSet<College> getColleges() {
        return colleges;
    }
}
