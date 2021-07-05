/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import model.CourseSchedule.CourseLoad;
import model.Employment.EmploymentHistory;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile extends Profile {

    Transcript transcript;
    EmploymentHistory employmenthistory=null;

    public StudentProfile() {
    }

    public StudentProfile(Person p) {
        super(p);
        transcript = new Transcript();
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

    public boolean isGraduated() {
        return employmenthistory==null;
    }
    
    public double getGPA(){
        return transcript.getGPA();
    }
    
    public int totalCredits(){
        return transcript.totalCredits();
    }
    
}
