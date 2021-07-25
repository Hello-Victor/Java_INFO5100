/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
    
    private List<DeliveryMan> deliverys=new ArrayList();
    
    public void createNewDelivery(String name,String userName,String password){
        
        DeliveryMan customer = new DeliveryMan(name);
        deliverys.add(customer);
        EcoSystem system = EcoSystem.getInstance();
        system.getUserAccountDirectory().createUserAccount(userName, password, customer, new DeliverManRole());
    }

    public List<DeliveryMan> getDeliverys() {
        return deliverys;
    }

    public void setDeliverys(List<DeliveryMan> deliverys) {
        this.deliverys = deliverys;
    }

   
    
    
    
}
