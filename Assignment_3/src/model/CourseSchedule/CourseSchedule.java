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

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    HashMap<String, CourseOffer> schedule = new HashMap<String, CourseOffer>();
    String semester;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
    }

    public CourseOffer newCourseOffer(String n) {

        Course c = coursecatalog.getCourseByNumber(n);
        CourseOffer co = new CourseOffer(c);
        c.getCourseOffers().add(co);
        schedule.put(c.getCourseNumber(), co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        return schedule.get(n);
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule.values()) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

}
