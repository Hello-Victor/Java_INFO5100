/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Utilities;

import java.util.ArrayList;

/**
 *
 * @author aeloyq
 */
public interface Listable {
    
    public String[] getColumns();

    public int getNumOfColumns();

    public ArrayList<Object[]> getObjects();
}
