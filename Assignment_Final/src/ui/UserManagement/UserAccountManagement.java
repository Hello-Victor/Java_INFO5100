/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.UserManagement;

import Business.Employee.Employee;
import Business.Employee.Person;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import com.github.javafaker.File;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import ui.main.BaseJPanel;

/**
 *
 * @author 73110
 */
public class UserAccountManagement extends BaseJPanel {

    /**
     * Creates new form SupplySystemAdmin
     */
    Organization organization;
    Employee employee;
    boolean editable = false;
    boolean view = false;
    boolean add = false;
    String icon;
    ImageIcon rightIcon;
    ImageIcon wrongIcon;

    public UserAccountManagement(JPanel mainWorkArea, Employee employee) {
        super(mainWorkArea);
        initComponents();
        this.employee = employee;
        this.editable = false;
        txtOrganization.setEnabled(false);
        view = true;
        organization = employee.getOrganization();
        BufferedImage img;
        try {
            img = ImageIO.read(new java.io.File("./src/main/images/right.JPG"));
        } catch (Exception ex) {
            return;
        }
        Image dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        rightIcon = icon;
        try {
            img = ImageIO.read(new java.io.File("./src/main/images/wrong.JPG"));
        } catch (Exception ex) {
            return;
        }
        dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        icon = new ImageIcon(dimg);
        wrongIcon = icon;
        refresh();
    }

    public UserAccountManagement(JPanel mainWorkArea, Employee employee, boolean editable) {
        super(mainWorkArea);
        initComponents();
        txtOrganization.setEnabled(false);
        this.employee = employee;
        this.editable = editable;
        organization = employee.getOrganization();
        BufferedImage img;
        try {
            img = ImageIO.read(new java.io.File("./src/main/images/right.JPG"));
        } catch (Exception ex) {
            return;
        }
        Image dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        rightIcon = icon;
        try {
            img = ImageIO.read(new java.io.File("./src/main/images/wrong.JPG"));
        } catch (Exception ex) {
            return;
        }
        dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        icon = new ImageIcon(dimg);
        wrongIcon = icon;
        refresh();
    }

    public UserAccountManagement(JPanel mainWorkArea, Organization organization) {
        super(mainWorkArea);
        initComponents();
        txtOrganization.setEnabled(false);
        add = true;
        editable = true;
        employee = new Employee();
        this.organization = organization;
        txtOrganization.setVisible(false);
        jLabel24.setVisible(false);
        Person newPerson = new Person("", "");
        UserAccount userAccount = new UserAccount();
        userAccount.setEmployee(employee);
        employee.setUserAccount(userAccount);
        employee.setPerson(newPerson);
        employee.setOrganization(organization);
        jLabel1.setText("");
        jLabel1.setVisible(false);
        BufferedImage img;
        try {
            img = ImageIO.read(new java.io.File("./src/main/images/right.JPG"));
        } catch (Exception ex) {
            return;
        }
        Image dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        rightIcon = icon;
        try {
            img = ImageIO.read(new java.io.File("./src/main/images/wrong.JPG"));
        } catch (Exception ex) {
            return;
        }
        dimg = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        icon = new ImageIcon(dimg);
        wrongIcon = icon;
        refresh();
    }

    @Override
    public void refresh() {
        if (editable) {
            enableAll();
        } else {
            disableAll();
        }
        if (view) {
            jButton8.setVisible(false);
        }
        if (employee != null) {
            populateInfo();
        }
    }

    public void populateInfo() {
        txtName.setText(employee.getName());
        txtUserName.setText(employee.getUserAccount().getUsername());
        txtPassword.setText(employee.getUserAccount().getPassword());
        txtOrganization.setText(organization.getName());
        txtPhoneNumber.setText(employee.getPerson().getPhoneNumberString());
        populateIcon();
    }

    public void populateIcon() {
        if (employee.getLogoImage() != null) {
            BufferedImage img;
            try {
                img = ImageIO.read(new java.io.File(employee.getLogoImage()));
            } catch (Exception ex) {
                return;
            }
            Image dimg = img.getScaledInstance(167, 151, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);

            lblIcon.setIcon(icon);
            lblIcon.setText("");
        }
    }

