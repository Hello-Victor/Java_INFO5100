/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CourseSchedule.CourseOffer;
import model.Employer.EmployerDirectory;
import model.Employer.EmployerProfile;
import model.Employment.Employment;
import model.Employment.PromotionHistory;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.Person;
import model.Persona.PersonDirectory;
import model.Persona.Profile;
import model.Persona.StudentProfile;
import org.w3c.dom.css.Counter;

/**
 *
 * @author aeloyq
 */
public class Company extends Profile {

    String name;
    Account account;
    String Introduction;
    String Address;
    String id;
    EmployerDirectory employerDirectory;
    ArrayList<PromotionHistory> promotionHistories = new ArrayList<PromotionHistory>();
    static int count = 0;

    public Company() {
    }

    public Company(String Name, String Introduction, String Address, Account account) {
        super(null, account);
        count++;
        this.name = Name;
        this.Introduction = Introduction;
        this.Address = Address;
        this.id = String.format("%08d", count);
        employerDirectory = new EmployerDirectory(this);
        try {
            EmployerProfile employer = employerDirectory.newEmployerProfile(new Person(), Name + "_default_account", "admin");
            employerDirectory.getEmployerMap().put("default", employer);
        } catch (AccountDirectory.AccountNameConflictException ex) {
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<PromotionHistory> getPromotionHistoriesArrayList() {
        return promotionHistories;
    }

    public void addPromotionHistory(PromotionHistory ph) {
        promotionHistories.add(ph);
    }

    public void removePromotionHistory(PromotionHistory ph) {
        promotionHistories.remove(ph);
    }

    public Double getWeight() {
        Double sum = 0.;
        int n = 0;
        for (PromotionHistory ph : promotionHistories) {
            sum += ph.getWeight();
            n++;
        }
        return sum / n;
    }

    public int getAverageSalary() {
        int sum = 0;
        int n = 0;
        for (PromotionHistory ph : promotionHistories) {
            sum += ph.getAverageSalary();
            n++;
        }
        return n == 0 ? 0 : sum / n;
    }

    public Double getAveragePromotionTimes() {
        Double sum = 0.;
        int n = 0;
        for (PromotionHistory ph : promotionHistories) {
            sum += ph.getPromotionTimes();
            n++;
        }
        return sum / n;
    }

    public Double getGPA() {
        Double sum = 0.;
        int n = 0;
        for (PromotionHistory ph : promotionHistories) {
            sum += ph.getStudentProfile().getGPA();
            n++;
        }
        return sum / n;
    }

    public HashSet<CourseOffer> getRelatedCourseSet() {
        HashSet<CourseOffer> cos = new HashSet<CourseOffer>();
        for (PromotionHistory ph : promotionHistories) {
            for (Employment e : ph.getPromotionHistorySet()) {
                for (CourseOffer co : e.getRelevantcourseoffers()) {
                    cos.add(co);
                }
            }
        }
        return cos;
    }

    public Double getRelatedCourseScore() {
        Double sum = 0.;
        int n = 0;
        for (CourseOffer co : getRelatedCourseSet()) {
            Double s = co.getScore();
            if (!Double.isNaN(s)) {
                sum += co.getScore();
                n++;
            }
        }
        return sum / n;
    }

    public ArrayList<StudentProfile> getStudentList() {
        ArrayList<StudentProfile> students = new ArrayList<StudentProfile>();
        for (PromotionHistory ph : promotionHistories) {
            if (ph.getEmployerProfile().getCompany() == this) {
                students.add(ph.getStudentProfile());
            }
        }
        return students;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String Introduction) {
        this.Introduction = Introduction;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public EmployerDirectory getEmployerDirectory() {
        return employerDirectory;
    }

    public void setEmployerDirectory(EmployerDirectory employerDirectory) {
        this.employerDirectory = employerDirectory;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

}
