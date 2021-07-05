/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseSchedule;

/**
 *
 * @author kal bugrara
 */
public class Seat {

    Boolean occupied;
    int number;
    SeatAssignment seatassignment;
    CourseOffer courseoffer;
    double grade;

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
        occupied = true;
        return seatassignment;
    }

    public Boolean getOccupied() {
        return occupied;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

}
