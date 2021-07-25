/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.Employee;
import Business.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.menu.MenuDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class Restaurant extends Organization{
    
    private String name;
    
//    private OrderDirectory orderDirectory=new OrderDirectory();
    
    private MenuDirectory menuDirectory=new MenuDirectory();

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AdminRole());
        return roles;
    }
    

    
    

    public  Restaurant(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuDirectory getMenuDirectory() {
        return menuDirectory;
    }

    public void setMenuDirectory(MenuDirectory menuDirectory) {
        this.menuDirectory = menuDirectory;
    }

//    public OrderDirectory getOrderDirectory() {
//        return orderDirectory;
//    }

    @Override
    public String toString() {
        return "Restaurant{" + "name=" + name + '}';
    }
    
    
    
    

   

   
    
}
