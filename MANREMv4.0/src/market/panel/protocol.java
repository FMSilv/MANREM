/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package market.panel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import personalassistant.PersonalAssistant;

/**
 *
 * @author Hugo
 */
public class protocol extends javax.swing.JPanel {

    /**
     * Creates new form protocol
     */
    
    public PersonalAssistant mark;
    
    public protocol(PersonalAssistant market) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

//        jSeparator3 = new javax.swing.JSeparator();
//        jLabel3 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();

        
        Listener listener = new Listener();
        
//        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
//        jSeparator3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
//
//        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
//        jLabel3.setText("Please select a format for the Trading Process.");

        jCheckBox4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jCheckBox4.setText("Contract Net");
        jCheckBox4.addItemListener(listener);
//        jCheckBox4.setEnabled(false);
           
        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setText("Interaction Protocol:");

        jCheckBox3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jCheckBox3.setText("Alternating Offers");
        jCheckBox3.addItemListener(listener);
        jCheckBox3.setSelected(true);
//        jCheckBox3.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addContainerGap()
//                        .addComponent(jSeparator3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(22, 22, 22)
//                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox4)
                                    .addComponent(jCheckBox3))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGap(27, 27, 27)
//                .addComponent(jLabel3)
                .addGap(29, 29, 29)
//                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jCheckBox3)
                        .addGap(38, 38, 38)
                        .addComponent(jCheckBox4)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>

     private class Listener implements ItemListener {
public void itemStateChanged(ItemEvent e) {
  
    Object source = e.getItemSelectable();

    if (source == jCheckBox3 && e.getStateChange() != ItemEvent.DESELECTED) {
//        demandresponse=1;
//        buyer.setDemandResponse(demandresponse);
        if(jCheckBox4.isSelected()){
         jCheckBox4.setSelected(false);
        }
//         chinButton.setSelected(true);
    }
     if (source == jCheckBox3 && e.getStateChange() == ItemEvent.DESELECTED) {
//            demandresponse=0;
//            buyer.setDemandResponse(demandresponse);
            if(!jCheckBox4.isSelected()){
         jCheckBox4.setSelected(true);
        }
             
//             chinButton.setSelected(false);
        }
         if (source == jCheckBox4 && e.getStateChange() != ItemEvent.DESELECTED) {
//        demandresponse=0;
//        buyer.setDemandResponse(demandresponse);
         if(jCheckBox3.isSelected()){
         jCheckBox3.setSelected(false);
        }
//         chinButton.setSelected(true);
    
    }
     if (source == jCheckBox4 && e.getStateChange() == ItemEvent.DESELECTED) {
//            demandresponse=1;
//            buyer.setDemandResponse(demandresponse);
             if(!jCheckBox3.isSelected()){
            jCheckBox3.setSelected(true);
            }
//             chinButton.setSelected(false);
        }
     
}
}

    // Variables declaration - do not modify
    public javax.swing.JCheckBox jCheckBox3;
    public javax.swing.JCheckBox jCheckBox4;
//    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
//    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration
}
