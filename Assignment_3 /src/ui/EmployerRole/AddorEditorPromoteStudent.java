/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.EmployerRole;

import ui.DepartmentRole.*;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.College.College;
import model.Company.Company;
import model.CourseCatalog.Course;
import model.CourseSchedule.CourseLoad;
import model.CourseSchedule.CourseOffer;
import model.CourseSchedule.CourseSchedule;
import model.CourseSchedule.SeatAssignment;
import model.Department.Department;
import model.Employer.EmployerProfile;
import model.Employment.Employment;
import model.Persona.AccountDirectory;
import model.Persona.Faculty.FacultyProfile;
import model.Persona.Person;
import model.Persona.PersonDirectory;
import model.Persona.StudentDirectory;
import model.Persona.StudentProfile;
import model.University.University;
import org.apache.commons.lang3.text.StrMatcher;
import ui.main.BaseJPanel;

/**
 *
 * @author victor
 */
public class AddorEditorPromoteStudent extends BaseJPanel {

    private Company company;
    private Employment employment;
    private StudentProfile studentProfile = null;
    private Hashtable<Integer, StudentProfile> studentProfileMap = new Hashtable<Integer, StudentProfile>();
    private Hashtable<Integer, CourseOffer> courseOfferMap = new Hashtable<Integer, CourseOffer>();
    private ArrayList<CourseOffer> relatedCourseOffers = new ArrayList<CourseOffer>();
    private EmployerProfile employerProfile = null;

    /**
     * Creates new form AddStudentJPanel
     */
    public AddorEditorPromoteStudent(JPanel mainWorkArea, Company company) {
        super(mainWorkArea);
        this.company = company;
        initComponents();
        refreshTable();
        employerProfile = company.getEmployerDirectory().getEmployerMap().get("default");
    }

    public AddorEditorPromoteStudent(JPanel mainWorkArea, Company company, StudentProfile studentProfile) {
        super(mainWorkArea);
        this.company = company;
        this.studentProfile = studentProfile;
        initComponents();
        jLabel4.setText("Promote Employee");
        refreshTable();
    }

    public AddorEditorPromoteStudent(JPanel mainWorkArea, Company company, StudentProfile studentProfile, Employment employment) {
        super(mainWorkArea);
        this.company = company;
        this.studentProfile = studentProfile;
        this.employment = employment;
        initComponents();
        jLabel4.setText("Edit Employee");
        refreshTable();
    }

    @Override
    public void refreshTable() {
        if (studentProfile != null) {
            jComboBox1.removeAllItems();
            jComboBox1.addItem(studentProfile.getPerson().getId() + " - " + studentProfile.getPerson().getLastname());
            jComboBox1.setEnabled(false);
            studentProfileMap.put(0, studentProfile);
            if (employment != null) {
                populateInfo();
            } else {
                populateCombobox2(true);
            }
        } else {
            populateCombobox1();
        }
    }

    public void clearTable() {
        relatedCourseOffers.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }

    public void populateCombobox1() {
        studentProfileMap.clear();
        jComboBox1.removeAllItems();
        int index = 0;
        for (College college : university.getColleges().values()) {
            for (Department department : college.getDepartments().values()) {
                for (StudentProfile s : department.getStudentdirectory().getStudentMap().values()) {
                    if ((s.readyToGraduated() && (!s.isGraduated())) || (s.isGraduated() && s.getEmploymenthistory().getLastCompany().getEmployerProfile().getCompany() != company)) {
                        jComboBox1.addItem(s.getPerson().getId() + " - " + s.getPerson().getLastname());
                        studentProfileMap.put(index, s);
                        index++;
                    }
                }
            }
        }
        populateCombobox2(true);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (CourseOffer co : relatedCourseOffers) {
            model.addRow(new Object[]{co, co.getCourse().getName()});
        }
    }

