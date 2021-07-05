/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Employer;

import java.util.ArrayList;
import model.Company.Company;
import model.Persona.Account;
import model.Persona.Person;
import model.Persona.Profile;
import model.Employment.PromotionHistory;

/**
 *
 * @author kal bugrara
 */
public class EmployerProfile extends Profile {

    Company company;
    ArrayList<PromotionHistory> employments;

    public EmployerProfile(Person p, Company c) {  //could be company instead of just a name as a string
        super(p);
        company = c;
    }

    public boolean isMatch(String id) {
        if (person.getId().equals(id)) {
            return true;             //String is an object and can do equal matach
        }
        return false;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ArrayList<PromotionHistory> getEmployments() {
        return employments;
    }

    public int getAveragePromotionTimes() {
        int sum = 0;
        for (PromotionHistory ph : employments) {
            sum += ph.getPromotionTimes();
        }
        return sum / employments.size();
    }

    public int getAverageSalary() {
        int sum = 0;
        for (PromotionHistory ph : employments) {
            sum += ph.getLatestSalary();
        }
        return sum / employments.size();
    }

}
