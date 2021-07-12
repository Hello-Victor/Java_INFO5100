/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Employment;

import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;
import model.Employer.EmployerProfile;
import model.Persona.StudentProfile;

/**
 *
 * @author aeloyq
 */
public class PromotionHistory {

    EmploymentHistory employmentHistory;
    StudentProfile studentProfile;
    EmployerProfile employerProfile;
    TreeSet<Employment> promotionHistorySet = new TreeSet<Employment>(Comparator.comparing(Employment::getYear));

    public PromotionHistory(EmploymentHistory employmentHistory, EmployerProfile employerProfile, StudentProfile studentProfile, int startYear, String startTitle, int startSalary) {
        this.employerProfile = employerProfile;
        this.studentProfile = studentProfile;
        promotionHistorySet.add(new Employment(employerProfile, startYear, startTitle, startSalary));
    }

    public EmploymentHistory getEmploymentHistory() {
        return employmentHistory;
    }

    public EmployerProfile getEmployerProfile() {
        return employerProfile;
    }

    public TreeSet<Employment> getPromotionHistorySet() {
        return promotionHistorySet;
    }

    public void promote(int promoteYear, String newTitle, int newSalary) {
        promotionHistorySet.add(new Employment(employerProfile, promoteYear, newTitle, newSalary));
    }

    public void removeEmployment(Employment employment) {
        promotionHistorySet.remove(employment);
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public int getFirstYear() {
        return promotionHistorySet.first().getYear();
    }

    public int getLastYear() {
        return promotionHistorySet.last().getYear();
    }

    public Employment getFirstPosotion() {
        return promotionHistorySet.first();
    }

    public Employment getLastPosition() {
        return promotionHistorySet.last();
    }

    public int getPromotionTimes() {
        return promotionHistorySet.size() - 1;
    }

    public int getAverageSalary() {
        int sum = 0;
        for (Employment e : promotionHistorySet) {
            sum += e.getSalary();
        }
        return sum / promotionHistorySet.size();
    }

    public int getLatestSalary() {
        return promotionHistorySet.last().getSalary();
    }

    public double getWeight() {
        return (getLatestSalary() + getAverageSalary()) / 200000. + getPromotionTimes();
    }
}
