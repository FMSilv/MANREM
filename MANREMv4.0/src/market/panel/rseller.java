/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package market.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import personalassistant.PersonalAssistant;

/**
 *
 * @author Hugo
 */
public class rseller extends javax.swing.JPanel {

    public PersonalAssistant mark;
    /**
     * Creates new form risk
     */
    public rseller(PersonalAssistant market) {
        mark=market;
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


        
        Listener listener = new Listener();

                  jLabel1 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jTbuyer = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setText("Agent Type:");

jCheckBox5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jCheckBox5.setText("Risk-Averse");
        jCheckBox5.addItemListener(listener);
        
        
      

        jCheckBox6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jCheckBox6.setText("Risk-Neutral");        
        jCheckBox6.addItemListener(listener);
        jCheckBox6.setSelected(true);

        jCheckBox7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jCheckBox7.setText("Risk-Seeking");
        jCheckBox7.addItemListener(listener);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel12.setText("Risk Premium:");
        
        jTbuyer.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTbuyer.setPreferredSize(new Dimension(40,25));
        jTbuyer.setText("1,0");
        jTbuyer.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            mark.buyer_risk_exposure=Double.valueOf(jTbuyer.getText());
        
           }});

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTbuyer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jCheckBox5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox6)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTbuyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>

     private class Listener implements ItemListener {
public void itemStateChanged(ItemEvent e) {
  
    Object source = e.getItemSelectable();

    if (source == jCheckBox5 && e.getStateChange() != ItemEvent.DESELECTED) {
        mark.seller_risk=1;
//        buyer.setDemandResponse(demandresponse);
        if(jCheckBox6.isSelected()){
         jCheckBox6.setSelected(false);
        }
        if(jCheckBox7.isSelected()){
         jCheckBox7.setSelected(false);
        }
//         chinButton.setSelected(true);
    }
     if (source == jCheckBox5 && e.getStateChange() == ItemEvent.DESELECTED) {
            
//            buyer.setDemandResponse(demandresponse);
            if(jCheckBox6.isSelected()){
         mark.seller_risk=0;
        }
               if(jCheckBox7.isSelected()){
//         mark.seller_risk=2;
                   mark.seller_risk=1;//Provisorio
        }
             if(!jCheckBox6.isSelected()&&!jCheckBox7.isSelected()){
                 jCheckBox5.setSelected(true);
             }
               
               
//             chinButton.setSelected(false);
        }
         if (source == jCheckBox6 && e.getStateChange() != ItemEvent.DESELECTED) {
        mark.seller_risk=0;
//        buyer.setDemandResponse(demandresponse);
        if(jCheckBox5.isSelected()){
         jCheckBox5.setSelected(false);
        }
        if(jCheckBox7.isSelected()){
         jCheckBox7.setSelected(false);
        }
    
    }
     if (source == jCheckBox6 && e.getStateChange() == ItemEvent.DESELECTED) {
            
//            buyer.setDemandResponse(demandresponse);
            if(jCheckBox5.isSelected()){
         mark.seller_risk=1;
        }
               if(jCheckBox7.isSelected()){
//         mark.seller_risk=2;
         mark.seller_risk=1;//Provisorio
        }
               if(!jCheckBox5.isSelected()&&!jCheckBox7.isSelected()){
                 jCheckBox6.setSelected(true);
             }
//             chinButton.setSelected(false);
        }
              if (source == jCheckBox7 && e.getStateChange() != ItemEvent.DESELECTED) {
//        mark.seller_risk=2;
        mark.seller_risk=1;//Provisorio
//        buyer.setDemandResponse(demandresponse);
        if(jCheckBox5.isSelected()){
         jCheckBox5.setSelected(false);
        }
        if(jCheckBox6.isSelected()){
         jCheckBox6.setSelected(false);
        }
    
    }
     if (source == jCheckBox7 && e.getStateChange() == ItemEvent.DESELECTED) {
            
//            buyer.setDemandResponse(demandresponse);
            if(jCheckBox5.isSelected()){
        mark.seller_risk=1;
        }
               if(jCheckBox6.isSelected()){
         mark.seller_risk=0;
        }
               if(!jCheckBox6.isSelected()&&!jCheckBox5.isSelected()){
                 jCheckBox7.setSelected(true);
             }
//             chinButton.setSelected(false);
        }
     
}
}
//     private class Listener2 implements ChangeListener {
//public void StateChanged(ChangeEvent e) {
//  
//    Object source = e.getSource();
//    
//    if (source == JSpinner1 && e.getStateChange() != ItemEvent.DESELECTED) {
//    
//}
//}
//     }
    // Variables declaration - do not modify
  public javax.swing.JCheckBox jCheckBox5;
    public javax.swing.JCheckBox jCheckBox6;
    public javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    public javax.swing.JTextField jTbuyer;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration
}