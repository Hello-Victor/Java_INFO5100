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
public class Seat {

    Boolean occupied;
    int number;
    SeatAssignment seatassignment;
    CourseOffer courseoffer;
    CourseLoad courseLoad;
    Double grade = null;
    Feedback feedback = null;

    public Seat(CourseOffer co, int n) {
        courseoffer = co;
        number = n;
        occupied = false;

    }

    public Boolean isOccupied() {
        return occupied;

    }

    public SeatAssignment newSeatAssignment() {

        seatassignment = new SeatAssignment(); //links seatassignment to seat
        seatassignment.setSeat(this);
        occupied = true;
        return seatassignment;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public CourseLoad getCourseLoad() {
        return courseLoad;
    }

    public void setCourseLoad(CourseLoad courseLoad) {
        this.courseLoad = courseLoad;
    }

    public SeatAssignment getSeatassignment() {
        return seatassignment;
    }

    public void setSeatassignment(SeatAssignment seatassignment) {
        this.seatassignment = seatassignment;
    }

    public CourseOffer getCourseoffer() {
        return courseoffer;
    }

    public void setCourseoffer(CourseOffer courseoffer) {
        this.courseoffer = courseoffer;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public void setFeedback(int freshLevelRate, int industryTrendsAlignmentRate, int overallRate) {
        this.feedback = new Feedback(freshLevelRate, industryTrendsAlignmentRate, overallRate);
    }

    @Override
    public String toString() {
        return courseLoad.getStudentProfile().getPerson().getId();
    }

}
