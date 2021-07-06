/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Employment;

import java.util.ArrayList;
import java.util.Date;
import model.CourseSchedule.CourseOffer;

import model.Employer.EmployerProfile;

/**
 *
 * @author aeloyq
 */
public class Employment {

    ArrayList<CourseOffer> relevantcourseoffers;
    EmployerProfile employerProfile;
    int year;
    String title;
    int salary;

    public Employment(EmployerProfile employerProfile, int year, String title, int salary) {
        this.employerProfile = employerProfile;
        this.year = year;
        this.title = title;
        this.salary = salary;
    }

    public ArrayList<CourseOffer> getRelevantcourseoffers() {
        return relevantcourseoffers;
    }

    public EmployerProfile getEmployerProfile() {
        return employerProfile;
    }

    public void setEmployerProfile(EmployerProfile employerProfile) {
        this.employerProfile = employerProfile;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}
