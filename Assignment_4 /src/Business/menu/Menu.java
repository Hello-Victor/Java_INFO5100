/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.menu;

import Business.Customer.*;
import Business.Restaurant.Restaurant;

/**
 *
 * @author harold
 */
public class Menu {
    private String name;
    
    private String price;
    
    private String  materail;
    
    private Restaurant restaurant;

    public Menu(Restaurant restaurant,String name,String price,String  materail) {
        this.restaurant=restaurant;
        this.name=name;
        this.price=price;
        this.materail=materail;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
    
    

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getMaterail() {
        return materail;
    }

    @Override
    public String toString() {
        return "Menu{" + "name=" + name + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
