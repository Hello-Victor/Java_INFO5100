/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import pojo.Sai;

/**
 *
 * @author Administrator
 */
public class SaiDao {
    
     private ArrayList<Sai> sai; 
    
     
   public SaiDao(){
       this.sai = new ArrayList();
   }
   
   public ArrayList<Sai> getSai(){
       return this.sai;
   }
   
 
   public void setSai(ArrayList sai){
       this.sai = sai;
   }
 
   public Sai addSai(){
       
       Sai sai1 = new Sai();
       
       this.sai.add(sai1);
     
       return sai1;
   }
   
  
   public void deletAdd(Sai add){
       sai.remove(add);
   }
}
