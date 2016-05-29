/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainCategory.java
 *
 * Created on Apr 5, 2016, 2:45:44 PM
 */
package MainFiles;

import static MainFiles.IndexPage.MainCat;
import db.ConnectSql;
import functions.ValidateFields;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ravindu
 */
public class MainCategory extends javax.swing.JInternalFrame {

    /**
     * First value of the any Combo Box. Represent the Value "--Select--"
     */
    private final String select = "--Select--";
    private final DefaultTableModel model_categoryTable;
    private final String spliter = "--";

    /**
     * Creates new form MainCategory
     */
    public MainCategory() {
        initComponents();

        btnGrup_yesNo.add(rBtnCode);
        btnGrup_yesNo.add(rBtnName);
        rBtnCode.setSelected(true);
        txtCode.requestFocus();
        model_categoryTable = (DefaultTableModel) TableCategory.getModel();
        panel1.setToolTipText("Press right mouse click to refresh.");

        LoadCategories();
        loadTypes();
        loadBaseCategoriesToCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrup_yesNo = new javax.swing.ButtonGroup();
        pnl_Base = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        lbl_category = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtCategoryName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lbl_description = new javax.swing.JLabel();
        lbl_subAccount = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        rBtnCode = new javax.swing.JRadioButton();
        rBtnName = new javax.swing.JRadioButton();
        lbl_accountType = new javax.swing.JLabel();
        cmbTypes = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCategory = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lbl_description1 = new javax.swing.JLabel();
        ComboBaseCategory = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        setTitle("Main Category");
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

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        panel1.setForeground(new java.awt.Color(255, 255, 255));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_category.setForeground(new java.awt.Color(102, 102, 102));
        lbl_category.setText("Main category code");
        panel1.add(lbl_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 110, 20));

        txtCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodeFocusGained(evt);
            }
        });
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodeKeyReleased(evt);
            }
        });
        panel1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 170, 20));

        txtCategoryName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCategoryNameFocusGained(evt);
            }
        });
        txtCategoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoryNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryNameKeyReleased(evt);
            }
        });
        panel1.add(txtCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 210, 20));

        btnSave.setMnemonic('s');
        btnSave.setText("Save");
        btnSave.setActionCommand("Delete");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 80, -1));

        btnDelete.setMnemonic('d');
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        panel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 80, -1));

        lbl_description.setForeground(new java.awt.Color(102, 102, 102));
        lbl_description.setText("Base category");
        panel1.add(lbl_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 110, 20));

        lbl_subAccount.setForeground(new java.awt.Color(102, 102, 102));
        lbl_subAccount.setText("Search main category by");
        panel1.add(lbl_subAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, 20));

        btnExit.setMnemonic('e');
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        btnExit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExitKeyPressed(evt);
            }
        });
        panel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 80, -1));

        rBtnCode.setBackground(new java.awt.Color(255, 255, 255));
        btnGrup_yesNo.add(rBtnCode);
        rBtnCode.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        rBtnCode.setText("Code");
        rBtnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnCodeActionPerformed(evt);
            }
        });
        panel1.add(rBtnCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

        rBtnName.setBackground(new java.awt.Color(255, 255, 255));
        btnGrup_yesNo.add(rBtnName);
        rBtnName.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        rBtnName.setText("Name");
        rBtnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnNameActionPerformed(evt);
            }
        });
        panel1.add(rBtnName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 60, -1));

        lbl_accountType.setForeground(new java.awt.Color(102, 102, 102));
        lbl_accountType.setText("Main category type");
        panel1.add(lbl_accountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 110, 20));

        cmbTypes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbTypesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbTypes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTypesKeyPressed(evt);
            }
        });
        panel1.add(cmbTypes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 210, 20));

        TableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Main code", "Main name", "Main type", "Base code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableCategory.getTableHeader().setReorderingAllowed(false);
        TableCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCategory);

        panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 550, 250));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        panel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 170, -1));
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 350, -1));

        lbl_description1.setForeground(new java.awt.Color(102, 102, 102));
        lbl_description1.setText("Main category name");
        panel1.add(lbl_description1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 110, 20));

        ComboBaseCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--" }));
        ComboBaseCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComboBaseCategoryKeyPressed(evt);
            }
        });
        panel1.add(ComboBaseCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 210, -1));

        javax.swing.GroupLayout pnl_BaseLayout = new javax.swing.GroupLayout(pnl_Base);
        pnl_Base.setLayout(pnl_BaseLayout);
        pnl_BaseLayout.setHorizontalGroup(
            pnl_BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_BaseLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_BaseLayout.setVerticalGroup(
            pnl_BaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_BaseLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnl_Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnl_Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadCategories() {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            query = "SELECT * FROM MainCategory ORDER BY MainCategoryName";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {
                model_categoryTable.addRow(new Object[model_categoryTable.getColumnCount()]);
                TableCategory.setValueAt(reset.getString("MainCategoryCode"), rowCount, 0);
                TableCategory.setValueAt(reset.getString("MainCategoryName"), rowCount, 1);
                TableCategory.setValueAt(reset.getString("Type"), rowCount, 2);
                TableCategory.setValueAt(reset.getString("BaseCategoryCode"), rowCount, 3);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void Refresh() {
        RefreshTableAndLoadAgain();
        txtCode.setText("");
        txtCategoryName.setText("");
        cmbTypes.setSelectedIndex(0);
        ComboBaseCategory.setSelectedIndex(0);
        txtSearch.setText("");
    }

    private void RefreshTable() {
        try {
            int row = model_categoryTable.getRowCount();
            for (int j = 0; j < row; j++) {
                model_categoryTable.removeRow(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void RefreshTableAndLoadAgain() {
        try {
            int row = model_categoryTable.getRowCount();
            for (int j = 0; j < row; j++) {
                model_categoryTable.removeRow(0);
            }
            LoadCategories();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void loadBaseCategoriesToCombo() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * From BaseCategory order by BaseCategoryName";
            ResultSet rset = stmt.executeQuery(query);

            ComboBaseCategory.removeAllItems();
            ComboBaseCategory.insertItemAt("--Select--", 0);
            int position = 1;
            if (rset.next()) {
                do {
                    ComboBaseCategory.insertItemAt(rset.getString("BaseCategoryName") + "--" + rset.getString("BaseCategoryCode"), position); // 
                    position++;
                } while (rset.next());
            }
            ComboBaseCategory.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }
    
private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String text = txtCode.getText();
        if (!text.isEmpty()) {
            txtCategoryName.requestFocus();
//            LoadAtCodes();
        }
    }
}//GEN-LAST:event_txtCodeKeyPressed

private void txtCategoryNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryNameKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String text = txtCategoryName.getText();
        if (!text.isEmpty()) {
            cmbTypes.requestFocus();
        }
    }
}//GEN-LAST:event_txtCategoryNameKeyPressed

private void btnExitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExitKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        exit();
    }
}//GEN-LAST:event_btnExitKeyPressed

private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    exit();
}//GEN-LAST:event_btnExitActionPerformed

private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    CheckBeforeSave();

}//GEN-LAST:event_btnSaveActionPerformed

    private void CheckBeforeSave() {
        String CategoryCode = txtCode.getText();
        String CategoryName = txtCategoryName.getText();
        String Type = cmbTypes.getSelectedItem().toString();
        String CheckBaseCategory = ComboBaseCategory.getSelectedItem().toString();
        String BaseCategory[] = ComboBaseCategory.getSelectedItem().toString().split("--");
        if (!CategoryCode.isEmpty() && !CategoryName.isEmpty() && !Type.equals(select) && !CheckBaseCategory.equals(select)) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select MainCategoryCode From MainCategory where MainCategoryCode = '" + CategoryCode + "'";
                ResultSet rset = stmt.executeQuery(query);

                if (rset.next()) {
                    int x = JOptionPane.showConfirmDialog(this, "Are you sure to change the '" + CategoryCode + "' category details?", "Update Category?", JOptionPane.YES_NO_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        String UpdateQuery = "update MainCategory set MainCategoryName = '" + CategoryName + "'"
                                + ", Type = '" + Type + "', BaseCategoryCode = '" + BaseCategory[1] + "' where MainCategoryCode = '" + CategoryCode + "'";
                        stmt.execute(UpdateQuery);
                        JOptionPane.showMessageDialog(this, "Category details are updated.");
                        Refresh();
                    } else if (x == JOptionPane.NO_OPTION) {
                        txtCode.requestFocus();
                    }

                } else if (!rset.next()) {
                    String UpdateQuery = "insert into MainCategory (MainCategoryCode, MainCategoryName, Type, BaseCategoryCode) values ( '" + CategoryCode + "','" + CategoryName + "', '" + Type + "', '" + BaseCategory[1] + "') ";
                    stmt.execute(UpdateQuery);
                    JOptionPane.showMessageDialog(this, "New category is saved.");
                    Refresh();
                }
                rset.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (CategoryCode.isEmpty() || CategoryName.isEmpty() || Type.equals(select) || CheckBaseCategory.equals(select)) {
            JOptionPane.showMessageDialog(this, "Please fill all fields before save.", "Empty fields", JOptionPane.OK_OPTION);
            txtCode.requestFocus();
        }
    }

private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    CheckBeforeDelete();
}//GEN-LAST:event_btnDeleteActionPerformed

    private void CheckBeforeDelete() {
        String CategoryCode = txtCode.getText();
        if (!CategoryCode.isEmpty()) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select MainCategoryCode From SubCategory where MainCategoryCode = '" + CategoryCode + "'";
                ResultSet rset = stmt.executeQuery(query);

                if (rset.next()) {
                    JOptionPane.showMessageDialog(this, "There are some sub categories allocate to this main category. Can't delete.", "Can't delete", JOptionPane.ERROR_MESSAGE);
                } else if (!rset.next()) {
                    DeleteCategory();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (CategoryCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please insert a valid category code before delete.", "Empty category code", JOptionPane.OK_OPTION);
            txtCode.requestFocus();
        }
    }

    private void DeleteCategory() {
        String Code = txtCode.getText();
        int x = JOptionPane.showConfirmDialog(this, "Are you sure To delete this?", "Delete category?", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                java.sql.Statement Checkstmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                String Checkquery = "select MainCategoryCode From MainCategory where MainCategoryCode = '" + Code + "'";
                ResultSet Checkrset = Checkstmt.executeQuery(Checkquery);

                if (Checkrset.next()) {
                    String query = "delete From MainCategory where MainCategoryCode = '" + Code + "'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(this, "Category is deleted.");
                    Refresh();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid category code. Please insert a valid category code.", "Invalid category code", JOptionPane.OK_OPTION);
                    txtCode.requestFocus();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }

        } else if (x == JOptionPane.NO_OPTION) {
            txtCode.requestFocus();
        }
    }

    private void cmbTypesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTypesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = cmbTypes.getSelectedItem().toString();
            if (!text.equals(select)) {
                ComboBaseCategory.requestFocus();
            }
        }
    }//GEN-LAST:event_cmbTypesKeyPressed

    private void rBtnCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnCodeActionPerformed
        if (rBtnCode.isSelected()) {
            txtSearch.requestFocus();
            txtSearch.selectAll();
        }
    }//GEN-LAST:event_rBtnCodeActionPerformed

    private void rBtnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNameActionPerformed
        if (rBtnName.isSelected()) {
            txtSearch.requestFocus();
            txtSearch.selectAll();
        }
    }//GEN-LAST:event_rBtnNameActionPerformed

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {

//            for (int i = 0; i < rows; i++)
//        {
//            for (int j = 0; j < columns; j++)
//            {
//                button[i][j] = new Cell();
//                button[i][j].addActionListener( new changeButtonHandler() );
//                button[i][j].addMouseListener( new handleRight() );
//                playArea.add(button[i][j]);
//
//            }
//        }
            Refresh();
        }
    }//GEN-LAST:event_panel1MouseClicked

    private void TableCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCategoryMouseClicked
        String Code, Name, Type, BaseCode, BaseName = "";

        Code = TableCategory.getValueAt(TableCategory.getSelectedRow(), 0).toString();
        Name = TableCategory.getValueAt(TableCategory.getSelectedRow(), 1).toString();
        Type = TableCategory.getValueAt(TableCategory.getSelectedRow(), 2).toString();
        BaseCode = TableCategory.getValueAt(TableCategory.getSelectedRow(), 3).toString();

        try {
            ResultSet reset;
            Statement stmt;
            String query;
            query = "SELECT BaseCategoryName FROM BaseCategory where BaseCategoryCode = '" + BaseCode + "'";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            if (reset.next()) {
                BaseName = reset.getString("BaseCategoryName");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
        
        txtCode.setText(Code);
        txtCategoryName.setText(Name);
        cmbTypes.setSelectedItem(Type);
        ComboBaseCategory.setSelectedItem(BaseName + "--" + BaseCode);

    }//GEN-LAST:event_TableCategoryMouseClicked

    private void txtCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodeFocusGained
        txtCode.selectAll();
    }//GEN-LAST:event_txtCodeFocusGained

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (rBtnCode.isSelected()) {
            SearchCategoryByCode(txtSearch.getText());
        } else if (rBtnName.isSelected()) {
            SearchCategoryByName(txtSearch.getText());
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbTypesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbTypesPopupMenuWillBecomeInvisible
        String text = cmbTypes.getSelectedItem().toString();
        if (!text.equals(select)) {
            ComboBaseCategory.requestFocus();
        }
    }//GEN-LAST:event_cmbTypesPopupMenuWillBecomeInvisible

    private void txtCategoryNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCategoryNameFocusGained
        txtCategoryName.selectAll();
    }//GEN-LAST:event_txtCategoryNameFocusGained

    private void txtCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyReleased
        ValidateFields.CheckForCodes(txtCode);
    }//GEN-LAST:event_txtCodeKeyReleased

    private void txtCategoryNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryNameKeyReleased
        ValidateFields.CheckForOtherFields(txtCategoryName);
    }//GEN-LAST:event_txtCategoryNameKeyReleased

    private void ComboBaseCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBaseCategoryKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = ComboBaseCategory.getSelectedItem().toString();
            if (!text.equals(select)) {
                btnSave.requestFocus();
            }
        }
    }//GEN-LAST:event_ComboBaseCategoryKeyPressed

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        MainCat.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

    private void SearchCategoryByCode(String CategoryCode) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            RefreshTable();

            if (!CategoryCode.equals("")) {
                query = "SELECT * FROM MainCategory WHERE MainCategoryCode LIKE '" + CategoryCode + "%'";
            } else {
                query = "SELECT * FROM MainCategory  WHERE MainCategoryCode LIKE '" + CategoryCode + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_categoryTable.addRow(new Object[model_categoryTable.getColumnCount()]);
                TableCategory.setValueAt(reset.getString("MainCategoryCode"), rowCount, 0);
                TableCategory.setValueAt(reset.getString("MainCategoryName"), rowCount, 1);
                TableCategory.setValueAt(reset.getString("Type"), rowCount, 2);
                TableCategory.setValueAt(reset.getString("BaseCategoryCode"), rowCount, 3);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void SearchCategoryByName(String CategoryName) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            RefreshTable();

            if (!CategoryName.equals("")) {
                query = "SELECT * FROM MainCategory WHERE MainCategoryName LIKE '%" + CategoryName + "%'";
            } else {
                query = "SELECT * FROM MainCategory  WHERE MainCategoryName LIKE '%" + CategoryName + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_categoryTable.addRow(new Object[model_categoryTable.getColumnCount()]);
                TableCategory.setValueAt(reset.getString("MainCategoryCode"), rowCount, 0);
                TableCategory.setValueAt(reset.getString("MainCategoryName"), rowCount, 1);
                TableCategory.setValueAt(reset.getString("Type"), rowCount, 2);
                TableCategory.setValueAt(reset.getString("BaseCategoryCode"), rowCount, 3);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboBaseCategory;
    private javax.swing.JTable TableCategory;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGrup_yesNo;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cmbTypes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_accountType;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_description1;
    private javax.swing.JLabel lbl_subAccount;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel pnl_Base;
    private javax.swing.JRadioButton rBtnCode;
    private javax.swing.JRadioButton rBtnName;
    private javax.swing.JTextField txtCategoryName;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        
        if (MainCat != null) {
            MainCat = null;
        }
        
        this.dispose();
    }

    private void loadTypes() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select TypeCode, TypeName From ItemTypes order by TypeName";
            ResultSet rset = stmt.executeQuery(query);

            cmbTypes.removeAllItems();
            cmbTypes.insertItemAt("--Select--", 0);
            int position = 1;
            if (rset.next()) {
                do {
                    cmbTypes.insertItemAt(rset.getString("TypeName"), position); // + "--" + rset.getString("TypeCode")
                    position++;
                } while (rset.next());
            }
            cmbTypes.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", ERROR);
        }
    }
}
