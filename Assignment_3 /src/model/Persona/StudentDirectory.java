/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import model.Department.Department;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class StudentDirectory {

    PersonDirectory personDirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    Department department;
    HashMap<String, StudentProfile> studentMap = new HashMap<String, StudentProfile>();

    public StudentDirectory(Department d) {
        department = d;
    }

    public StudentProfile newStudentProfile(Person p, String userNameString, String password) throws AccountDirectory.AccountNameConflictException {
        StudentProfile sp = new StudentProfile(p, department);
        Account ac = accountDirectory.newAccount(userNameString, password, sp);
        sp.setAccount(ac);
        studentMap.put(p.getId(), sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {
        return studentMap.get(id); //not found after going through the whole list
    }

    public void removeStudentProfile(String id) {
        StudentProfile st = studentMap.get(id);
        studentMap.remove(id);
        personDirectory.removePerson(id);
        accountDirectory.removeAccount(st.getAccount().getUserName());
    }

    public Department getDepartment() {
        return department;
    }

    public HashMap<String, StudentProfile> getStudentMap() {
        return studentMap;
    }

}
