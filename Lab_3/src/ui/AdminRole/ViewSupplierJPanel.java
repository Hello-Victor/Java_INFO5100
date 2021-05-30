package ui.AdminRole;

import model.Product;
import model.Supplier;
import model.SupplierDirectory;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mihir Mehta / Hechen Gao
 */
public class ViewSupplierJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Supplier supplier;
    
    public ViewSupplierJPanel(JPanel upc, Supplier s) {
        initComponents();
        userProcessContainer = upc;
        supplier = s;
        lblSupplierName.setText(s.getSupplyName());
        refreshTable();
    }

    public void refreshTable(){
        int rowCount = productCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel) productCatalog.getModel();
        for(int i=rowCount - 1;i>=0;i--){
            model.removeRow(i);
        }
        for(Product p: supplier.getProductCatalog().getProductcatalog()){
            Object row[] = new Object[3];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getPrice();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSupplierName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productCatalog = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();

        lblSupplierName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSupplierName.setText("<Supplier Name>");

        productCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Model", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productCatalog);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblSupplierName))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(336, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      userProcessContainer.remove(this);
      CardLayout layout = (CardLayout) userProcessContainer.getLayout();
      layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JTable productCatalog;
    // End of variables declaration//GEN-END:variables
}
