/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import model.CourseSchedule.CourseLoad;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import model.CourseCatalog.Course;
import model.CourseSchedule.SeatAssignment;

/**
 *
 * @author kal bugrara
 */
public class Transcript {

    StudentProfile studentProfile;

    LinkedHashMap<String, CourseLoad> courseloadlist;

    CourseLoad currentcourseload;

    public Transcript(StudentProfile s) {
        studentProfile = s;
        courseloadlist = new LinkedHashMap<String, CourseLoad>();

    }

    public CourseLoad newCourseLoad(String sem) {

        currentcourseload = new CourseLoad(sem, studentProfile);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }

    public CourseLoad getCurrentCourseLoad() {

        return currentcourseload;

    }

    public LinkedHashMap<String, CourseLoad> getCourseloadlist() {
        return courseloadlist;
    }

    public boolean isCourseSelected(Course c) {
        for (CourseLoad cl : courseloadlist.values()) {
            for (SeatAssignment sa : cl.getSeatassignments()) {
                if (sa.getSeat().getCourseoffer().getCourse() == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public void graduate() {
        currentcourseload = null;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {
        return courseloadlist.get(semester);
    }

    public double getGPA() {
        double gsum = 0.;
        int csum = 0;
        for (CourseLoad cl : courseloadlist.values()) {
            csum += cl.totalCredit();
            gsum += cl.totalGrade();
        }
        return gsum / csum;
    }

    public int totalCredits() {
        int csum = 0;
        for (CourseLoad cl : courseloadlist.values()) {
            csum += cl.totalCredit();
        }
        return csum;
    }

}
