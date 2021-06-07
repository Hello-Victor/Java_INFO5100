/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import pojo.Dli;

/**
 *
 * @author Administrator
 */
public class DliDao {
      private ArrayList<Dli> dli; 
    
     
   public DliDao(){
       this.dli = new ArrayList();
   }
  
   public ArrayList<Dli> getDli(){
       return this.dli;
   }
   
  
   public void setDli(ArrayList dli){
       this.dli = dli;
   }
   
 
   public Dli addDli(){
       
       Dli dli1 = new Dli();
     
       this.dli.add(dli1);
       
       return dli1;
   }
   
  
   public void deletAdd(Dli add){
       dli.remove(add);
   }
}
