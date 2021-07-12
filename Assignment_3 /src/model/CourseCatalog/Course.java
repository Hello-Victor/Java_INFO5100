/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CourseCatalog;

import java.util.ArrayList;
import model.CourseSchedule.CourseOffer;
import model.Persona.Faculty.FacultyProfile;

/**
 *
 * @author kal bugrara
 */
public class Course {

    String number;
    String name;
    int credits;
    int price = 1500; //per credit hour
    ArrayList<CourseOffer> courseOffers = new ArrayList<CourseOffer>();

    public Course(String n, String numb, int ch) {
        name = n;
        number = numb;
        credits = ch;
    }

    public String getCourseNumber() {
        return number;
    }

    public int getCoursePrice() {
        return price * credits;

    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getPrice() {
        return price;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<CourseOffer> getCourseOffers() {
        return courseOffers;
    }

    public Double getFreshLevelRate() {
        // check size first
        Double sum = 0.0;
        int size = 0;
        for (CourseOffer co : courseOffers) {
            for (Feedback f : co.getFeedbacks()) {
                sum += f.getFreshLevelRate();
                size++;
            }
        }
        return sum / size;
    }

    public Double getIndustryTrendsAlignmentRate() {
        // check size first
        Double sum = 0.0;
        int size = 0;
        for (CourseOffer co : courseOffers) {
            for (Feedback f : co.getFeedbacks()) {
                sum += f.getIndustryTrendsAlignmentRate();
                size++;
            }
        }
        return sum / size;
    }

    public Double getOverallRate() {
        // check size first
        Double sum = 0.0;
        int size = 0;
        for (CourseOffer co : courseOffers) {
            for (Feedback f : co.getFeedbacks()) {
                sum += f.getOverallRate();
                size++;
            }
        }
        return sum / size;
    }

    public Double getScore() {
        // check size first
        Double sum = 0.0;
        int size = 0;
        for (CourseOffer co : courseOffers) {
            for (Feedback f : co.getFeedbacks()) {
                sum += f.getScore();
                size++;
            }
        }
        return sum / size;
    }

    public Double getGrade() {
        // check size first
        Double sum = 0.0;
        int size = 0;
        for (CourseOffer co : courseOffers) {
            Double g = co.getGrade();
            if (!Double.isNaN(g)) {
                sum += g;
                size++;
            }
        }
        return sum / size;
    }

    public int getFeedBackSize() {
        int size = 0;
        for (CourseOffer co : courseOffers) {
            size += co.getFeedbacks().size();
        }
        return size;
    }

    public int getExpectedFutureSalary() {
        int sum = 0;
        int n = 0;
        for (CourseOffer co : courseOffers) {
            if (co.getEmployments().size() > 0) {
                sum += co.getExpectedFutureSalary();
                n++;
            }
        }
        if (n == 0) {
            return -1;
        }
        return sum / n;
    }

    @Override
    public String toString() {
        return number;
    }
}
