/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Restaurant.Restaurant;
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
public class WorkServiceUtil {
    
    public static List<OrderWorkRequest> queryOrderWorkRequest(Restaurant restaurant) {
        List<OrderWorkRequest> resultOrderWorkRequests=new ArrayList<>();
        ArrayList<WorkRequest> orderWorkRequests = LoginSession.ecoSystem.getWorkQueue().getWorkRequestList();
        for(WorkRequest workRequest:orderWorkRequests){
            OrderWorkRequest tmpWorkRequest=(OrderWorkRequest)workRequest;
            if(tmpWorkRequest.getMenu().getRestaurant().equals(restaurant)){
                resultOrderWorkRequests.add(tmpWorkRequest);
            }
        }
        return resultOrderWorkRequests;
    }
    
    public static WorkRequest queryWorkRequestById(int id) {
        ArrayList<WorkRequest> orderWorkRequests = LoginSession.ecoSystem.getWorkQueue().getWorkRequestList();
        for(WorkRequest workRequest:orderWorkRequests){
            if(workRequest.getId()==id){
                return workRequest;
            }
        }
        return null;
    }
    
    public static void assignOrderWorkRequestToDeliverMan(OrderWorkRequest workRequest,UserAccount deliver,Date assignDate) {
        workRequest.setDeliver(deliver);
        workRequest.setAssignDate(assignDate);
        workRequest.setStatus(OrderState.ASSIGN);
    }
    
}
