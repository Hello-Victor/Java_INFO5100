/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Company;

import model.Employer.EmployerDirectory;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.PersonDirectory;
import model.Persona.Profile;
import org.w3c.dom.css.Counter;

/**
 *
 * @author aeloyq
 */
public class Company  extends Profile{

    String name;
    Account account;
    String Introduction;
    String Address;
    String id;
    EmployerDirectory employerDirectory = new EmployerDirectory(PersonDirectory.getInstance(), AccountDirectory.getInstance());
    static int count = 0;

    public Company(String Name, String Introduction, String Address, Account account) {
        super(null, account);
        count++;
        this.name = Name;
        this.Introduction = Introduction;
        this.Address = Address;
        this.id = this.id = String.format("%08d", count);
    }

    public String getName() {
        return name;
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

}
