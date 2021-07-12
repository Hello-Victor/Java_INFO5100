/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import model.Employment.Employment;
import model.Employment.EmploymentHistory;
import model.Employment.PromotionHistory;
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
        FakerFactory.generateFakeData();
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
                System.out.println("\t\tNum of Student: " + d.getStudentdirectory().getStudentMap().size());
                System.out.println();
                for (Course cs : d.getCourseCatalog().getCourseMap().values()) {
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

        for (int i = 0; i < 32; i++) {
            StudentProfile sp = (StudentProfile) dpm.getStudentdirectory().getStudentMap().values().toArray()[random.nextInt(dpm.getStudentdirectory().getStudentMap().size())];
            Transcript tpt = sp.getTranscript();

            System.out.println();
            System.out.println("Student");
            System.out.println("\tID: " + sp.getPerson().getId() + "\tName: " + sp.getPerson().getLastname() + "\tAge: " + sp.getPerson().getAge());
            System.out.println("\tUsername: " + sp.getAccount().getUserName() + "\tPasswd: " + sp.getAccount().getPassword());
            System.out.println("\tGPA: " + sp.getGPA() + "\tGraduated: " + sp.isGraduated());
            for (String s : tpt.getCourseloadlist().keySet()) {
                CourseLoad cl = tpt.getCourseLoadBySemester(s);
//                SeatAssignment sa = cl.getSeatassignments().get(0);
//                Feedback fdbk = sa.getFeedback();
//                Seat st = sa.getSeat();
                System.out.print("\t" + s + ": " + cl.getGPA());
            }
            System.out.println();
            if (sp.isGraduated()) {
                System.out.println("\tSalary: " + sp.getEmploymenthistory().getLatestSalary() + "\tJob Hopped: " + sp.getEmploymenthistory().getJobHopTimes() + "\tPromoted: " + sp.getEmploymenthistory().getPromotionTimes());
                for (PromotionHistory ph : sp.getEmploymenthistory().getEmployments()) {
                    for (Employment e : ph.getPromotionHistorySet()) {
                        System.out.println("\tYear: " + String.valueOf(e.getYear()) + "\tCompany: " + String.valueOf(e.getEmployerProfile().getCompany().getName()) + "\tTitle: " + e.getTitle() + "\tSalary: " + String.valueOf(e.getSalary()));
                    }
                }
            }
            System.out.println("");
        }

        for (int i = 0; i < dpm.getFacultydirectory().getTeacherMap().size(); i++) {
            FacultyProfile fp = (FacultyProfile) dpm.getFacultydirectory().getTeacherMap().values().toArray()[i];
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
        System.out.println();
        for (int i = 0; i < 6; i++) {
            Course cs = (Course) dpm.getCourseCatalog().getCourseMap().values().toArray()[random.nextInt(dpm.getCourseCatalog().getCourseMap().size())];
            System.out.print("Course");
            System.out.println("\t\tCourse Number: " + cs.getCourseNumber()
                    + "\t\tNum Course Offers: " + cs.getCourseOffers().size()
                    + "\t\tScore: " + cs.getScore()
                    + "\t\tFreshLevelRate: " + cs.getFreshLevelRate()
                    + "\tIndustryTrendsAlignmentRate: " + cs.getIndustryTrendsAlignmentRate()
                    + "\tOverallRate: " + cs.getOverallRate()
                    + "\t\tFeedback Size: " + cs.getFeedBackSize());
        }
        ArrayList<Course> courses = new ArrayList<Course>();
        ArrayList<FacultyProfile> facultyProfiles = new ArrayList<FacultyProfile>();
        ArrayList<StudentProfile> studentProfiles = new ArrayList<StudentProfile>();
        ArrayList<Company> companies = new ArrayList<Company>();
        for (College college : university.getColleges().values()) {
            for (Department department : college.getDepartments().values()) {
                for (FacultyProfile facultyProfile : department.getFacultydirectory().getTeacherMap().values()) {
                    facultyProfiles.add(facultyProfile);
                }
                for (StudentProfile studentProfile : department.getStudentdirectory().getStudentMap().values()) {
                    studentProfiles.add(studentProfile);
                }
                for (Course course : department.getCoursecatalog().getCourseMap().values()) {
                    courses.add(course);
                }
            }
        }
        for (Company company : companyDirectory.getCompanyMap().values()) {
            companies.add(company);
        }
        Collections.sort(courses, Comparator.comparing(Course::getScore).reversed());
        System.out.println();
        System.out.println("Course Number" + "\t" + "Feedbacks" + "\t" + "Score" + "\t" + "Grade" + "\t" + "Expected Income");
        for (Course course : courses) {
            System.out.println(course.getCourseNumber() + "\t" + course.getFeedBackSize() + "\t" + String.format("%.2f", course.getScore()) + "\t" + String.format("%.2f", course.getGrade()) + "\t" + course.getExpectedFutureSalary());
        }
        Collections.sort(facultyProfiles, Comparator.comparing(FacultyProfile::getScore).reversed());
        System.out.println();
        System.out.println("Faculty ID" + "\t" + "Teached Courses" + "\t" + "Score" + "\t" + "Grade" + "\t" + "Expected Income");
        for (FacultyProfile facultyProfile : facultyProfiles) {
            System.out.println(facultyProfile.getPerson().getId() + "\t" + facultyProfile.getFacultyassignments().size() + "\t" + String.format("%.2f", facultyProfile.getScore()) + "\t" + String.format("%.2f", facultyProfile.getGrade()) + "\t" + facultyProfile.getExpectedFutureSalary());
        }
        Collections.sort(studentProfiles, Comparator.comparing(StudentProfile::getAcademicWeight).reversed());
        System.out.println();
        System.out.println("Student ID" + "\t" + "Learned Courses" + "\t" + "GPA" + "\t" + "Industrial Weight" + "\t" + "Income" + "\t" + "Promotion" + "\t" + "JobHop");
        for (StudentProfile studentProfile : studentProfiles) {
            if (studentProfile.isGraduated()) {
                System.out.println(studentProfile.getPerson().getId() + "\t" + studentProfile.getTranscript().totalCredits() / 4 + "\t" + String.format("%.2f", studentProfile.getTranscript().getGPA()) + "\t" + studentProfile.getIndustialWeight()
                        + "\t" + studentProfile.getEmploymenthistory().getLatestSalary() + "\t" + studentProfile.getEmploymenthistory().getPromotionTimes() + "\t" + studentProfile.getEmploymenthistory().getJobHopTimes());
            }
        }
        Collections.sort(companies, Comparator.comparing(Company::getWeight).reversed());
        System.out.println();
        System.out.println("Company" + "\t" + "Employees" + "\t" + "Weight" + "\t" + "Income" + "\t" + "Promotion" + "\t" + "GPA" + "\t" + "Course Score");
        for (Company company : companies) {
            System.out.println(company.getName() + "\t" + company.getPromotionHistoriesArrayList().size() + "\t" + String.format("%.2f", company.getWeight()) + "\t" + company.getAverageSalary()
                    + "\t" + String.format("%.2f", company.getAveragePromotionTimes()) + "\t" + String.format("%.2f", company.getGPA()) + "\t" + String.format("%.2f", company.getRelatedCourseScore()));

        }
    }
}
