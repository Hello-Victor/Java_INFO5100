/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseCatalog;

import model.Department.Department;
import java.util.ArrayList;
import java.util.HashMap;
import model.Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class CourseCatalog {

    Department department;
    String lastupdated;
    HashMap<String, Course> courseMap = new HashMap<String, Course>();

    public CourseCatalog(Department d) {
        department = d;
    }

    public Course newCourse(String n, String nm, int cr) {
        Course c = new Course(n, nm, cr);
        courseMap.put(c.getCourseNumber(), c);
        return c;
    }

    public void removeCourse(String nm) {
        courseMap.remove(nm);
    }

    public Department getDepartment() {
        return department;
    }

    public HashMap<String, Course> getCourseMap() {
        return courseMap;
    }

    public Course getCourseByNumber(String n) {

        return courseMap.get(n);
    }

}
