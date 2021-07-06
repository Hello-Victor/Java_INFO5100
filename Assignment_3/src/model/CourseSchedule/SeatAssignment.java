/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseSchedule;

import model.CourseCatalog.Feedback;

/**
 *
 * @author kal bugrara
 */
public class SeatAssignment {

    Seat seat;
    Feedback feedback = null;
    CourseLoad courseload;

    public SeatAssignment(CourseLoad cl, Seat s) {
        seat = s;
        courseload = cl;
    }

    public SeatAssignment() {

    }

    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setCourseload(CourseLoad courseload) {
        this.courseload = courseload;
    }

    public Seat getSeat() {
        return seat;
    }

    public CourseLoad getCourseload() {
        return courseload;
    }

    public void setFeedback(int freshLevelRate, int industryTrendsAlignmentRate, int overallRate) {
        if (feedback != null) {
            seat.getCourseoffer().removeFeedback(feedback);
        }
        feedback = new Feedback(freshLevelRate, industryTrendsAlignmentRate, overallRate);
        seat.getCourseoffer().addFeedback(feedback);
    }

    public Feedback getFeedback() {
        return feedback;
    }

}
