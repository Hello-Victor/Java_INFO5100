/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Employment;

import java.util.Comparator;
import java.util.TreeSet;
import model.Employer.EmployerProfile;

/**
 *
 * @author aeloyq
 */
public class EmploymentHistory {

    TreeSet<PromotionHistory> employments;

    public EmploymentHistory(EmployerProfile firstEmployerProfile, int startYear, String startTitle, int startSalary) {
        this.employments = new TreeSet<PromotionHistory>(Comparator.comparing(PromotionHistory::getFirstYear));
        PromotionHistory firstPromotionHistory = new PromotionHistory(firstEmployerProfile, startYear, startTitle, startSalary);
        employments.add(firstPromotionHistory);
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

    public void jobHop(EmployerProfile newEmployerProfile, int hopYear, String newTitle, int newSalary) {
        PromotionHistory newPromotionHistory = new PromotionHistory(newEmployerProfile, hopYear, newTitle, newSalary);
        employments.add(newPromotionHistory);
    }

    public void promote(int promoteYear, String newTitle, int newSalary) {
        employments.last().promote(promoteYear, newTitle, newSalary);
    }

}