    public void disableAll() {
        txtName.setEnabled(false);
        txtUserName.setEnabled(false);
        txtPassword.setEnabled(false);
        txtPhoneNumber.setEnabled(false);
        jButton8.setText("Edit");
        jButton7.setVisible(false);
        jLabel1.setVisible(false);
    }

    public void enableAll() {
        txtName.setEnabled(true);
        txtUserName.setEnabled(true);
        txtPassword.setEnabled(true);
        txtPhoneNumber.setEnabled(true);
        jButton8.setText("Save");
        jButton7.setVisible(true);
        jLabel1.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        lblIcon = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtOrganization = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jSplitPane1.setBorder(null);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/home_48px_1.png"))); // NOI18N
        jLabel15.setText("Account Management");

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 153, 255));
        jButton5.setText("<<Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jButton5))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Name: ");

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/images/userinformation.png"))); // NOI18N
        jLabel20.setText("Account Data:");

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 153, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("UserName: ");

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel22.setText("Password:");

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 153, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("Phone Number:");

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("Organization:");

        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserNameKeyTyped(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setText("<No Image>");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        txtOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrganizationActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 153, 255));
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 153, 255));
        jButton7.setText("Upload Image");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUserName)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(txtName)
                    .addComponent(txtOrganization, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(135, 135, 135))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel19, jLabel21, jLabel22, jLabel23, jLabel24});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserName)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNumber)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel19, jLabel21, jLabel22, jLabel23});

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        backAction();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrganizationActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (editable || add) {
            try {
                save();
            } catch (Exception ex) {
                if (add) {
                }
                return;
            }
            if (add) {
                employee.setRole(organization.getRole());
                employee.setOrganization(organization);
                ecoSystem.getUserAccountDirectory().getUserAccountList().add(employee.getUserAccount());
                organization.getEmployeeDirectory().getEmployeeList().add(employee);
            }
            editable = false;
            disableAll();
            backAction();
        } else {
            editable = true;
            enableAll();
        }

    }//GEN-LAST:event_jButton8ActionPerformed
    public void save() throws Exception {
        String userName = txtUserName.getText();
        String oldUserName = employee.getUserAccount().getUsername();
        if (!ecoSystem.getUserAccountDirectory().checkIfUsernameIsUnique(userName) && (oldUserName == null || (!oldUserName.equals(userName)))) {
            warn("User Name Conflict!");
            throw new Exception();
        }
        if (userName.equals("")) {
            warn("User Name Empty!");
            throw new Exception();
        }
        String telephoneNumber = txtPhoneNumber.getText();
        String name = txtName.getText();
        String passWord = txtPassword.getText();
        employee.getUserAccount().setUsername(userName);
        employee.getUserAccount().setPassword(passWord);
        employee.getPerson().setFirstname(name);
        employee.getPerson().setPhoneNumberString(telephoneNumber);
    }
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser chooser = new JFileChooser("./src/main/images");
        FileFilter jpegFilter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        FileFilter pngFilter = new FileNameExtensionFilter("PNG file", "png", "png");
        chooser.setFileFilter(jpegFilter);
        chooser.setFileFilter(pngFilter);
        chooser.showOpenDialog(null);
        java.io.File f = chooser.getSelectedFile();
        if (f != null) {
            icon = f.getAbsolutePath();
            employee.setLogoImage(icon);
            populateIcon();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped

    }//GEN-LAST:event_txtNameKeyTyped

    private void txtUserNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyTyped

    }//GEN-LAST:event_txtUserNameKeyTyped

    private void txtUserNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyReleased
        String userName = txtUserName.getText();
        jLabel1.setVisible(true);
        String oldUserName = employee.getUserAccount().getUsername();
        if (userName.equals("") || (!ecoSystem.getUserAccountDirectory().checkIfUsernameIsUnique(userName) && (oldUserName == null || (!oldUserName.equals(userName))))) {
            jLabel1.setIcon(wrongIcon);
        } else {
            jLabel1.setIcon(rightIcon);
        }
    }//GEN-LAST:event_txtUserNameKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrganization;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