    public void populateCombobox2(boolean clear) {
        courseOfferMap.clear();
        jComboBox2.removeAllItems();
        if (clear) {
            clearTable();
        }
        populateTable();
        int index = 0;
        StudentProfile sp = studentProfileMap.get(jComboBox1.getSelectedIndex());
        if (sp != null) {
            for (CourseLoad cl : sp.getTranscript().getCourseloadlist().values()) {
                for (SeatAssignment sa : cl.getSeatassignments()) {
                    CourseOffer co = sa.getSeat().getCourseoffer();
                    if (!relatedCourseOffers.contains(co)) {
                        jComboBox2.addItem(co.getCourse().getName());
                        courseOfferMap.put(index, co);
                        index++;
                    }
                }
            }
        }
    }

    public void populateInfo() {
        jTextField2.setText(String.valueOf(employment.getYear()));
        jTextField1.setText(employment.getTitle());
        jTextField4.setText(String.valueOf(employment.getSalary()));
        for (CourseOffer co : employment.getRelevantcourseoffers()) {
            relatedCourseOffers.add(co);
        }
        populateCombobox2(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jLabel1.setText("Title:");

        jLabel2.setText("Student:");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Recruit New Student");

        jButton2.setText("<<  Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Salary:");

        jLabel3.setText("Year:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Course Number", "Course Name"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("add relevent course");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("delete relevent course");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(309, 309, 309)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton2))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addContainerGap(155, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String title = this.jTextField1.getText();
        String ssalary = this.jTextField4.getText();
        String syear = this.jTextField2.getText();
        int salary;
        try {
            salary = Integer.parseInt(ssalary);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Wrong salary Format");
            return;
        }
        int year;
        try {
            year = Integer.parseInt(syear);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Wrong Year Format");
            return;
        }
        ArrayList<Employment> employments = studentProfile.getEmploymenthistory().getAllEmployments();
        int minyear = 0;
        if (employments.size() > 1) {
            minyear = employments.get(employments.size() - 2).getYear();
        }
        if (year < minyear) {
            JOptionPane.showMessageDialog(this, "Year should be larger than his last employment");
            return;
        }
        if (studentProfile == null) {
            studentProfile = studentProfileMap.get(jComboBox1.getSelectedIndex());
            if (studentProfile.isGraduated()) {
                studentProfile.getEmploymenthistory().jobHop(employerProfile, year, title, salary);
            } else {
                studentProfile.setFirstEmployment(employerProfile, year, title, salary);
            }
            employment = studentProfile.getEmploymenthistory().getLastCompany().getLastPosition();
            JOptionPane.showMessageDialog(this, "created");
        } else {
            if (employment == null) {
                studentProfile.getEmploymenthistory().getLastCompany().promote(year, title, salary);
                employment = studentProfile.getEmploymenthistory().getLastCompany().getLastPosition();
            } else {
                employment.setYear(year);
                employment.setSalary(salary);
                employment.setTitle(title);
            }
            JOptionPane.showMessageDialog(this, "saved");
        }
        for (Object co : employment.getRelevantcourseoffers().toArray()) {
            employment.removeRelevantcourseoffer((CourseOffer) co);
        }
        for (CourseOffer co : relatedCourseOffers) {
            employment.addRelevantcourseoffer(co);
        }
        backAction();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        backAction();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CourseOffer co = courseOfferMap.get(jComboBox1.getSelectedIndex());
        if (co == null) {
            JOptionPane.showMessageDialog(this, "Select a course first");
            return;
        }
        relatedCourseOffers.add(co);
        populateCombobox2(false);
        populateTable();
        JOptionPane.showMessageDialog(this, "Related course added");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            CourseOffer co = (CourseOffer) chooseObjectFromTable(jTable1, 0, "a course");
            relatedCourseOffers.remove(co);
            populateCombobox2(false);
            populateTable();
            JOptionPane.showMessageDialog(this, "Selected course deleted");
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        populateCombobox2(true);
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
