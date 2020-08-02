package simulador_malha_viária.view;

import javax.swing.JButton;
import simulador_malha_viária.controller.ControllerNewGame;
import simulador_malha_viária.controller.observer.ObserverNewGame;

/**
 *
 * @author Leonardo Steinke
 */
public class NewGame extends javax.swing.JFrame implements ObserverNewGame {

    ControllerNewGame newGameControl;
    Map view;

    public NewGame() {
        initComponents();
        setLocationRelativeTo(null);
        newGameControl = ControllerNewGame.getIntance();
        newGameControl.attachMap(this);
        radioGroup.add(radioMutex);
        radioGroup.add(radioMonitor);
        radioMutex.setSelected(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        txtSelectMap = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnOption2 = new javax.swing.JButton();
        btnOption3 = new javax.swing.JButton();
        btnOption1 = new javax.swing.JButton();
        radioMutex = new javax.swing.JRadioButton();
        radioMonitor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSelectMap.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txtSelectMap.setText("Selecione o mapa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        btnOption2.setText("Opção 2");
        btnOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOption2ActionPerformed(evt);
            }
        });

        btnOption3.setText("Opção 3");
        btnOption3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOption3ActionPerformed(evt);
            }
        });

        btnOption1.setText("Opção 1");
        btnOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOption1ActionPerformed(evt);
            }
        });

        radioMutex.setText("Mutex");
        radioMutex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMutexActionPerformed(evt);
            }
        });

        radioMonitor.setText("Monitor");
        radioMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMonitorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtSelectMap))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOption1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(radioMutex)
                                .addComponent(radioMonitor)))
                        .addGap(40, 40, 40)
                        .addComponent(btnOption2)
                        .addGap(47, 47, 47)
                        .addComponent(btnOption3)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(txtSelectMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(radioMutex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioMonitor)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOption3)
                            .addComponent(btnOption2)
                            .addComponent(btnOption1))))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOption1ActionPerformed
        newGameControl.selectMap(1, radioMutex.isSelected());
    }//GEN-LAST:event_btnOption1ActionPerformed

    private void btnOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOption2ActionPerformed
        newGameControl.selectMap(2, radioMutex.isSelected());
    }//GEN-LAST:event_btnOption2ActionPerformed

    private void btnOption3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOption3ActionPerformed
        newGameControl.selectMap(3, radioMutex.isSelected());
    }//GEN-LAST:event_btnOption3ActionPerformed

    private void radioMutexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMutexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMutexActionPerformed

    private void radioMonitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMonitorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMonitorActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOption1;
    private javax.swing.JButton btnOption2;
    private javax.swing.JButton btnOption3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JRadioButton radioMonitor;
    private javax.swing.JRadioButton radioMutex;
    private javax.swing.JLabel txtSelectMap;
    // End of variables declaration//GEN-END:variables

    @Override
    public void selectMap() {
        view = Map.getIntance();

        view.setVisible(true);
        setVisible(false);
    }
}
