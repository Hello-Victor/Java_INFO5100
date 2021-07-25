/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employee.Employee;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class Customer extends Employee{
    private String name;
    private String phone;
    private String address;
    private List<OrderWorkRequest> carts=new ArrayList<>();

    public Customer(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public List<OrderWorkRequest> getCarts() {
        return carts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    

    
    
    

    
    
    
    
    
    
    
    
    
}
