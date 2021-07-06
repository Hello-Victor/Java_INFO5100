/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona.Faculty;

import model.Persona.*;
import model.Department.Department;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class FacultyDirectory {

    Department department;
    PersonDirectory personDirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    HashMap<String, FacultyProfile> teacherMap = new HashMap<String, FacultyProfile>();

    public FacultyDirectory(Department d) {

        department = d;

    }

    public FacultyProfile newFacultyProfile(Person p, String userNameString, String password) throws AccountDirectory.AccountNameConflictException {
        FacultyProfile fp = new FacultyProfile(p);
        Account ac = accountDirectory.newAccount(userNameString, password, fp);
        fp.setAccount(ac);
        teacherMap.put(p.getId(), fp);
        return fp;
    }

    public FacultyProfile findTeachingFaculty(String id) {
        return teacherMap.get(id); //not found after going through the whole list
    }

    public void removeTeachingFaculty(String id) {
        FacultyProfile teacher = teacherMap.get(id);
        teacherMap.remove(id);
        personDirectory.removePerson(id);
        accountDirectory.removeAccount(teacher.getAccount().getUserName());
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public HashMap<String, FacultyProfile> getTeacherMap() {
        return teacherMap;
    }

}
