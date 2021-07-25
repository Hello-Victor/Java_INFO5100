/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.menu;

import Business.Customer.*;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.LoginSession;
import Business.Restaurant.Restaurant;
import Business.Role.CustomerRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class MenuDirectory {
    private List<Menu> menus=new ArrayList<>();
    
    
    public Menu createNewMenu(Restaurant restaurant,String name,String price,String  materail){
        
        Menu menu = new Menu(restaurant,name,price,materail);
        menus.add(menu);
        return menu;
        
       
        
    }

    public List<Menu> getMenus() {
        return menus;
    }
    
    

    
    
    
    
    
    
        
    
}
