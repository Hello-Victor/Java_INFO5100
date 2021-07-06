/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Company;

import java.util.HashMap;
import model.Persona.Account;
import model.Persona.AccountDirectory;
import model.Persona.Person;

/**
 *
 * @author aeloyq
 */
public class CompanyDirectory {

    HashMap<String, Company> companyMap = new HashMap<String, Company>();
    static CompanyDirectory companyDirectory = null;

    private CompanyDirectory() {
    }

    public static CompanyDirectory getInstance() {
        if (CompanyDirectory.companyDirectory == null) {
            CompanyDirectory companyDirectory = new CompanyDirectory();
            CompanyDirectory.companyDirectory = companyDirectory;
        }
        return CompanyDirectory.companyDirectory;
    }

    public Company newCompany(String name, String Introduction, String Address) {
        try {
            Company cp = new Company(name, Introduction, Address, null);
            Account account = AccountDirectory.getInstance().newAccount(name, "admin", cp);
            companyMap.put(cp.getId(), cp);
            cp.setAccount(account);
            return cp;

        } catch (Exception ex) {
            return null;
        }

    }

    public Company findTeachingFaculty(String id) {
        return companyMap.get(id); //not found after going through the whole list
    }

    public void removeCompany(String id) {
        companyMap.remove(id);
    }

    public HashMap<String, Company> getCompanyMap() {
        return companyMap;
    }
}
