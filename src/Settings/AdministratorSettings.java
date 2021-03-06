/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Settings;

import static MainFiles.IndexPage.AdminSettings;
import static MainFiles.IndexPage.dskPane_RightPanel;
import db.ConnectSql;
import functions.ValidateFields;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class AdministratorSettings extends javax.swing.JInternalFrame {

    /**
     * Creates new form AdministratorSettings
     */
    public AdministratorSettings() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelDataFiles = new javax.swing.JPanel();
        TabbedPaneDataFiles = new javax.swing.JTabbedPane();
        PanelItem = new javax.swing.JPanel();
        PanelTransactions = new javax.swing.JPanel();
        TabbedPaneTransaction = new javax.swing.JTabbedPane();
        PanelPurchaseOrder = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PanelGRN = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setIconifiable(true);
        setTitle("Administrator Settings");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        panelDataFiles.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        panelDataFiles.setForeground(new java.awt.Color(255, 255, 255));
        panelDataFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelDataFilesMouseClicked(evt);
            }
        });

        TabbedPaneDataFiles.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout PanelItemLayout = new javax.swing.GroupLayout(PanelItem);
        PanelItem.setLayout(PanelItemLayout);
        PanelItemLayout.setHorizontalGroup(
            PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        PanelItemLayout.setVerticalGroup(
            PanelItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        TabbedPaneDataFiles.addTab("Item", PanelItem);

        javax.swing.GroupLayout panelDataFilesLayout = new javax.swing.GroupLayout(panelDataFiles);
        panelDataFiles.setLayout(panelDataFilesLayout);
        panelDataFilesLayout.setHorizontalGroup(
            panelDataFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneDataFiles)
        );
        panelDataFilesLayout.setVerticalGroup(
            panelDataFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneDataFiles)
        );

        jTabbedPane1.addTab("Data files", panelDataFiles);

        TabbedPaneTransaction.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Main Category");

        javax.swing.GroupLayout PanelPurchaseOrderLayout = new javax.swing.GroupLayout(PanelPurchaseOrder);
        PanelPurchaseOrder.setLayout(PanelPurchaseOrderLayout);
        PanelPurchaseOrderLayout.setHorizontalGroup(
            PanelPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPurchaseOrderLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(555, Short.MAX_VALUE))
        );
        PanelPurchaseOrderLayout.setVerticalGroup(
            PanelPurchaseOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPurchaseOrderLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        TabbedPaneTransaction.addTab("Purchase Order", PanelPurchaseOrder);

        PanelGRN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Sub Category Name");
        PanelGRN.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 114, 20));

        TabbedPaneTransaction.addTab("GRN", PanelGRN);

        javax.swing.GroupLayout PanelTransactionsLayout = new javax.swing.GroupLayout(PanelTransactions);
        PanelTransactions.setLayout(PanelTransactionsLayout);
        PanelTransactionsLayout.setHorizontalGroup(
            PanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneTransaction)
        );
        PanelTransactionsLayout.setVerticalGroup(
            PanelTransactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneTransaction)
        );

        jTabbedPane1.addTab("Transactions", PanelTransactions);

        btnSave.setMnemonic('s');
        btnSave.setText("Save");
        btnSave.setActionCommand("Delete");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnExit.setMnemonic('e');
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(btnExit))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        CheckBeforeSave();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CheckBeforeSave();
        }
    }//GEN-LAST:event_btnSaveKeyPressed

    private void CheckBeforeSave(){
        
    }
    
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        exit();
    }//GEN-LAST:event_btnExitActionPerformed

    private void exit() {
        if (AdminSettings != null) {
            AdminSettings = null;
        }
        this.dispose();
    }
    
    private void panelDataFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelDataFilesMouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {
            Refresh();
        }
    }//GEN-LAST:event_panelDataFilesMouseClicked

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        AdminSettings.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

    private void Refresh(){
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGRN;
    private javax.swing.JPanel PanelItem;
    private javax.swing.JPanel PanelPurchaseOrder;
    private javax.swing.JPanel PanelTransactions;
    private javax.swing.JTabbedPane TabbedPaneDataFiles;
    private javax.swing.JTabbedPane TabbedPaneTransaction;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelDataFiles;
    // End of variables declaration//GEN-END:variables
}
