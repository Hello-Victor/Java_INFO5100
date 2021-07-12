/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseSchedule;

import model.CourseCatalog.Course;
import model.CourseCatalog.CourseCatalog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    HashSet<CourseOffer> schedule = new HashSet<CourseOffer>();
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
    }

    public CourseOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        CourseOffer co = new CourseOffer(c, this);
        c.getCourseOffers().add(co);
        schedule.add(co);
        return co;
    }

    public void removeCourseOffer(CourseOffer co) {
        schedule.remove(co);
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public HashSet<CourseOffer> getSchedule() {
        return schedule;
    }

    public String getSemester() {
        return semester;
    }

    public CourseOffer getCourseOfferByNumber(String cn) {
        for (CourseOffer co : schedule) {
            if (co.getCourseNumber() == cn) {
                return co;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return semester;
    }

}
