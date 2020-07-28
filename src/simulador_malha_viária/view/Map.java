package simulador_malha_viária.view;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import simulador_malha_viária.controller.ControllerMap;
import simulador_malha_viária.controller.observer.ObserverMap;

/**
 *
 * @author Leonardo Steinke
 */
public class Map extends javax.swing.JFrame implements ObserverMap {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMap = new javax.swing.JTable();

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

        jTableMap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableMap.setEnabled(false);
        jTableMap.setMaximumSize(new java.awt.Dimension(25, 25));
        jTableMap.setMinimumSize(new java.awt.Dimension(25, 25));
        jTableMap.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableMap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
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


    }//GEN-LAST:event_btnIniciarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JSpinner edtQuantidadeVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMap;
    private javax.swing.JLabel txtQtd;
    // End of variables declaration//GEN-END:variables

    JLabel imageLabel = new JLabel();
    private ImageIcon image = new ImageIcon("./assets/asfalto.jpg");

    @Override
    public void setTable(int matrix[][], int rows, int collumns) {
        DefaultTableModel model = new DefaultTableModel() {

            @Override
            public int getRowCount() {
                return controlMap.getRows();
            }

            @Override
            public int getColumnCount() {
                return controlMap.getColumns();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                try {
                    return image;

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                    return null;
                }
            }
        };
        model.setRowCount(rows);
        model.setColumnCount(collumns);

        imageLabel.setIcon(image);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collumns; j++) {
                if (matrix[i][j] == 0) {
                    model.setValueAt(imageLabel, i, j);

                } else {
                    model.setValueAt(matrix[i][j], i, j);
                }
            }
        }
        jTableMap.setRowHeight(30);
        jTableMap.setModel(model);
        jTableMap.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableMap.setOpaque(false);
        jTableMap.setIntercellSpacing(new Dimension(-1, 0));
        jTableMap.setDefaultRenderer(Object.class, new ImageRenderer());

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setPreferredSize(new Dimension(0, 0));

        for (int i = 0; i < jTableMap.getColumnModel().getColumnCount(); i++) {
            TableColumn column = jTableMap.getColumnModel().getColumn(i);
            column.setHeaderRenderer(renderer);

            column.setPreferredWidth(30);
        }

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
