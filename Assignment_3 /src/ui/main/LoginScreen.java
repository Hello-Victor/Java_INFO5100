/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.main;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.College.CollegeProfile;
import model.Company.Company;
import model.Department.DepartmentProfile;
import model.Employer.EmployerProfile;
import model.Persona.AccountDirectory;
import model.Persona.Faculty.FacultyProfile;
import model.Persona.Profile;
import model.Persona.StudentProfile;
import model.University.University;
import model.University.UniversityProfile;
import ui.DepartmentRole.UniversityWorkAreaJPanel;
import ui.EmployerRole.EmployerWorkAreaJPanel;
import ui.FacultyRole.FacultyWorkAreaJPane;
import ui.StudentRole.StudentWorkAreaJPanel;

/**
 *
 * @author victor
 */
public class LoginScreen extends BaseJPanel {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen(JPanel mainWorkArea) {
        super(mainWorkArea);
        initComponents();
        BufferedImage img;
        try {
            img = ImageIO.read(new File("./res/UserName.png"));
            Image dimg = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);
            lblChooseRole.setIcon(icon);
            lblChooseRole.setText("");
        } catch (IOException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            img = ImageIO.read(new File("./res/Password.png"));
            Image dimg = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);
            jLabel1.setIcon(icon);
            jLabel1.setText("");
        } catch (IOException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }try {
            img = ImageIO.read(new File("./res/background.png"));
            Image dimg = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(dimg);
            jLabel2.setIcon(icon);
            jLabel2.setText("");
        } catch (IOException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblChooseRole = new javax.swing.JLabel();
        btnEnter = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("PT Serif", 0, 22)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("   Job performance  &  Academic Analysis Systems");
        lblTitle.setMaximumSize(new java.awt.Dimension(100, 50));

        lblChooseRole.setFont(new java.awt.Font("Minion Pro", 0, 18)); // NOI18N
        lblChooseRole.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblChooseRole.setText("Username:");

        btnEnter.setText("Login  >>");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Minion Pro", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Password:");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooseRole, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPasswordField1, jTextField1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChooseRole, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnEnter)
                .addGap(98, 98, 98)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        // TODO add your handling code here:
        String userName = jTextField1.getText();
        String password = String.valueOf(this.jPasswordField1.getPassword());
        boolean flag = false;

        University university = University.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();
        Profile profile = accountDirectory.getProfile(userName);
        if (profile == null) {
            JOptionPane.showMessageDialog(null, "Invalid Name.");
            jTextField1.setText("");
            jPasswordField1.setText("");
        } else if (!profile.isAuthorized(password)) {
            JOptionPane.showMessageDialog(null, "Invalid Password.");
            jPasswordField1.setText("");
        } else {
            java.lang.Class accountType = accountDirectory.getProfileClass(userName);
            JPanel nextScreen;
            if (accountType == UniversityProfile.class) {
                nextScreen = new UniversityChooseCollege(mainWorkArea);
            } else if (accountType == CollegeProfile.class) {
                CollegeProfile p = (CollegeProfile) profile;
                nextScreen = new CollegeChooseDepartment(mainWorkArea, p.getCollege());
            } else if (accountType == DepartmentProfile.class) {
                DepartmentProfile p = (DepartmentProfile) profile;
                nextScreen = new UniversityWorkAreaJPanel(mainWorkArea, university.getCollege(p.getCollegeName()), p.getDepartment());
            } else if (accountType == FacultyProfile.class) {
                FacultyProfile p = (FacultyProfile) profile;
                nextScreen = new FacultyWorkAreaJPane(mainWorkArea, p);
            } else if (accountType == StudentProfile.class) {
                StudentProfile p = (StudentProfile) profile;
                nextScreen = new StudentWorkAreaJPanel(mainWorkArea, p);
            } else if (accountType == Company.class) {
                Company p = (Company) profile;
                nextScreen = new EmployerWorkAreaJPanel(mainWorkArea, p);
            } else if (accountType == EmployerProfile.class) {
                EmployerProfile p = (EmployerProfile) profile;
                nextScreen = new EmployerWorkAreaJPanel(mainWorkArea, p.getCompany());
            } else {
                nextScreen = new UniversityChooseCollege(mainWorkArea);
            }
            jPasswordField1.setText("");
            nextPanel(nextScreen);
        }
    }//GEN-LAST:event_btnEnterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblChooseRole;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
