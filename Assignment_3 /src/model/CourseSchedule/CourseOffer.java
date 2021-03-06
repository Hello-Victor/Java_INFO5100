/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseSchedule;

import model.CourseCatalog.Course;
import model.Persona.Faculty.FacultyAssignment;
import model.Persona.Faculty.FacultyProfile;
import java.util.ArrayList;
import model.CourseCatalog.Feedback;
import model.Employment.Employment;

/**
 *
 * @author kal bugrara
 */
public class CourseOffer {

    Course course;
    CourseSchedule courseSchedule;
    ArrayList<Seat> seatlist;
    FacultyAssignment facultyassignment;
    ArrayList<Employment> employments = new ArrayList<Employment>();

    public CourseOffer(Course c, CourseSchedule cs) {
        course = c;
        courseSchedule = cs;
        seatlist = new ArrayList();
    }

    public FacultyAssignment assignAsTeacher(FacultyProfile fp) {

        facultyassignment = new FacultyAssignment(fp, this);
        fp.AssignAsTeacher(this);
        return facultyassignment;
    }

    public FacultyProfile getFacultyProfile() {
        return facultyassignment.getFacultyProfile();
    }

    public String getCourseNumber() {
        return course.getCourseNumber();
    }

    public void generatSeats(int n) {

        for (int i = 0; i < n; i++) {

            seatlist.add(new Seat(this, i));

        }

    }

    public Seat getEmptySeat() {

        for (Seat s : seatlist) {

            if (!s.isOccupied()) {
                return s;
            }
        }
        return null;
    }

    public SeatAssignment assignEmptySeat(CourseLoad cl) {

        Seat seat = getEmptySeat();
        if (seat == null) {
            return null;
        }
        SeatAssignment sa = seat.newSeatAssignment(); //seat is already linked to course offer
        cl.registerStudent(sa); //coures offer seat is now linked to student
        return sa;
    }

    public int numStudent() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (s.occupied) {
                sum++;
            }
        }
        return sum;

    }

    public int numSeats() {
        return seatlist.size();
    }

    public int numEmptySeats() {
        int sum = 0;
        for (Seat s : seatlist) {
            if (!s.occupied) {
                sum++;
            }
        }
        return sum;
    }

    public int getTotalCourseRevenues() {

        int sum = 0;

        for (Seat s : seatlist) {
            if (s.isOccupied() == true) {
                sum = sum + course.getCoursePrice();
            }

        }
        return sum;
    }

    public Course getCourse() {
        return course;
    }

    public CourseSchedule getCourseSchedule() {
        return courseSchedule;
    }

    public Double getFreshLevelRate() {
        // check size first
        ArrayList<Feedback> feedbacks = getFeedbacks();
        Double sum = 0.0;
        for (Feedback f : feedbacks) {
            sum += f.getFreshLevelRate();
        }
        return sum / feedbacks.size();
    }

    public Double getIndustryTrendsAlignmentRate() {
        // check size first
        ArrayList<Feedback> feedbacks = getFeedbacks();
        Double sum = 0.0;
        for (Feedback f : feedbacks) {
            sum += f.getIndustryTrendsAlignmentRate();
        }
        return sum / feedbacks.size();
    }

    public Double getOverallRate() {
        // check size first
        ArrayList<Feedback> feedbacks = getFeedbacks();
        Double sum = 0.0;
        for (Feedback f : feedbacks) {
            sum += f.getOverallRate();
        }
        return sum / feedbacks.size();
    }

    public Double getScore() {
        // check size first
        ArrayList<Feedback> feedbacks = getFeedbacks();
        Double sum = 0.0;
        for (Feedback f : feedbacks) {
            sum += f.getScore();
        }
        return sum / feedbacks.size();
    }

    public ArrayList<Feedback> getFeedbacks() {
        ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                if (s.getFeedback() != null) {
                    feedbacks.add(s.getFeedback());
                }
            }
        }
        return feedbacks;
    }

    public int getFeedBackSize() {
        return getFeedbacks().size();
    }

    public void addEmployment(Employment e) {
        employments.add(e);
    }

    public void removeEmployment(Employment e) {
        employments.remove(e);
    }

    public ArrayList<Seat> getSeatlist() {
        return seatlist;
    }

    public FacultyAssignment getFacultyassignment() {
        return facultyassignment;
    }

    public ArrayList<Employment> getEmployments() {
        return employments;
    }

    public Double getGrade() {
        Double sum = 0.;
        int n = 0;
        for (Seat s : seatlist) {
            if (s.isOccupied()) {
                Double g = s.getGrade();
                if (g != null) {
                    sum += g;
                    n++;
                }
            }
        }
        return sum / n;
    }

    public int getExpectedFutureSalary() {
        int sum = 0;
        for (Employment e : employments) {
            sum += e.getSalary();
        }
        return sum / employments.size();
    }

    @Override
    public String toString() {
        return course.getCourseNumber();
    }

}
