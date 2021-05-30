/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author archil
 */
public class SupplierDirectory {

    private List<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList<Supplier>();
    }

    public List<Supplier> getSupplierlist() {
        return supplierList;
    }

    public Supplier addSupplier() {
        Supplier newSupplier = new Supplier();
        supplierList.add(newSupplier);
        return newSupplier;
    }

    public void removeSupplier(Supplier s) {
        supplierList.remove(s);
    }

    public Supplier searchSupplier(String supplierName) {
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplyName().equals(supplierName)) {
                return supplier;
            }
        }
        return null;
    }
}
