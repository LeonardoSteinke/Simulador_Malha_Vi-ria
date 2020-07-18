/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador_malha_viária.view;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import simulador_malha_viária.controller.ControllerMap;
import simulador_malha_viária.controller.observer.ObserverMap;

/**
 *
 * @author Leonardo Steinke e Gustavo Salvalaggio
 */
public class Map extends javax.swing.JFrame implements ObserverMap {

    /**
     * Creates new form View
     */
    private ControllerMap controlMap;

    private JPanel[][] jpMapItem;

    private static Map instance = null;

    public static Map getIntance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    private Map() {
        initComponents();
        setLocationRelativeTo(null);
        controlMap = ControllerMap.getIntance();
        controlMap.attachMap(this);
        setResizable(false);
        setTitle("Simulador Malha Viária");
        controlMap.mapLoad();

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtQuantidadeVeiculos = new javax.swing.JSpinner();
        btnConfirmar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnEncerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JLabel();
        jpMap = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Quantidade de veículos simultâneos ");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnIniciar.setText("Iniciar Simulação");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnEncerrar.setText("Finalizar Simulação");
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantidade de veículos atuais: ");

        txtQtd.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txtQtd.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edtQuantidadeVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEncerrar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQtd)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtQuantidadeVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQtd)
                .addGap(59, 59, 59)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jpMap.setMinimumSize(new java.awt.Dimension(500, 500));
        jpMap.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jpMapLayout = new javax.swing.GroupLayout(jpMap);
        jpMap.setLayout(jpMapLayout);
        jpMapLayout.setHorizontalGroup(
            jpMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jpMapLayout.setVerticalGroup(
            jpMapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEncerrarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        controlMap.setCars(Integer.parseInt(edtQuantidadeVeiculos.getValue().toString()));
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIniciarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JSpinner edtQuantidadeVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpMap;
    private javax.swing.JLabel txtQtd;
    // End of variables declaration//GEN-END:variables

//    class RoadTableModel extends AbstractTableModel {
//
//        public RoadTableModel() {
//
//        }
//
//        @Override
//        public int getRowCount() {
//            return controlMap.getRows();
//        }
//
//        @Override
//        public int getColumnCount() {
//
//            return controlMap.getColumns();
//
//        }
//
//        @Override
//        public Object getValueAt(int rowIndex, int columnIndex) {
//            return new ImageIcon(controlMap.getMatrixPosition(rowIndex, columnIndex));
//        }
//    }
    @Override
    public void setTable(int matrix[][], int rows, int collumns) {
        System.out.println("to aqui");
        jpMap.removeAll();
        jpMapItem = new JPanel[rows][collumns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.red);
                panel.add(new JLabel(""+matrix[i][j]));
                jpMapItem[i][j] = panel;
                jpMap.add(panel);
            }
        }
        jpMap.repaint();

//        DefaultTableModel model = (DefaultTableModel) jTableMap.getModel();
//        model.setColumnCount(collumns);
//        model.setRowCount(rows);
//        model.setNumRows(rows);
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < collumns; j++) {
//                System.out.println("teste");
//                model.setValueAt(matrix[i][j], i, j);
//            }
//        }
    }

    @Override
    public void setQtdCars(int value) {
        txtQtd.setText("" + value);
    }

    @Override
    public void setQtdCarsError() {
        JOptionPane.showMessageDialog(null, "Você não pode informar uma quantidade\nnegativa de veículos", "Error", 2);

    }

}
