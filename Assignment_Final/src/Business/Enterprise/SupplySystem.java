/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.ElectricityOrganization;
import Business.Organization.FoodOrganization;
import Business.Organization.Organization;
import Business.Organization.WaterOrganization;

/**
 *
 * @author aeloyq
 */
public class SupplySystem extends Enterprise {

    ElectricityOrganization electricityOrganization;
    WaterOrganization waterOrganization;
    FoodOrganization foodOrganization;
    
    public SupplySystem(Organization upperOrganization) {
        super("Local Supply System", upperOrganization);
    }

    public ElectricityOrganization getElectricityOrganization() {
        return electricityOrganization;
    }

    public void setElectricityOrganization(ElectricityOrganization electricityOrganization) {
        this.electricityOrganization = electricityOrganization;
    }

    public WaterOrganization getWaterOrganization() {
        return waterOrganization;
    }

    public void setWaterOrganization(WaterOrganization waterOrganization) {
        this.waterOrganization = waterOrganization;
    }

    public FoodOrganization getFoodOrganization() {
        return foodOrganization;
    }

    public void setFoodOrganization(FoodOrganization foodOrganization) {
        this.foodOrganization = foodOrganization;
    }

}
