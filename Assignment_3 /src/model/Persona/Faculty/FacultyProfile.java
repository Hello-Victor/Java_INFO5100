/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona.Faculty;

import model.Persona.*;
import model.CourseSchedule.CourseOffer;
import java.util.ArrayList;
import model.Department.Department;

/**
 *
 * @author kal bugrara
 */
public class FacultyProfile extends Profile {

    Department department;
    ArrayList<FacultyAssignment> facultyassignments;

    public FacultyProfile(Person p, Department d) {
        super(p);
        department = d;
        facultyassignments = new ArrayList();
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co) {

        facultyassignments.add(co.getFacultyassignment());

        return co.getFacultyassignment();
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

    public Department getDepartment() {
        return department;
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

    public Double getFreshLevelRate() {
        Double sum = 0.;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getFreshLevelRate();
                n++;
            }
        }
        return sum / n;
    }

    public Double getIndustryTrendsAlignmentRate() {
        Double sum = 0.;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getIndustryTrendsAlignmentRate();
                n++;
            }
        }
        return sum / n;
    }

    public Double getOverallRate() {
        Double sum = 0.;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getOverallRate();
                n++;
            }
        }
        return sum / n;
    }

    public Double getScore() {
        Double sum = 0.;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getFeedBackSize() > 0) {
                sum += fa.getCourseoffer().getScore();
                n++;
            }
        }
        return sum / n;
    }

    public Double getGrade() {
        Double sum = 0.;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            Double g = fa.getCourseoffer().getGrade();
            if (!Double.isNaN(g)) {
                sum += g;
                n++;
            }
        }
        return sum / n;
    }

    public int getExpectedFutureSalary() {
        int sum = 0;
        int n = 0;
        for (FacultyAssignment fa : facultyassignments) {
            if (fa.getCourseoffer().getEmployments().size() > 0) {
                sum += fa.getCourseoffer().getExpectedFutureSalary();
                n++;
            }
        }

        if (n == 0) {
            return -1;
        }
        return sum / n;
    }

    public double getWeight() {
        return getScore();
    }

    @Override
    public String toString() {
        return person.getId();
    }

}
