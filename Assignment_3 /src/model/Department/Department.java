/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Department;

import model.CourseCatalog.Course;
import model.CourseCatalog.CourseCatalog;
import model.CourseSchedule.CourseLoad;
import model.CourseSchedule.CourseOffer;
import model.CourseSchedule.CourseSchedule;
import model.Persona.Faculty.FacultyDirectory;
import model.Persona.PersonDirectory;
import model.Persona.StudentDirectory;
import model.Persona.StudentProfile;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import model.College.College;
import model.College.CollegeProfile;
import model.Employer.EmployerDirectory;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class Department {

    String name;
    String code;
    Account account;
    CourseCatalog coursecatalog;
    PersonDirectory persondirectory = PersonDirectory.getInstance();
    AccountDirectory accountDirectory = AccountDirectory.getInstance();
    StudentDirectory studentdirectory;
    FacultyDirectory facultydirectory;
    College college;

    LinkedHashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n, String cd, College c) throws AccountDirectory.AccountNameConflictException {
        name = n;
        code = cd;
        mastercoursecatalog = new LinkedHashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this);//pass the department object so it stays linked to it
        facultydirectory = new FacultyDirectory(this);//pass the department object so it stays linked to it
        college = c;
        DepartmentProfile dp = new DepartmentProfile(this);
        account = accountDirectory.newAccount(cd, "admin", dp);
        dp.setAccount(account);
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public CourseCatalog getCoursecatalog() {
        return coursecatalog;
    }

    public AccountDirectory getAccountDirectory() {
        return accountDirectory;
    }

    public StudentDirectory getStudentdirectory() {
        return studentdirectory;
    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public College getCollege() {
        return college;
    }

    public LinkedHashMap<String, CourseSchedule> getMastercoursecatalog() {
        return mastercoursecatalog;
    }

    public CourseSchedule newCourseSchedule(String semester) {

        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {

        return mastercoursecatalog.get(semester);

    }

    public CourseCatalog getCourseCatalog() {

        return coursecatalog;

    }

    public Course newCourse(String n, String nm, int cr) {
        Course c = coursecatalog.newCourse(n, nm, cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {

        CourseSchedule css = mastercoursecatalog.get(semester);

        return css.calculateTotalRevenues();

    }
}
