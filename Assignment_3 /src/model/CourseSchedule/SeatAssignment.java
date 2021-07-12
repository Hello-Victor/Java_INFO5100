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
    CourseLoad courseload;

    public SeatAssignment(CourseLoad cl, Seat s) {
        seat = s;
        s.setCourseLoad(courseload);
        s.setSeatassignment(this);
        courseload = cl;
    }

    public SeatAssignment() {

    }

    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
        seat.setCourseLoad(cl);
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
        seat.setCourseLoad(courseload);
        seat.setSeatassignment(this);
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
        seat.setFeedback(new Feedback(freshLevelRate, industryTrendsAlignmentRate, overallRate));
    }

    public Feedback getFeedback() {
        return seat.getFeedback();
    }
    
    @Override
    public String toString(){
        return seat.getCourseoffer().getCourse().getCourseNumber();
    }

}
