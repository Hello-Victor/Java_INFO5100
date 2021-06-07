/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.List;
import java.util.ArrayList;
import pojo.CPi;

 
/**
 *
 * @author Administrator
 */
public class CpiDao{

     private ArrayList<CPi> cpiDao; 
    
     
   public CpiDao(){
       this.cpiDao = new ArrayList();
   }

   public ArrayList<CPi> getCPi(){
       return this.cpiDao;
   }
  
   public void setCPi(ArrayList cpiDao){
       this.cpiDao = cpiDao;
   }
   
 
   public CPi addCPi(){
       
       CPi cpiDao1 = new CPi();
       
       this.cpiDao.add(cpiDao1);
       
       return cpiDao1;
   }
   
   
   public void deletAdd(CPi cpi){
       cpiDao.remove(cpi);
   }
}
