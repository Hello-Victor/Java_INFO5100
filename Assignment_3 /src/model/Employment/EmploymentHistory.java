/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Employment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;
import model.Employer.EmployerProfile;
import model.Persona.StudentProfile;

/**
 *
 * @author aeloyq
 */
public class EmploymentHistory {

    StudentProfile studentProfile;
    TreeSet<PromotionHistory> employments;

    public EmploymentHistory(EmployerProfile firstEmployerProfile, StudentProfile studentProfile, int startYear, String startTitle, int startSalary) {
        this.employments = new TreeSet<PromotionHistory>(Comparator.comparing(PromotionHistory::getFirstYear));
        this.studentProfile = studentProfile;
        PromotionHistory firstPromotionHistory = new PromotionHistory(this, firstEmployerProfile, studentProfile, startYear, startTitle, startSalary);
        employments.add(firstPromotionHistory);
        firstEmployerProfile.getCompany().addPromotionHistory(firstPromotionHistory);
    }

    public TreeSet<PromotionHistory> getEmployments() {
        return employments;
    }

    public int getJobHopTimes() {
        return employments.size() - 1;
    }

    public int getPromotionTimes() {
        int sum = 0;
        for (PromotionHistory ph : employments) {
            sum += ph.getPromotionTimes();
        }
        return sum / employments.size();
    }

    public int getAverageSalary() {
        int sum = 0;
        for (PromotionHistory ph : employments) {
            sum += ph.getAverageSalary();
        }
        return sum / employments.size();
    }

    public int getLatestSalary() {
        return employments.last().getLastPosition().getSalary();
    }

    public PromotionHistory getFirstCompany() {
        return employments.first();
    }

    public PromotionHistory getLastCompany() {
        return employments.last();
    }

    public void editLastEmployment(String newTitle, int newSalary) {
        Employment lastEmployment = employments.last().getPromotionHistorySet().last();
        lastEmployment.setTitle(newTitle);
        lastEmployment.setSalary(newSalary);
    }

    public ArrayList<Employment> getAllEmployments() {
        ArrayList<Employment> eList = new ArrayList<Employment>();
        for (PromotionHistory ph : employments) {
            for (Employment e : ph.getPromotionHistorySet()) {
                eList.add(e);
            }
        }
        return eList;
    }

    public void removeLastEmployment() {
        PromotionHistory lastPromotionHistory = employments.last();
        if (lastPromotionHistory.getPromotionTimes() == 0) {
            employments.remove(lastPromotionHistory);
            lastPromotionHistory.getEmployerProfile().getCompany().removePromotionHistory(lastPromotionHistory);
            if (employments.size() == 0) {
                studentProfile.setEmploymenthistory(null);
            }
        }
        lastPromotionHistory.removeEmployment(lastPromotionHistory.getLastPosition());
    }

    public void removeLastCompany() {
        PromotionHistory lastPromotionHistory = employments.last();
        employments.remove(lastPromotionHistory);
        lastPromotionHistory.getEmployerProfile().getCompany().removePromotionHistory(lastPromotionHistory);
        if (employments.size() == 0) {
            studentProfile.setEmploymenthistory(null);
        }
    }

    public double getWeight() {
        return (double) (getLatestSalary() + getAverageSalary()) / 200000.0 + getPromotionTimes() + getJobHopTimes();
    }

    public void jobHop(EmployerProfile newEmployerProfile, int hopYear, String newTitle, int newSalary) {
        PromotionHistory newPromotionHistory = new PromotionHistory(this, newEmployerProfile, studentProfile, hopYear, newTitle, newSalary);
        employments.add(newPromotionHistory);
        newEmployerProfile.getCompany().addPromotionHistory(newPromotionHistory);
    }

    public void promote(int promoteYear, String newTitle, int newSalary) {
        employments.last().promote(promoteYear, newTitle, newSalary);
    }

}
