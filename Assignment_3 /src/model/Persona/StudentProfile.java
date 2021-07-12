/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import model.CourseSchedule.CourseLoad;
import model.CourseSchedule.SeatAssignment;
import model.Department.Department;
import model.Employer.EmployerProfile;
import model.Employment.EmploymentHistory;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    Department department;
    Transcript transcript;
    EmploymentHistory employmenthistory = null;

    public StudentProfile() {
    }

    public StudentProfile(Person p, Department d) {
        super(p);
        department = d;
        transcript = new Transcript(this);
    }

    public Department getDepartment() {
        return department;
    }

    public void setEmploymenthistory(EmploymentHistory employmenthistory) {
        this.employmenthistory = employmenthistory;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public EmploymentHistory getEmploymenthistory() {
        return employmenthistory;
    }

    public EmploymentHistory setFirstEmployment(EmployerProfile firstEmployerProfile, int startYear, String startTitle, int startSalary) {
        transcript.graduate();
        employmenthistory = new EmploymentHistory(firstEmployerProfile, this, startYear, startTitle, startSalary);
        return employmenthistory;
    }

    public boolean isGraduated() {
        return employmenthistory != null;
    }

    public boolean readyToGraduated() {
        int count = 8;
        for (CourseLoad cl : transcript.getCourseloadlist().values()) {
            for (SeatAssignment sa : cl.getSeatassignments()) {
                if (sa.getSeat().getGrade() == null) {
                    return false;
                }
                count++;
            }
        }
        return count == 8;
    }

    public double getGPA() {
        return transcript.getGPA();
    }

    public int totalCredits() {
        return transcript.totalCredits();
    }

    public double getAcademicWeight() {
        return getGPA();
    }

    public double getIndustialWeight() {
        return employmenthistory.getWeight();
    }

    @Override
    public String toString() {
        return person.getId();
    }

}
