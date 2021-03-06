/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.SaiDao;
import pojo.Sai;

/**
 *
 * @author victor
 */
public class VJPSAI extends javax.swing.JPanel {
    SaiDao saiDao;
    /**
     * Creates new form VJPSAI
     */
    public VJPSAI(SaiDao saiDao) {
        initComponents();
        this.saiDao = saiDao;
        showData();
    }
    
    public void showData(){
        Sai sai = saiDao.getSai().get(0);
        
        txtAB.setText(String.valueOf(sai.getBalance()));
        txtAT.setText(String.valueOf(sai.getAType()));
        txtBAN.setText(String.valueOf(sai.getANumber()));
        txtBN.setText(String.valueOf(sai.getbName()));
        txtBRN.setText(String.valueOf(sai.getBRNumber()));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBN = new javax.swing.JTextField();
        txtBRN = new javax.swing.JTextField();
        txtAT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBAN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        txtAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtABActionPerformed(evt);
            }
        });

        jLabel4.setText("Bank Account Number:");

        jLabel5.setText("Account Balance:");

        txtBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBNActionPerformed(evt);
            }
        });

        txtBRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBRNActionPerformed(evt);
            }
        });

        txtAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtATActionPerformed(evt);
            }
        });

        jLabel2.setText("Bank Name:");

        txtBAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBANActionPerformed(evt);
            }
        });

        jLabel7.setText("Account Type (saving):");

        jLabel3.setText("Bank Routing Number:");

        jLabel6.setFont(new java.awt.Font("Mshtakan", 1, 24)); // NOI18N
        jLabel6.setText("User Information System - Saving Account Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAB, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBAN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBRN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAT, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel6)
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBRN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtABActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtABActionPerformed

    private void txtBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBNActionPerformed

    private void txtBRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBRNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBRNActionPerformed

    private void txtATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtATActionPerformed

    private void txtBANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBANActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAB;
    private javax.swing.JTextField txtAT;
    private javax.swing.JTextField txtBAN;
    private javax.swing.JTextField txtBN;
    private javax.swing.JTextField txtBRN;
    // End of variables declaration//GEN-END:variables
}
