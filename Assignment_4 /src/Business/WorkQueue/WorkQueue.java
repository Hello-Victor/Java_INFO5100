/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Customer.Customer;
import Business.UserAccount.UserAccount;
import Business.menu.Menu;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
    }
    
    public WorkRequest createNewOrder(Menu menu,UserAccount customer){
        OrderWorkRequest orderWorkRequest = new OrderWorkRequest(menu,customer,null);
        workRequestList.add(orderWorkRequest);
        return orderWorkRequest;
                
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    
}