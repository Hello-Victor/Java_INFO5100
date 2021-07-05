/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseSchedule;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {

    String semester;
    ArrayList<SeatAssignment> seatassignments;

    public CourseLoad(String s) {
        seatassignments = new ArrayList<SeatAssignment>();
        semester = s;
    }

    public SeatAssignment newSeatAssignment(CourseOffer co) {

        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment();
        seatassignments.add(sa);  //add to students course 
        return sa;
    }

    public void registerStudent(SeatAssignment sa) {

        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }

    public double totalGrade() {
        double sum = 0.;
        for (SeatAssignment ss : seatassignments) {
            sum += ss.getSeat().getGrade() * ss.getSeat().getCourseoffer().getCourse().getCredits();
        }
        return sum;
    }

    public int totalCredit() {
        int sum = 0;
        for (SeatAssignment ss : seatassignments) {
            sum += ss.getSeat().getCourseoffer().getCourse().getCredits();
        }
        return sum;
    }

    public double getGPA() {
        return totalGrade() / totalCredit();
    }

}
