/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    public String message;
    public UserAccount customer;
    public UserAccount deliver;
    public OrderState status;
    public Date requestDate;
    public Date resolveDate;
    public  int id=0;
    public static int count=0;

    public int getId() {
        return id;
    }

    
    public WorkRequest(){
        WorkRequest.count++;
        this.id=WorkRequest.count;
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getCustomer() {
        return customer;
    }

    public void setCustomer(UserAccount customer) {
        this.customer = customer;
    }

    public UserAccount getDeliver() {
        return deliver;
    }

    public void setDeliver(UserAccount deliver) {
        this.deliver = deliver;
    }

    public OrderState getStatus() {
        return status;
    }

    public void setStatus(OrderState status) {
        this.status = status;
    }

    

    

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

   
    
    
}
