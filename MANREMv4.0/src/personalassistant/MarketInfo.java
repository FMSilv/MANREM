/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personalassistant;

/**
 *
 * @author João
 */
public class MarketInfo extends javax.swing.JFrame {

    /**
     * Creates new form MarketInfo
     */
    
    PersonalAssistant PA;
    String AgentName;
    boolean isDayAhead;
    boolean isSMP;
    boolean isOTC;
    boolean isProducer;
    ProducerData Producer;
    BuyerData Buyer;

    
    public MarketInfo(PersonalAssistant _PA, String _AgentName, boolean _isDayAhead, boolean _isSMP , boolean _isOTC, boolean _isProducer) {
        
        AgentName = _AgentName;
        PA = _PA;
        isDayAhead = _isDayAhead;
        isSMP = _isSMP;
        isOTC = _isOTC;
        isProducer = _isProducer;
        
        if(isProducer){
            for(int i = 0; i < PA.Producers_Information.size(); i++){
                if(PA.Producers_Information.get(i).getName().equals(_AgentName)){
                    Producer = PA.Producers_Information.get(i);
                    break;
                }    
            }
        } else {
            for(int i = 0; i < PA.Buyers_Information.size(); i++){
                if(PA.Buyers_Information.get(i).getName().equals(_AgentName)){
                    Buyer = PA.Buyers_Information.get(i);
                    break;
                }    
            }
        }
        
        
        initComponents();
        defineWindow();

    }
    
    private void defineWindow() {

        this.setTitle("Market Info");
        

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), 
                AgentName, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        
        if(isDayAhead){
            if(isSMP){
                jTextField_Market.setText("Day Ahead with SMP algorithm");
            } else {
                jTextField_Market.setText("Day Ahead with LMP algorithm");
            }
        } else if(isOTC) {
            jTextField_Market.setText("OTC");
        }
        
        
        
        if(isProducer){
            if(Producer.getObjective().contains("buy")){
                jTextField_Action.setText("Buying Electricity ");
            }
            if(Producer.getObjective().contains("sell")){
                jTextField_Action.setText("Selling Electricity");
            }
            this.initComboBox(true);
            jButtonNext.setEnabled(false);
        } else {
            if(Buyer.getObjective().contains("buy")){
                jTextField_Action.setText("Buying Electricity ");
            }
            if(Buyer.getObjective().contains("sell")){
                jTextField_Action.setText("Selling Electricity");
            }
            this.initComboBox(false);
            jButtonNext.setEnabled(false);
        }
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }
    
    private void setBStratComboBox(String BusinessStrat) {
        
        
    }
    
    public void initComboBox(boolean isProducer) {
        
        boolean ThermalTech;
        boolean HydroTech;
        boolean WindTech;
        boolean SolarTech;
        String BusinessStrat = "";

        jComboBox_BStrat.removeAllItems();
        jComboBox_BStrat.addItem("Select Businness Strategy");
        jComboBox_BStrat.addItem("Default Strategy - Load offer data from file");
        
        if(isProducer){
            if(Producer.DataThermal.isEmpty()){
                ThermalTech = false;
            } else {
                ThermalTech = true;
            }
            if(Producer.DataWind.isEmpty()){
                WindTech = false;
            } else {
                WindTech = true;
            }
            if(Producer.DataHydro.isEmpty()){
                HydroTech = false;
            } else {
                HydroTech = true;
            }

            if(ThermalTech){
                BusinessStrat = "Conejo Model - Thermal";
            }

            if(ThermalTech && WindTech){
                BusinessStrat = "Zhang Model - Thermal and Wind";
            }

            if(ThermalTech && WindTech && HydroTech){
                BusinessStrat = "Moghimi Model - Thermal, Hydro and Wind";
            }


            jComboBox_BStrat.addItem(BusinessStrat);
        }
        
        jComboBox_BStrat.setSelectedIndex(0);
    }

    private MarketInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_BStrat = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_Market = new javax.swing.JTextField();
        jTextField_Action = new javax.swing.JTextField();
        jButtonNext = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Business Strategy:");

        jComboBox_BStrat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_BStrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_BStratActionPerformed(evt);
            }
        });

        jLabel2.setText("Action:");

        jLabel3.setText("Market:");

        jTextField_Market.setText("jTextField1");

        jTextField_Action.setText("jTextField2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_BStrat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Action, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Market, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_Market, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_Action, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_BStrat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 320, Short.MAX_VALUE)
                        .addComponent(jButtonCancel)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonNext)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        
        
        if(isProducer){
            for(int i = 0; i < PA.Producers_Information.size(); i++){
                if(PA.Producers_Information.get(i).getName().equals(Producer.getName())){
                    // Producer is set as participating and strategy is stored on PersonalAssisntant's data structure
                    PA.Producers_Information.get(i).setStrategy(jComboBox_BStrat.getSelectedItem().toString());
                    PA.Producers_Information.get(i).setParticipating(true);
                    // calls method to inform agent it is participating
                    PA.inform_participants(true, Producer.getName(), jComboBox_BStrat.getSelectedItem().toString());
                    break;
                }    
            }
        } else {
            for(int i = 0; i < PA.Buyers_Information.size(); i++){
                if(PA.Buyers_Information.get(i).getName().equals(Buyer.getName())){
                    // Producer is set as participating and strategy is stored on PersonalAssisntant's data structure
                    PA.Buyers_Information.get(i).setStrategy(jComboBox_BStrat.getSelectedItem().toString());
                    PA.Buyers_Information.get(i).setParticipating(true);
                    // calls method to inform agent it is participating
                    PA.inform_participants(false, Buyer.getName(), jComboBox_BStrat.getSelectedItem().toString());
                    break;
                }    
            }
        }
        
        this.dispose();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jComboBox_BStratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_BStratActionPerformed
        // TODO add your handling code here:
        
        int i;
        i = jComboBox_BStrat.getSelectedIndex();

        if(i > 0){
            jButtonNext.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox_BStratActionPerformed

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
            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarketInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JComboBox jComboBox_BStrat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField_Action;
    private javax.swing.JTextField jTextField_Market;
    // End of variables declaration//GEN-END:variables
}
