/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {

    private List<Restaurant> restaurants=new ArrayList<>();

    public RestaurantDirectory() {
        restaurants = new ArrayList<Restaurant>();
    }

    //Create enterprise
    public Restaurant createNewRestaurant(String name, String userName, String password) {
        Restaurant restaurant = new Restaurant(name);
        restaurants.add(restaurant);
        Employee employee=new Employee(name);
        restaurant.getUserAccountDirectory().createUserAccount(userName, password, employee, new AdminRole());
        return restaurant;
        
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
    
    

}
