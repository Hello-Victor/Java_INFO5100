/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.main;

import Business.DB4OUtil.DB4OUtil;
import Business.Ecosystem;
import Business.Enterprise.HospitalSystem;
import Business.Enterprise.InsuranceSystem;
import Business.Enterprise.NewsSystem;
import Business.Enterprise.RescueSystem;
import Business.Enterprise.ResidentSystem;
import Business.Enterprise.SupplySystem;
import Business.Organization.CarInsuranceOrganization;
import Business.Organization.ElectricityOrganization;
import Business.Organization.EmergencyMessageOrganization;
import Business.Organization.FoodOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.HouseInsuranceOrganization;
import Business.Organization.RadioOrganization;
import Business.Organization.RescueOrganization;
import Business.Organization.ResidentOrganization;
import Business.Organization.TVOrganization;
import Business.Organization.WaterOrganization;
import Business.WorkQueue.NewsRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aeloyq
 */
public class BaseJPanel extends JPanel {

    /**
     * Creates new form baseJPanel
     */
    protected JPanel mainWorkArea;
    protected JPanel workArea;
    protected Ecosystem ecoSystem = Ecosystem.getInstance();
    protected InsuranceSystem insuranceSystem = ecoSystem.getInsuranceSystem();
    protected CarInsuranceOrganization carInsuranceOrganization = insuranceSystem.getCarInsuranceOrganization();
    protected HouseInsuranceOrganization houseInsuranceOrganization = insuranceSystem.getHouseInsuranceOrganization();
    protected HospitalSystem hospitalSystem = ecoSystem.getHospitalSystem();
    protected HospitalOrganization hospitalOrganization = hospitalSystem.getHospitalOrganization();
    protected RescueSystem rescueSystem = ecoSystem.getRescueSystem();
    protected RescueOrganization rescueOrganization = rescueSystem.getRescueOrganization();
    protected NewsSystem newsSystem = ecoSystem.getNewsSystem();
    protected RadioOrganization radioOrganization = newsSystem.getRadioOrganization();
    protected TVOrganization tvOrganization = newsSystem.getTvOrganization();
    protected EmergencyMessageOrganization emergencyMessageOrganization = newsSystem.getEmergencyMessageOrganization();
    protected SupplySystem supplySystem = ecoSystem.getSupplySystem();
    protected FoodOrganization foodOrganization = supplySystem.getFoodOrganization();
    protected ElectricityOrganization electricityOrganization = supplySystem.getElectricityOrganization();
    protected WaterOrganization waterOrganization = supplySystem.getWaterOrganization();
    protected ResidentSystem residentSystem = ecoSystem.getResidentSystem();
    protected ResidentOrganization residentOrganization = residentSystem.getResidentOrganization();
    protected NewsRequest currentEvent = (NewsRequest) newsSystem.getLatestEvent();

    public BaseJPanel(JPanel mainWorkArea) {
        this.mainWorkArea = mainWorkArea;
        this.workArea = mainWorkArea;
    }

    public JPanel getMainWorkArea() {
        return mainWorkArea;
    }

    public void backAction() {
        if (workArea.getComponents().length > 1) {
            workArea.remove(workArea.getComponents().length - 1);
            Component[] componentArray = workArea.getComponents();
            Component component = componentArray[componentArray.length - 1];
            BaseJPanel bjp = (BaseJPanel) component;
            bjp.refresh();
            CardLayout layout = (CardLayout) workArea.getLayout();
            layout.last(workArea);
        } else {
            logoutAction();
        }
    }

    public void logoutAction() {
        Component[] componentArray = mainWorkArea.getComponents();
        Login lgs = (Login) componentArray[0];
        mainWorkArea.removeAll();
        mainWorkArea.add(lgs);
        lgs.refresh();
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.first(mainWorkArea);
        DB4OUtil dB4OUtil = DB4OUtil.getInstance();
        dB4OUtil.storeSystem(ecoSystem);
    }

    public void refresh() {

    }

    public void info(String s) {
        JOptionPane.showMessageDialog(mainWorkArea, s, "Note", JOptionPane.INFORMATION_MESSAGE);
    }

    public void warn(String s) {
        JOptionPane.showMessageDialog(mainWorkArea, s, "Please Check!", JOptionPane.WARNING_MESSAGE);
    }

    public String inputbox(String s) {
        return JOptionPane.showInputDialog(mainWorkArea, s, "Input Box", JOptionPane.INFORMATION_MESSAGE);
    }

    public void nextPanel(JPanel nextJpanel) {
        mainWorkArea.add(nextJpanel);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
    }

    public void nextPanel(BaseJPanel nextJpanel) {
        nextJpanel.getMainWorkArea().add(nextJpanel);
        CardLayout layout = (CardLayout) nextJpanel.getMainWorkArea().getLayout();
        layout.next(nextJpanel.getMainWorkArea());
    }

    public void nextSubPanel(JPanel nextJpanel) {
        workArea.add(nextJpanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }

    public Object chooseObjectFromTable(JTable table, int column, String name) throws Exception {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            warn("Please choose " + name + " first!");
            throw new Exception();
        }
        return table.getValueAt(selectedRow, column);
    }

    public void setColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(240, 240, 240));
    }

    public void resetColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(255, 255, 255));
    }

    protected void configurePanel(JPanel panel) {
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColor(panel);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetColor(panel);
            }
        });
    }

    public void dorefreshTable(JTable jTable, List<Object[]> rows) {

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        for (Object[] row : rows) {
            model.addRow(row);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
