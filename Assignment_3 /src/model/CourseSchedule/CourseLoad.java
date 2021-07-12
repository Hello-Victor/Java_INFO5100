/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseSchedule;

import java.util.ArrayList;
import model.Persona.StudentProfile;

/**
 *
 * @author kal bugrara
 */
public class CourseLoad {

    String semester;
    StudentProfile studentProfile;
    ArrayList<SeatAssignment> seatassignments;

    public CourseLoad(String s, StudentProfile sp) {
        seatassignments = new ArrayList<SeatAssignment>();
        studentProfile = sp;
        semester = s;
    }

    public SeatAssignment newSeatAssignment(CourseOffer co) {

        Seat seat = co.getEmptySeat(); // seat linked to courseoffer
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment();
        seat.setCourseLoad(this);
        seatassignments.add(sa);  //add to students course 

        return sa;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void registerStudent(SeatAssignment sa) {

        sa.assignSeatToStudent(this);
        seatassignments.add(sa);
    }

    public String getSemester() {
        return semester;
    }

    public ArrayList<SeatAssignment> getSeatassignments() {
        return seatassignments;
    }

    public Double totalGrade() {
        Double sum = 0.;
        for (SeatAssignment ss : seatassignments) {
            Seat st = ss.getSeat();
            if (st.getGrade() != null) {
                sum += st.getGrade() * st.getCourseoffer().getCourse().getCredits();
            }
        }
        return sum;
    }

    public int totalCredit() {
        int sum = 0;
        for (SeatAssignment ss : seatassignments) {
            Seat st = ss.getSeat();
            if (st.getGrade() != null) {
                sum += st.getCourseoffer().getCourse().getCredits();
            }
        }
        return sum;
    }

    public double getGPA() {
        return totalGrade() / totalCredit();
    }

}
