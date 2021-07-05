/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona.Faculty;

import model.Persona.*;
import model.CourseSchedule.CourseOffer;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile extends Profile {

    ArrayList<FacultyAssignment> facultyassignments;

    public FacultyProfile(Person p) {
        super(p);
        facultyassignments = new ArrayList();
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co) {

        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);

        return fa;
    }

    public FacultyProfile getCourseOffer(String courseid) {
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<FacultyAssignment> getFacultyassignments() {
        return facultyassignments;
    }

    public int getFeedbackSize() {
        int sum = 0;
        for (FacultyAssignment fa : facultyassignments) {
            sum += fa.getCourseoffer().getFeedBackSize();
        }
        return sum;
    }

    public double getFreshLevelRate() {
        double sum = 0.;
        int n=0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getFreshLevelRate();
                n++;
            }
        }
        return sum / n;
    }

    public double getIndustryTrendsAlignmentRate() {
        double sum = 0.;
        int n=0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getIndustryTrendsAlignmentRate();
                n++;
            }
        }
        return sum / n;
    }

    public double getOverallRate() {
        double sum = 0.;
        int n=0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getOverallRate();
                n++;
            }
        }
        return sum / n;
    }

    public double getScore() {
        double sum = 0.;
        int n=0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getScore();
                n++;
            }
        }
        return sum / n;
    }
    
    public int getStudentExpectedFutureSalary() throws Exception {
        int sum = 0;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getEmployments().size() > 0) {
                sum += fa.getCourseoffer().getExpectedFutureSalary();
                n++;
            }
        }
        if (n > 0) {
            return sum / n;
        } else {
            throw new Exception("Student Expected Future Salary not Avaliable");
        }
    }
}
