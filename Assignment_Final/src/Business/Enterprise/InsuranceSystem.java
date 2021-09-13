/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.CarInsuranceOrganization;
import Business.Organization.HouseInsuranceOrganization;
import Business.Organization.Organization;

/**
 *
 * @author aeloyq
 */
public class InsuranceSystem extends Enterprise{
    
    CarInsuranceOrganization carInsuranceOrganization;
    HouseInsuranceOrganization houseInsuranceOrganization;

    public InsuranceSystem(Organization upperOrganization) {
        super("Local Insurance System", upperOrganization);
    }

    public CarInsuranceOrganization getCarInsuranceOrganization() {
        return carInsuranceOrganization;
    }

    public void setCarInsuranceOrganization(CarInsuranceOrganization carInsuranceOrganization) {
        this.carInsuranceOrganization = carInsuranceOrganization;
    }

    public HouseInsuranceOrganization getHouseInsuranceOrganization() {
        return houseInsuranceOrganization;
    }

    public void setHouseInsuranceOrganization(HouseInsuranceOrganization houseInsuranceOrganization) {
        this.houseInsuranceOrganization = houseInsuranceOrganization;
    }

    
    
}
