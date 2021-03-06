/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.MRDao;
import pojo.MR;

/**
 *
 * @author victor
 */
public class VJPMR extends javax.swing.JPanel {
    MRDao mrDao;
    /**
     * Creates new form VJPMR
     */
    public VJPMR(MRDao mrDao) {
        initComponents();
        this.mrDao = mrDao;
        showData();
    }
    
    public void showData(){
        MR mr = mrDao.getMR().get(0);
         txtA1.setText(String.valueOf(mr.getAg1()));
        txtA2.setText(String.valueOf(mr.getAg2()));
        txtA3.setText(String.valueOf(mr.getAg3()));
        txtMRN.setText(String.valueOf(mr.getMRNumber()));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtA2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtA3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMRN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtA1 = new javax.swing.JTextField();

        jLabel2.setText("Medical Record Number:");

        txtA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Alergy1:");

        txtA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Alergy2:");

        jLabel5.setText("Alergy3:");

        txtMRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMRNActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Mshtakan", 1, 24)); // NOI18N
        jLabel6.setText("User Information System - Medical Record");

        txtA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtA3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtA2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtA1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMRN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel6)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(296, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA2ActionPerformed

    private void txtA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA3ActionPerformed

    private void txtMRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMRNActionPerformed

    private void txtA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtA1;
    private javax.swing.JTextField txtA2;
    private javax.swing.JTextField txtA3;
    private javax.swing.JTextField txtMRN;
    // End of variables declaration//GEN-END:variables
}
