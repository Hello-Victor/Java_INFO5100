/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.SupplySystem;

import javax.swing.JPanel;
import ui.UserManagement.UserAccountListManagement;
import ui.main.BaseJPanel;

/**
 *
 * @author 73110
 */
public class SupplySystemAdmin extends BaseJPanel {

    /**
     * Creates new form SupplySystemAdmin
     */
    public SupplySystemAdmin(JPanel mainWorkArea) {
        super(mainWorkArea);
        initComponents();
        configurePanel(jPanelAdminManage);
        configurePanel(jPanelElectric);
        configurePanel(jPanelFood);
        configurePanel(jPanelWater);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelElectric = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanelFood = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanelWater = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanelAdminManage = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/home_48px_1.png"))); // NOI18N
        jLabel15.setText("City Supply System Admin");

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 255));
        jButton5.setText("<<Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 153, 255));
        jButton6.setText("Log Out");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6)
                        .addComponent(jButton5))
                    .addComponent(jLabel15))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanelElectric.setBackground(new java.awt.Color(255, 255, 255));
        jPanelElectric.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelElectricMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelElectricMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelElectricMousePressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/power_48px.png"))); // NOI18N
        jLabel16.setText("Electricity Supply System");

        javax.swing.GroupLayout jPanelElectricLayout = new javax.swing.GroupLayout(jPanelElectric);
        jPanelElectric.setLayout(jPanelElectricLayout);
        jPanelElectricLayout.setHorizontalGroup(
            jPanelElectricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElectricLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanelElectricLayout.setVerticalGroup(
            jPanelElectricLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelElectricLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel16)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelFood.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelFoodMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelFoodMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelFoodMousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/food_48px.png"))); // NOI18N
        jLabel17.setText("Food Supply System");

        javax.swing.GroupLayout jPanelFoodLayout = new javax.swing.GroupLayout(jPanelFood);
        jPanelFood.setLayout(jPanelFoodLayout);
        jPanelFoodLayout.setHorizontalGroup(
            jPanelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFoodLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanelFoodLayout.setVerticalGroup(
            jPanelFoodLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFoodLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        jPanelWater.setBackground(new java.awt.Color(255, 255, 255));
        jPanelWater.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelWaterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelWaterMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelWaterMousePressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/water_48px.png"))); // NOI18N
        jLabel18.setText("Water Supply System");

        javax.swing.GroupLayout jPanelWaterLayout = new javax.swing.GroupLayout(jPanelWater);
        jPanelWater.setLayout(jPanelWaterLayout);
        jPanelWaterLayout.setHorizontalGroup(
            jPanelWaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWaterLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel18)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanelWaterLayout.setVerticalGroup(
            jPanelWaterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelWaterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelAdminManage.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdminManage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanelAdminManageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanelAdminManageMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelAdminManageMousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/userinformation.png"))); // NOI18N
        jLabel19.setText("Admin Management");

        javax.swing.GroupLayout jPanelAdminManageLayout = new javax.swing.GroupLayout(jPanelAdminManage);
        jPanelAdminManage.setLayout(jPanelAdminManageLayout);
        jPanelAdminManageLayout.setHorizontalGroup(
            jPanelAdminManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminManageLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel19)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanelAdminManageLayout.setVerticalGroup(
            jPanelAdminManageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminManageLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelWater, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelFood, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelElectric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAdminManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanelAdminManage, jPanelElectric, jPanelFood, jPanelWater});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelWater, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelElectric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelAdminManage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanelAdminManage, jPanelElectric, jPanelFood, jPanelWater});

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        backAction();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        logoutAction();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jPanelWaterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelWaterMouseEntered

    }//GEN-LAST:event_jPanelWaterMouseEntered

    private void jPanelWaterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelWaterMouseExited

    }//GEN-LAST:event_jPanelWaterMouseExited

    private void jPanelWaterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelWaterMousePressed
        JPanel waterSupplyManagePanel = new LocalWaterSupplyCenterAdmin(mainWorkArea);
        nextPanel(waterSupplyManagePanel);
    }//GEN-LAST:event_jPanelWaterMousePressed

    private void jPanelElectricMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelElectricMouseEntered

    }//GEN-LAST:event_jPanelElectricMouseEntered

    private void jPanelElectricMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelElectricMouseExited

    }//GEN-LAST:event_jPanelElectricMouseExited

    private void jPanelElectricMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelElectricMousePressed
        JPanel waterSupplyManagePanel = new LocalElectricitySupplyCenterAdmin(mainWorkArea);
        nextPanel(waterSupplyManagePanel);// TODO add your handling code here:
    }//GEN-LAST:event_jPanelElectricMousePressed

    private void jPanelFoodMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFoodMouseEntered

    }//GEN-LAST:event_jPanelFoodMouseEntered

    private void jPanelFoodMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFoodMouseExited

    }//GEN-LAST:event_jPanelFoodMouseExited

    private void jPanelFoodMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelFoodMousePressed
        JPanel waterSupplyManagePanel = new LocalFoodSupplyCenterAdmin(mainWorkArea);
        nextPanel(waterSupplyManagePanel);// TODO add your handling code here:
    }//GEN-LAST:event_jPanelFoodMousePressed

    private void jPanelAdminManageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAdminManageMousePressed
        nextPanel(new UserAccountListManagement(mainWorkArea, supplySystem));
    }//GEN-LAST:event_jPanelAdminManageMousePressed

    private void jPanelAdminManageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAdminManageMouseEntered

    }//GEN-LAST:event_jPanelAdminManageMouseEntered

    private void jPanelAdminManageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelAdminManageMouseExited

    }//GEN-LAST:event_jPanelAdminManageMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelAdminManage;
    private javax.swing.JPanel jPanelElectric;
    private javax.swing.JPanel jPanelFood;
    private javax.swing.JPanel jPanelWater;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

}
