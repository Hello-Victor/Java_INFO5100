package ui.SupplierRole;

import model.Supplier;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Supplier supplier;
    public SupplierWorkAreaJPanel(JPanel upc, Supplier s) {
        initComponents();
        userProcessContainer = upc;
        supplier = s;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnManageProductCatalog = new javax.swing.JButton();
        btnProductPerformance = new javax.swing.JButton();
        btnUpdateProfile = new javax.swing.JButton();
        btnUpdateStaff = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));
        setPreferredSize(new java.awt.Dimension(650, 600));

        lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/logoPleaseBuySmall.png"))); // NOI18N
        lblTitle.setText("Supplier Work Area");
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblTitle.setIconTextGap(100);

        btnManageProductCatalog.setText("Manage Product Catalog >>");
        btnManageProductCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageProductCatalogActionPerformed(evt);
            }
        });

        btnProductPerformance.setText("Review Product Performance >>");
        btnProductPerformance.setEnabled(false);
        btnProductPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductPerformanceActionPerformed(evt);
            }
        });

        btnUpdateProfile.setText("Update Personal Profile >>");
        btnUpdateProfile.setEnabled(false);
        btnUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProfileActionPerformed(evt);
            }
        });

        btnUpdateStaff.setText("Manage Staff");
        btnUpdateStaff.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnProductPerformance)
                        .addComponent(btnUpdateProfile)
                        .addComponent(btnUpdateStaff)
                        .addComponent(btnManageProductCatalog))
                    .addComponent(lblTitle))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTitle)
                .addGap(98, 98, 98)
                .addComponent(btnManageProductCatalog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductPerformance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateStaff)
                .addContainerGap(261, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btnManageProductCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageProductCatalogActionPerformed

        ManageProductCatalogJPanel mpcjp = new ManageProductCatalogJPanel(userProcessContainer, supplier);
        userProcessContainer.add("ManageProductCatalogJPanel", mpcjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageProductCatalogActionPerformed

    private void btnProductPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductPerformanceActionPerformed

    }//GEN-LAST:event_btnProductPerformanceActionPerformed

    private void btnUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProfileActionPerformed

    }//GEN-LAST:event_btnUpdateProfileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageProductCatalog;
    private javax.swing.JButton btnProductPerformance;
    private javax.swing.JButton btnUpdateProfile;
    private javax.swing.JButton btnUpdateStaff;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
