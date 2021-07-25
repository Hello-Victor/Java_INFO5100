/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Role.CustomerRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    private List<Customer> customers=new ArrayList<>();
    
    public UserAccount createNewCustomer(String name,String userName,String password){
        
        Customer customer = new Customer(name);
        customers.add(customer);
        EcoSystem system = EcoSystem.getInstance();
        UserAccount createUserAccount = system.getUserAccountDirectory().createUserAccount(userName, password, customer, new CustomerRole());
        return createUserAccount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    
    
    
    
    
    
        
    
}
