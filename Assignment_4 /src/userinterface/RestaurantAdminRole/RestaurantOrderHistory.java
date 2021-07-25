/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import Business.WorkQueue.OrderState;
import Business.WorkQueue.OrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkServiceUtil;
import java.util.ArrayList;
import java.util.List;
import userinterface.BaseJPanel;

/**
 *
 * @author victor
 */
public class RestaurantOrderHistory extends BaseJPanel {

    /**
     * Creates new form RestaurantOrderHistory
     */
    public RestaurantOrderHistory() {
        initComponents();
        refreshTable();
    }
    
    public void refreshTable(){
         List<Object[]> rows=new ArrayList<>();
        List<OrderWorkRequest> workRequestList = WorkServiceUtil.queryOrderWorkRequest(loginRestaurant);
        for(WorkRequest workRequest:workRequestList){
            if(workRequest.getStatus().equals(OrderState.EVALUATED)){
                OrderWorkRequest orderWorkRequest=(OrderWorkRequest)workRequest;
                Object[] row = new Object[5];
                    row[0] = orderWorkRequest.getId();
                    row[1] = orderWorkRequest.getDeliver().getEmployee().getName();
                    row[2] = orderWorkRequest.getRequestDate();
                    row[3] = orderWorkRequest.getResolveDate();
                    row[4]=orderWorkRequest.getTestResult();
                    rows.add(row);
            }
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order Number", "DeliveryMan", "Order Time", "Finish Time", "Feedback"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Chalkboard", 0, 24)); // NOI18N
        jLabel1.setText("Order History");

        jButton1.setText(" <<  Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        backAction();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
