/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrderState;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author red
 */
public class OrderDirectory {
       private List<WorkRequest> allOrders=new ArrayList();

    public List getAllOrders() {
        return allOrders;
    }
    
    public void assignOrderToDeliver(OrderWorkRequest order,UserAccount deliver,Date assignDate){
        order=(OrderWorkRequest)order;
        order.setDeliver(deliver);
        order.setStatus(OrderState.ASSIGN);
        order.setAssignDate(assignDate);
        
    }
       
       
       
}
