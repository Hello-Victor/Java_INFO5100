package Business;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Role.AdminRole;
import Business.Role.CustomerRole;
import Business.Role.DeliverManRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("RRH");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        Restaurant createNewRestaurant = system.getRestaurantDirectory().createNewRestaurant("resName", "res1", "123");
        createNewRestaurant.getMenuDirectory().createNewMenu(createNewRestaurant, "cookie", "1.5","red color");
          
        UserAccount createNewCustomer = system.getCustomerDirectory().createNewCustomer("cusName","cus1","123");
        Customer newCustomer = (Customer)createNewCustomer.getEmployee();
        newCustomer.setPhone("1833");
        newCustomer.setAddress("chengdu");
        
           system.getDeliveryManDirectory().createNewDelivery("delivName","deliv1", "123");
        
        return system;
    }
    
}
