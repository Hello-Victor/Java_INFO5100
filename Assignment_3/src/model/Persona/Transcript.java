/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import model.CourseSchedule.CourseLoad;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class Transcript {

    HashMap<String, CourseLoad> courseloadlist;

    CourseLoad currentcourseload;

    public Transcript() {

        courseloadlist = new HashMap<String, CourseLoad>();

    }

    public CourseLoad newCourseLoad(String sem) {

        currentcourseload = new CourseLoad(sem);
        courseloadlist.put(sem, currentcourseload);
        return currentcourseload;
    }

    public CourseLoad getCurrentCourseLoad() {

        return currentcourseload;

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
