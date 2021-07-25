package com.demo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryMan;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.LoginSession;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import static Business.Role.Role.RoleType.DeliveryMan;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.OrderState;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkServiceUtil;
import Business.menu.Menu;
import com.demo.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author red
 */
public class SystemAdminTest {

    
    public static void main(String[] args) {
        System.out.println("nihao");
        initSystem();
    }
    
    public static void initSystem(){
         EcoSystem system = EcoSystem.getInstance();
         
          LoginSession.ecoSystem=system;
        
        //创建餐厅
        RestaurantDirectory restaurantDirectory = system.getRestaurantDirectory();
        Restaurant createNewRestaurant = restaurantDirectory.createNewRestaurant("resta", "resta", "123");
        //创建员工
        DeliveryManDirectory deliveryManDirectory = system.getDeliveryManDirectory();
        deliveryManDirectory.createNewDelivery("deliv", "deliv", "123");
        
        CustomerDirectory customerDirectory = system.getCustomerDirectory();
        //创建客户
        UserAccount createNewCustomer = customerDirectory.createNewCustomer("lizg", "lizg", "123");
        
       
        //餐厅登录
        LoginSession.restaurant=createNewRestaurant;
        
        Menu createNewMenu = createNewRestaurant.getMenuDirectory().createNewMenu(createNewRestaurant,"菜一","1","22");
        
        //客户登录
        LoginSession.userAccout=createNewCustomer;
        LoginSession.restaurant=null;
        
        //客户下单
        Customer customer = (Customer)LoginSession.userAccout.getEmployee();
        OrderWorkRequest newOrder;
        newOrder = (OrderWorkRequest)system.getWorkQueue().createNewOrder(createNewMenu, LoginSession.userAccout);
        customer.getCarts().add(newOrder);
        
        
        //餐厅登录
        LoginSession.restaurant=createNewRestaurant;
        //遍历找到对应的userAccount;
        UserAccount restaurantAccount = system.getUserAccountDirectory().getUserAccountList().get(0);
        
        LoginSession.userAccout=restaurantAccount;
        OrderWorkRequest restaurantOrder = (OrderWorkRequest)system.getWorkQueue().getWorkRequestList().get(0);
        
        DeliveryMan deliveryMan = (DeliveryMan)deliveryManDirectory.getDeliverys().get(0);
         UserAccountDirectory userAccountDirectory = system.getUserAccountDirectory();
        ArrayList<UserAccount> userAccountList = userAccountDirectory.getUserAccountList();
        UserAccount deliverAccount=null;
        for(UserAccount userAccount:userAccountList){
            if(userAccount.getRole().getRoleType().equals(Role.RoleType.DeliveryMan)){
                deliverAccount=userAccount;
            }
        }
        
        WorkServiceUtil.assignOrderWorkRequestToDeliverMan(restaurantOrder,deliverAccount,new Date());
        
        LoginSession.userAccout=null;
        for(UserAccount userAccount:userAccountList){
            if(userAccount.getRole().getRoleType().equals(Role.RoleType.DeliveryMan)){
                LoginSession.userAccout=userAccount;
            }
        }
        //送餐员登录
        List<OrderWorkRequest> allOrders = WorkServiceUtil.queryOrderWorkRequest(createNewRestaurant);
        for(WorkRequest order:allOrders){
            if(order.getDeliver().getEmployee().getId()==LoginSession.userAccout.getEmployee().getId()){
                //发起送到
                order.setStatus(OrderState.RECEIVED);
            }
        };
        
        //客户登录
        
        LoginSession.userAccout=null;
        for(UserAccount userAccount:userAccountList){
            if(userAccount.getRole().getRoleType().equals(Role.RoleType.Customer)){
                LoginSession.userAccout=userAccount;
            }
        }
        //送餐员登录
        for(OrderWorkRequest order:allOrders){
            if(order.getCustomer().getEmployee().getId()==LoginSession.userAccout.getEmployee().getId()){
                //发起签收
                order.setTestResult("好评");
                order.setStatus(OrderState.EVALUATED);
            }
        };
        
        System.out.println(allOrders.size());
        
        System.out.println(allOrders.get(0));
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
