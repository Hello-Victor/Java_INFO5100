/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.github.javafaker.Faker;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.College.College;
import model.Company.Company;
import model.Company.CompanyDirectory;
import model.CourseCatalog.Course;
import model.CourseSchedule.CourseLoad;
import model.CourseSchedule.CourseOffer;
import model.CourseSchedule.CourseSchedule;
import model.Department.Department;
import model.Faker.FakerFactory;
import model.Faker.FakerUtils;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.Person;
import model.Persona.PersonDirectory;
import model.Persona.StudentDirectory;
import model.Persona.StudentProfile;
import model.University.University;

/**
 *
 * @author aeloyq
 */
public class playground {

    public static void main(String[] args) {
        Faker faker = new Faker();
        University university = University.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();
        System.out.println("University Admin Account Authorized: " + accountDirectory.getProfile("admin").isAuthorized("admin"));
        System.out.println();
        FakerFactory.constructUniversity();
        for (College c : university.getColleges()) {
            System.out.println(c.getName());
            System.out.println("College Admin Account Authorized: " + accountDirectory.getProfile(c.getName().split(" ")[2]).isAuthorized("admin"));
            System.out.println();
            for (Department d : c.getDepartments()) {
                System.out.println();
                System.out.println("\t" + d.getName());
                System.out.println("\tDepartment Admin Account Authorized: " + accountDirectory.getProfile(d.getCode()).isAuthorized("admin"));
                System.out.println();
                System.out.println("\t\tNum of Teacher: " + d.getFacultydirectory().getTeacherMap().size());
                System.out.println("\t\tNum of Student: " + d.getStudentDirectory().getStudentMap().size());
                System.out.println();
                for (Course cs : d.getCourseCatalog().getCourseList().values()) {
                    System.out.println("\t\t" + cs.getName() + "\t" + cs.getCourseNumber() + "\t\t\toffers: " + cs.getCourseOffers().size());
                }
                System.out.println();
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }
        FakerFactory.constructCompanies();
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        for (Company c : companyDirectory.getCompanyMap().values()) {
            System.out.println(c.getName());
            System.out.println("Company Admin Account Authorized: " + accountDirectory.getProfile(c.getName()).isAuthorized("admin"));
            System.out.println();
        }
        System.out.println();

//        College college = university.newCollege("College of Engineering");
//        Department department = college.newDepartment("Information Systems");
//        Course course = department.newCourse("app eng", "info 5100", 4);
//        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");
//        CourseOffer courseoffer = courseschedule.newCourseOffer("info 5100");
//        courseoffer.generatSeats(10);
//        PersonDirectory pd = department.getPersonDirectory();
//        Person person = pd.newPerson();
//        StudentDirectory sd = department.getStudentDirectory();
//        StudentProfile student;
//        try {
//            student = sd.newStudentProfile(person, "abc", "123");
//            CourseLoad courseload = student.newCourseLoad("Fall2020");
//            courseload.newSeatAssignment(courseoffer); //register student in class
//
//            int total = department.calculateRevenuesBySemester("Fall2020");
//            System.out.print("Total: " + total);
//            System.out.print("GPA: " + String.valueOf(student.getTranscript().getGPA()));
//        } catch (Exception ex) {
//
//        }
    }
}
