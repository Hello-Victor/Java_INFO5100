/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.DepartmentRole;

import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.College.College;
import model.Department.Department;
import model.Employer.EmployerDirectory;
import model.Employment.EmploymentHistory;
import model.Persona.StudentProfile;
import ui.main.BaseJPanel;

/**
 *
 * @author victor
 */
public class StudentAnalysis extends BaseJPanel {

    /**
     * Creates new form Analysis
     */
    private College college;
    private Department department;
    double averageGPA;
    double topGPA;
    double tailGPA;
    int studentSize;
    int averagePromotionTimes;
    int topPromotionTime;
    int tailPromotionTime;
    int averageSalary;
    int topSalary;
    int tailSalary;
    boolean sortByGPA = true;
    ArrayList<StudentProfile> students;

    public StudentAnalysis(JPanel mainWorkArea, Department department) {
        super(mainWorkArea);
        initComponents();
        this.mainWorkArea = mainWorkArea;
        this.college = department.getCollege();
        this.department = department;
        tblStudents.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = tblStudents.columnAtPoint(e.getPoint());
                if (col == 2 && (!sortByGPA)) {
                    sortByGPA = true;
                    populateTable();
                } else if (col == 3 && (sortByGPA)) {
                    sortByGPA = false;
                    populateTable();
                }
            }
        }
        );
        refreshTable();
    }

    @Override
    public void refreshTable() {
        HashMap<String, StudentProfile> studentMap = department.getStudentdirectory().getStudentMap();
        students = new ArrayList<StudentProfile>();
        for (StudentProfile each : studentMap.values()) {
            if (each.isGraduated()) {
                students.add(each);
            }
        }
        populateTable();
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
        tblStudents = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtSummary = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Rank", "Name", "GPA", "Salary", "Promotions", "Job Performance▼"
            }
        ));
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        jLabel7.setText("Summary:");

        txtSummary.setColumns(20);
        txtSummary.setRows(5);
        jScrollPane2.setViewportView(txtSummary);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked

    }//GEN-LAST:event_tblStudentsMouseClicked

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);
        if (!sortByGPA) {
            model.setColumnIdentifiers(new Object[]{"Rank", "Name", "GPA", "Job Performance▼", "Salary", "Promotions"});
            Collections.sort(students, Comparator.comparing((StudentProfile s) -> s.getEmploymenthistory().getWeight()).reversed());
        } else {
            model.setColumnIdentifiers(new Object[]{"Rank", "Name", "GPA▼", "Job Performance", "Salary", "Promotions"});
            Collections.sort(students, Comparator.comparing((StudentProfile s) -> s.getGPA()).reversed());
        }
        averageGPA = 0.0;
        topGPA = 0.0;
        tailGPA = 4.0;
        studentSize = 0;
        averagePromotionTimes = 0;
        topPromotionTime = 0;
        tailPromotionTime = 10;
        averageSalary = 0;
        topSalary = 0;
        tailSalary = 1000000;
        int index = 0;
        for (StudentProfile each : students) {
            EmploymentHistory employmentHistory = each.getEmploymenthistory();
            index++;
            Object row[] = new Object[6];
            row[0] = index;
            row[1] = each.getPerson().getLastname();
            row[2] = String.format("%.2f", each.getGPA());
            row[3] = String.format("%.2f", employmentHistory.getWeight());
            row[4] = "$" + employmentHistory.getAverageSalary() / 1000 + "k";
            row[5] = employmentHistory.getPromotionTimes();
            model.addRow(row);
            studentSize++;
            averageGPA += each.getGPA();
            averagePromotionTimes += employmentHistory.getPromotionTimes();
            averageSalary += employmentHistory.getAverageSalary();
            topGPA = Math.max(topGPA, each.getGPA());
            tailGPA = Math.min(tailGPA, each.getGPA());
            topPromotionTime = Math.max(topPromotionTime, employmentHistory.getPromotionTimes());
            tailPromotionTime = Math.min(tailPromotionTime, employmentHistory.getPromotionTimes());
            topSalary = Math.max(topSalary, employmentHistory.getAverageSalary());
            tailSalary = Math.min(tailSalary, employmentHistory.getAverageSalary());

        }
        averageGPA = averageGPA / studentSize;
        averagePromotionTimes = averagePromotionTimes / studentSize;
        averageSalary = averageSalary / studentSize;
        populateSummary();
    }

    public void populateSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Department graduates career track report:");
        summary.append("\n");
        summary.append("1. The average GPA: " + String.format("%.2f", averageGPA));
        summary.append("\n");
        summary.append("1.1 the highest GPA: " + String.format("%.2f", topGPA));
        summary.append("\n");
        summary.append("1.2 the lowesr GPA: " + String.format("%.2f", tailGPA));
        summary.append("\n");
        summary.append("2. The average promotion times: " + averagePromotionTimes);
        summary.append("\n");
        summary.append("2.1 the highest promotion time: " + topPromotionTime);
        summary.append("\n");
        summary.append("2.2 the lowest promotion time: " + tailPromotionTime);
        summary.append("\n");
        summary.append("3. The average salary: " + "$" + averageSalary / 1000 + "k");
        summary.append("\n");
        summary.append("3.1 the highest salary: " + "$" + topSalary / 1000 + "k");
        summary.append("\n");
        summary.append("3.2 the lowest salary: " + "$" + tailSalary / 1000 + "k");
        summary.append("\n");

        txtSummary.setLineWrap(true);
        txtSummary.setWrapStyleWord(true);
        txtSummary.setText(summary.toString());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextArea txtSummary;
    // End of variables declaration//GEN-END:variables
}
