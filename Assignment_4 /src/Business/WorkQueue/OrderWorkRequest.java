/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import Business.menu.Menu;
import java.util.Date;

/**
 *
 * @author raunak
 */
public class OrderWorkRequest extends WorkRequest{
    
    private String testResult;
    private Menu menu;
    private Date assignDate;

    public OrderWorkRequest(Menu menu,UserAccount customer,UserAccount deliver) {
        this.menu=menu;
        super.customer=customer;
        super.deliver=deliver;
        super.status=OrderState.INIT;
    }

    public Menu getMenu() {
        return menu;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
    
    
    
    
    
    
    

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    @Override
    public String toString() {
        return "OrderWorkRequest{" + "testResult=" + testResult + ", menu=" + menu + '}';
    }
    
    
    
    
}
