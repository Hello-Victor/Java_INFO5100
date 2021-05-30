/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victor
 */
public class Business {
    
    MasterOrderList masterOrderList;
    SupplierDirectory supplierDirectory;

    public Business() {
        
        masterOrderList = new MasterOrderList();
        supplierDirectory = new SupplierDirectory();
    
        
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    public void setMasterOrderList(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    
}
