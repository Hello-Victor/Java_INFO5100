/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.List;
import java.util.ArrayList;
import pojo.Address;

 
/**
 *
 * @author Administrator
 */
public class AddressDaoImp{

     private ArrayList<Address> address; 
    
     
   public AddressDaoImp(){
       this.address = new ArrayList();
   }
   
   public ArrayList<Address> getAddress(){
       return this.address;
   }
   
 
   public void setAddress(ArrayList address){
       this.address = address;
   }

   public Address addAddress(){
    
       Address address1 = new Address();
     
       this.address.add(address1);
       
       return address1;
   }
   
  
   public void deletAdd(Address add){
       address.remove(add);
   }
}
