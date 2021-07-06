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
import model.CourseCatalog.Feedback;
import model.CourseSchedule.CourseLoad;
import model.CourseSchedule.CourseOffer;
import model.CourseSchedule.CourseSchedule;
import model.CourseSchedule.Seat;
import model.CourseSchedule.SeatAssignment;
import model.Department.Department;
import model.Faker.FakerFactory;
import model.Faker.FakerUtils;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.Faculty.FacultyAssignment;
import model.Persona.Faculty.FacultyProfile;
import model.Persona.Person;
import model.Persona.PersonDirectory;
import model.Persona.StudentDirectory;
import model.Persona.StudentProfile;
import model.Persona.Transcript;
import model.University.University;

/**
 *
 * @author aeloyq
 */
public class playground {

    public static void main(String[] args) {
        Random random = FakerUtils.getRandom();
        University university = University.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();
        System.out.println("University Admin Account Authorized: " + accountDirectory.getProfile("admin").isAuthorized("admin"));
        System.out.println();
        FakerFactory.generateFakeDate();
        for (College c : university.getColleges().values()) {
            System.out.println(c.getName());
            System.out.println("College Admin Account Authorized: " + accountDirectory.getProfile(c.getName().split(" ")[2]).isAuthorized("admin"));
            System.out.println();
            for (Department d : c.getDepartments().values()) {
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
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        for (Company c : companyDirectory.getCompanyMap().values()) {
            System.out.println(c.getName());
            System.out.println("Company Admin Account Authorized: " + accountDirectory.getProfile(c.getName()).isAuthorized("admin"));
            System.out.println();
        }
        System.out.println();

        Company cpy = (Company) CompanyDirectory.getInstance().getCompanyMap().values().toArray()[0];
        College clg = university.getCollege("College of Engineering");
        Department dpm = clg.getDepartment("Information Systems");

        for (int i = 0; i < 6; i++) {
            StudentProfile sp = (StudentProfile) dpm.getStudentDirectory().getStudentMap().values().toArray()[random.nextInt(dpm.getStudentDirectory().getStudentMap().size())];
            Transcript tpt = sp.getTranscript();
            CourseLoad cl = tpt.getCourseLoadBySemester("2020Fall");
            SeatAssignment sa = cl.getSeatassignments().get(0);
            Feedback fdbk = sa.getFeedback();
            Seat st = sa.getSeat();
            System.out.println();
            System.out.println("Student");
            System.out.println("\tID: " + sp.getPerson().getId() + "\tName: " + sp.getPerson().getLastname() + "\tAge: " + sp.getPerson().getAge());
            System.out.println("\tUsername: " + sp.getAccount().getUserName() + "\tPasswd: " + sp.getAccount().getPassword());
            System.out.println("\tGPA: " + sp.getGPA());
        }

        for (int i = 0; i < 6; i++) {
            FacultyProfile fp = (FacultyProfile) dpm.getFacultydirectory().getTeacherMap().values().toArray()[random.nextInt(dpm.getFacultydirectory().getTeacherMap().size())];
            System.out.println();
            System.out.println("Faculty");
            System.out.println("\tID: " + fp.getPerson().getId() + "\tName: " + fp.getPerson().getLastname() + "\tAge: " + fp.getPerson().getAge());
            System.out.println("\tUsername: " + fp.getAccount().getUserName() + "\tPasswd: " + fp.getAccount().getPassword());
            System.out.println("\tCourse Offers:");
            for (FacultyAssignment fa : fp.getFacultyassignments()) {
                CourseOffer fco = fa.getCourseoffer();
                if (fco.numStudent() == 0) {
                    continue;
                }
                Course fcs = fco.getCourse();
                System.out.println("\t\tSemester: " + fco.getCourseSchedule().getSemester()
                        + "\tCourse Number: " + fcs.getCourseNumber()
                        + "\t\tNum Students: " + fco.numStudent()
                        + "\t\tSeat Size: " + fco.numSeats()
                        + "\t\tScore: " + fco.getScore()
                        + "\t\tFreshLevelRate: " + fco.getFreshLevelRate()
                        + "\tIndustryTrendsAlignmentRate: " + fco.getIndustryTrendsAlignmentRate()
                        + "\tOverallRate: " + fco.getOverallRate()
                        + "\t\tFeedback Size: " + fco.getFeedBackSize());
            }
            System.out.println("\tScore: " + fp.getScore());
        }

        for (int i = 0; i < 6; i++) {
            Course cs = (Course) dpm.getCourseCatalog().getCourseList().values().toArray()[random.nextInt(dpm.getCourseCatalog().getCourseList().size())];
            System.out.println();
            System.out.print("Course");
            System.out.println("\t\tCourse Number: " + cs.getCourseNumber()
                    + "\t\tNum Course Offers: " + cs.getCourseOffers().size()
                    + "\t\tScore: " + cs.getScore()
                    + "\t\tFreshLevelRate: " + cs.getFreshLevelRate()
                    + "\tIndustryTrendsAlignmentRate: " + cs.getIndustryTrendsAlignmentRate()
                    + "\tOverallRate: " + cs.getOverallRate()
                    + "\t\tFeedback Size: " + cs.getFeedBackSize());
        }

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
