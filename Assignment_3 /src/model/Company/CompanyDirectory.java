/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Company;

import java.util.HashMap;
import javax.swing.text.html.parser.DTDConstants;
import model.College.College;
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

    public class CompanyNameConflictException extends Exception {
    };

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

    public Company newCompany(String name, String Introduction, String Address, String userName, String password) throws AccountDirectory.AccountNameConflictException, CompanyNameConflictException {
        if (companyMap.containsKey(name)) {
            throw new CompanyNameConflictException();
        }
        Company cp = new Company(name, Introduction, Address, null);
        Account account = AccountDirectory.getInstance().newAccount(userName, password, cp);
        companyMap.put(cp.getId(), cp);
        cp.setAccount(account);
        return cp;

    }

    public Company findTeachingFaculty(String id) {
        return companyMap.get(id); //not found after going through the whole list
    }

    public void removeCompany(String id) {
        AccountDirectory.getInstance().removeAccount(companyMap.get(id).getAccount().getUserName());
        companyMap.remove(id);
    }

    public void modifyCompany(Company company, String name, String Introduction, String Address, String userName, String password) throws AccountDirectory.AccountNameConflictException, CompanyNameConflictException {
        if (!name.equals(company.getName()) && companyMap.containsKey(name)) {
            throw new CompanyNameConflictException();
        }
        company.setName(name);
        company.setIntroduction(Introduction);
        company.setAddress(Address);
        AccountDirectory.getInstance().modifyAccountName(company.getAccount(), userName, password);
    }

    public HashMap<String, Company> getCompanyMap() {
        return companyMap;
    }
    
}
