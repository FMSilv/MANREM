/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OTC;

import jade.core.Agent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.read.biff.BiffException;

/**
 *
 * @author João de Sá
 */
public class Participants extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    private OTC_Controller Controller;
    private Agent market;
    private boolean isSeller;
    private int StartHour;
    private int EndHour;
    private final String[] Table = {"Id", "Name", "OTC", "Pool"};
    private String[] agentNames;
    private ArrayList<Object> agentList;
    String AgentName;
    
    boolean OTC;
    boolean Pool;
    
     public Participants() {
        initComponents();
    }
    
    //Alternate Constructors for class Participants 
     
    public Participants(Agent _market, OTC_Controller _Controller, boolean _isSeller, int _StartHour, int _EndHour) {
        
        initComponents();
        
        Controller = _Controller;
        market = _market;
        isSeller = _isSeller;
        StartHour = _StartHour;
        EndHour = _EndHour;
        agentList = new ArrayList<>();
        

        
        defineWindow(isSeller);
        setLabel(isSeller);
        setAgentComboBox(isSeller);
        printOutputTable(null, Table);
  
    }
        
    public Participants(boolean isSeller){   //Lembrar de tirar este depois!
        
        initComponents();
        defineWindow(isSeller);
        setLabel(isSeller);
        setAgentComboBox(isSeller);
        
    }
    
    
    private void defineWindow(boolean isSeller) {
        if(isSeller){
            this.setTitle("GenCo Data");
        }
        else{
            this.setTitle("RetailCo Data");
        }
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jButtonSave.setEnabled(false);
    }
    
    
    private void setLabel(boolean isSeller){
        
        if (isSeller) {
            jLabel1.setText("Generator:");
        } else {
            jLabel1.setText("Retailer:");
        }
        
    }
    
    public void printOutputTable(Object[][] insertData, String[] columnSize) {
        DefaultTableModel table = new DefaultTableModel(insertData, columnSize);
        jTable1.setModel(table);
        configOutputTable(columnSize.length);
    }
    
    private void configOutputTable(int _size){

        for (int i = 0; i < _size; i++) {
            jTable1.getColumnModel().getColumn(i).setMinWidth(70);
        }
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setHorizontalAlignment(JLabel.CENTER);
        jTable1.setDefaultRenderer(Object.class, render);
    }
    
    private void setAgentComboBox(boolean isSeller) {
        if (isSeller) {
            agentNames = Controller.getSellerNames();
        } else {
            agentNames = Controller.getBuyerNames();
        }        
        initComboBox();
    }
    
    
    public void initComboBox() {
        boolean verif;

        jComboBox1.removeAllItems();
        jComboBox1.addItem("Select Agent");

        if (agentList.isEmpty()) {
            for (int i = 0; i < agentNames.length; i++) {
                
               jComboBox1.addItem(agentNames[i]);
            }
        }    
        //else {
        //    for (int i = 0; i < agentNames.length; i++) {
        //        verif = false;
        //        for (String name : agentList) {
        //            if (name.equalsIgnoreCase(agentNames[i])) {
        //                verif = true;
        //                break;
        //            }
        //        }
        //        if (!verif) {
        //            jComboBox1.addItem(agentNames[i]);
        //        }
        //    }
        //}
        //if (jComboBox1.getItemCount() == 0) {
        //    jComboBox1.addItem("");
        //}
        jComboBox1.setSelectedIndex(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxOTC = new javax.swing.JCheckBox();
        jCheckBoxPool = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jCheckBoxOTC.setText("OTC Market");
        jCheckBoxOTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxOTCActionPerformed(evt);
            }
        });

        jCheckBoxPool.setText("Day-Ahead Market");
        jCheckBoxPool.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPoolActionPerformed(evt);
            }
        });

        jLabel2.setText("Participating in:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxOTC)
                            .addComponent(jCheckBoxPool)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxOTC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBoxPool)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed

        try {
            Controller.ReadFile(AgentName, isSeller, OTC, Pool);
        } catch (BiffException ex) {
            Logger.getLogger(Participants.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jCheckBoxOTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxOTCActionPerformed
        // TODO add your handling code here:
        OTC = jCheckBoxOTC.isSelected();
    }//GEN-LAST:event_jCheckBoxOTCActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        int i;
        i = jComboBox1.getSelectedIndex();
        
        if(i > 0){
            AgentName = agentNames[i-1];
            if(OTC || Pool){
                jButtonSave.setEnabled(true);
            }
            else
                JOptionPane.showMessageDialog(null, "No market selected!\n",
                                "Verify Input Data", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jCheckBoxPoolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPoolActionPerformed
        // TODO add your handling code here:
        Pool = jCheckBoxPool.isSelected();
    }//GEN-LAST:event_jCheckBoxPoolActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Participants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Participants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Participants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Participants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Participants().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxOTC;
    private javax.swing.JCheckBox jCheckBoxPool;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}