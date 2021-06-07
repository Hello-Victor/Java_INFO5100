/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import pojo.MR;

/**
 *
 * @author Administrator
 */
public class MRDao {
      private ArrayList<MR> mr; 
    
    
   public MRDao(){
       this.mr = new ArrayList();
   }
   
   public ArrayList<MR> getMR(){
       return this.mr;
   }
   
  
   public void setMR(ArrayList mr){
       this.mr = mr;
   }
   
   
   public MR addMR(){
      
       MR mr1 = new MR();
       
       this.mr.add(mr1);
     
       return mr1;
   }
   

   public void deletAdd(MR add){
       mr.remove(add);
   }
}
