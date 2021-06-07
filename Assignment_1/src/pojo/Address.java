/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Administrator
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private int id;

    public Address() {
    }
    
    

    public Address(String street, String city, String state, int id) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.id = id;
    }
    
    

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
