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

    HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n, String cd, College c) {
        name = n;
        code = cd;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this);//pass the department object so it stays linked to it
        facultydirectory = new FacultyDirectory(this);//pass the department object so it stays linked to it
        college = c;
        try {
            DepartmentProfile dp = new DepartmentProfile();
            account = accountDirectory.newAccount(cd, "admin", dp);
            dp.setAccount(account);
        } catch (AccountDirectory.AccountNameConflictException ex) {
        }
    }

    public PersonDirectory getPersonDirectory() {

        return persondirectory;

    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
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

    public HashMap<String, CourseSchedule> getMastercoursecatalog() {
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

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);

        CourseLoad cl = sp.getCurrentCourseLoad();

        CourseSchedule cs = mastercoursecatalog.get(semester);

        CourseOffer co = cs.getCourseOfferByNumber(cn);

        co.assignEmptySeat(cl);

    }
}
