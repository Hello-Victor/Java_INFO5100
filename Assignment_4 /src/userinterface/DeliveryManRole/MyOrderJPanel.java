/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DeliveryManRole;

import Business.Customer.Customer;
import Business.Employee.Employee;
import Business.LoginSession;
import Business.Restaurant.Restaurant;
import Business.WorkQueue.OrderState;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkServiceUtil;
import Business.menu.Menu;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import userinterface.BaseJPanel;

/**
 *
 * @author victor
 */
public class MyOrderJPanel extends BaseJPanel {

    /**
     * Creates new form AcceptOrderJPanel
     */
    public MyOrderJPanel() {
        initComponents();
        refreshTable();
        
    }
    
    public void refreshTable(){
         List<Object[]> rows=new ArrayList<>();
          //送餐员登录
        List<WorkRequest> allOrders = system.getWorkQueue().getWorkRequestList();
        for(WorkRequest order:allOrders){
            if(order.getDeliver()!=null 
                  &&  order.getDeliver().getEmployee().getId()==LoginSession.userAccout.getEmployee().getId()
                  && order.status.equals(OrderState.ASSIGN) ){
                Object[] row = new Object[4];
                Customer customer = (Customer)order.getCustomer().getEmployee();
                    row[0] = order.getId();
                    row[1] = customer.getAddress();
                    row[2] = customer.getName();
                    row[3] = customer.getPhone();
                    rows.add(row);
            }
        };
        dorefreshTable(jTable1, rows);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("<<  Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Chalkboard", 0, 24)); // NOI18N
        jLabel1.setText("My Order");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderNumber", "Address", "OrderMan Name", "Telephone Number"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jButton2.setText("Have Done!");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jButton1)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        backAction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Integer ordId = (Integer)getChooseRowObj(jTable1);
        if(ordId==null){
            return ;
        }
        WorkRequest workdRequest = WorkServiceUtil.queryWorkRequestById(ordId);
        workdRequest.setStatus(OrderState.RECEIVED);
        workdRequest.setResolveDate(new Date());
        refreshTable();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
