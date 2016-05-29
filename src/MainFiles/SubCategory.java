/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SubCategory.java
 *
 * Created on Apr 5, 2016, 3:51:44 PM
 */
package MainFiles;

import static MainFiles.IndexPage.SubCat;
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
public class SubCategory extends javax.swing.JInternalFrame {

    private final DefaultTableModel model_SubCategoryTable;
    private final String select = "--Select--";
    private final String spliter = "--";

    /**
     * Creates new form SubCategory
     */
    public SubCategory() {
        initComponents();
        rBtnCode.setSelected(true);
        txt_SubCategoryCode.requestFocus();
        model_SubCategoryTable = (DefaultTableModel) TableSubCategory.getModel();
        loadCategoriesToCombo();
        LoadSubCategories();
        panel1.setToolTipText("Press right mouse click to refresh.");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_SubCategoryCode = new javax.swing.JTextField();
        txtSubCategoryName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cmbMainCategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableSubCategory = new javax.swing.JTable();
        txtType = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        rBtnCode = new javax.swing.JRadioButton();
        rBtnName = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextBaseCode = new javax.swing.JTextField();

        setIconifiable(true);
        setTitle("Sub Category");
        setToolTipText("This");
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
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        panel1.setForeground(new java.awt.Color(255, 255, 255));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Base Category Code");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 114, 20));

        txt_SubCategoryCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SubCategoryCodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SubCategoryCodeKeyReleased(evt);
            }
        });
        panel1.add(txt_SubCategoryCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 190, -1));

        txtSubCategoryName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSubCategoryNameKeyPressed(evt);
            }
        });
        panel1.add(txtSubCategoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 310, -1));

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
        panel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 290, 80, -1));

        btnExit.setMnemonic('e');
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        panel1.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 80, -1));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        btnDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDeleteKeyPressed(evt);
            }
        });
        panel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 290, 80, -1));

        cmbMainCategory.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbMainCategoryPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbMainCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMainCategoryKeyPressed(evt);
            }
        });
        panel1.add(cmbMainCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 310, 20));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Sub Category Name");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 114, 20));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Main Category");
        panel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 114, 20));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Search sub category by");
        panel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 20));

        TableSubCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sub code", "Sub Name", "Sub Type", "Main Code"
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
        TableSubCategory.getTableHeader().setReorderingAllowed(false);
        TableSubCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableSubCategoryMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableSubCategory);

        panel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 540, 250));

        txtType.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtType.setEnabled(false);
        panel1.add(txtType, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 180, 190, -1));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Type");
        panel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 70, 20));

        rBtnCode.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnCode);
        rBtnCode.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        rBtnCode.setText("Code");
        rBtnCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnCodeActionPerformed(evt);
            }
        });
        rBtnCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rBtnCodeKeyPressed(evt);
            }
        });
        panel1.add(rBtnCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, -1));

        rBtnName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rBtnName);
        rBtnName.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        rBtnName.setText("Name");
        rBtnName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rBtnNameKeyPressed(evt);
            }
        });
        panel1.add(rBtnName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 60, -1));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        panel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 170, -1));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Sub Category Code");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 114, 20));

        TextBaseCode.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TextBaseCode.setEnabled(false);
        panel1.add(TextBaseCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadCategoriesToCombo() {
        try {
            java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "select * From MainCategory order by MainCategoryName";
            ResultSet rset = stmt.executeQuery(query);

            cmbMainCategory.removeAllItems();
            cmbMainCategory.insertItemAt("--Select--", 0);
            int position = 1;
            if (rset.next()) {
                do {
                    cmbMainCategory.insertItemAt(rset.getString("MainCategoryName") + "--" + rset.getString("MainCategoryCode"), position); // 
                    position++;
                } while (rset.next());
            }
            cmbMainCategory.setSelectedIndex(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void LoadSubCategories() {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            query = "SELECT * FROM SubCategory ORDER BY SubCategoryName";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {
                model_SubCategoryTable.addRow(new Object[model_SubCategoryTable.getColumnCount()]);
                TableSubCategory.setValueAt(reset.getString("SubCategoryCode"), rowCount, 0);
                TableSubCategory.setValueAt(reset.getString("SubCategoryName"), rowCount, 1);
                TableSubCategory.setValueAt(reset.getString("Type"), rowCount, 2);
                TableSubCategory.setValueAt(reset.getString("MainCategoryCode"), rowCount, 3);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

private void txt_SubCategoryCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SubCategoryCodeKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String text = txt_SubCategoryCode.getText();
        if (!text.isEmpty()) {
            txtSubCategoryName.requestFocus();
        }

    }
}//GEN-LAST:event_txt_SubCategoryCodeKeyPressed

private void txtSubCategoryNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSubCategoryNameKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        cmbMainCategory.requestFocus();
    }
}//GEN-LAST:event_txtSubCategoryNameKeyPressed

private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        CheckBeforeSave();
    }
}//GEN-LAST:event_btnSaveKeyPressed

private void btnDeleteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDeleteKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        CheckBeforeDelete();
    }
}//GEN-LAST:event_btnDeleteKeyPressed

private void cmbMainCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMainCategoryKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        LoadMainCategoryDetails();
    }
}//GEN-LAST:event_cmbMainCategoryKeyPressed

    private void LoadMainCategoryDetails() {
        String MainCategoryCode[] = cmbMainCategory.getSelectedItem().toString().split("--");
        if (cmbMainCategory.getSelectedItem().equals(select)) {
            txtType.setText("");
        } else {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select Type, BaseCategoryCode From MainCategory where MainCategoryCode = '" + MainCategoryCode[1] + "'";
                ResultSet rset = stmt.executeQuery(query);

                if (rset.next()) {
                    String Type = rset.getString("Type");
                    String BaseCategoryCode = rset.getString("BaseCategoryCode");
                    txtType.setText(String.valueOf(Type));
                    TextBaseCode.setText(String.valueOf(BaseCategoryCode));
                    btnSave.requestFocus();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        }
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

        exit();

    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        CheckBeforeSave();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CheckBeforeSave() {
        String CategoryCode = txt_SubCategoryCode.getText();
        String CategoryName = txtSubCategoryName.getText();
        String MainCategoryCode[] = cmbMainCategory.getSelectedItem().toString().split("--");
        String Type = txtType.getText();
        String BaseCategoryCode = TextBaseCode.getText();
        if (!CategoryCode.isEmpty() && !CategoryName.isEmpty() && !Type.isEmpty()) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select SubCategoryCode From SubCategory where SubCategoryCode = '" + CategoryCode + "'";
                ResultSet rset = stmt.executeQuery(query);

                if (rset.next()) {
                    int x = JOptionPane.showConfirmDialog(this, "Are you sure to change the '" + CategoryCode + "' sub category details?", "Update sub category?", JOptionPane.YES_NO_OPTION);
                    if (x == JOptionPane.YES_OPTION) {
                        String UpdateQuery = "update SubCategory set SubCategoryName = '" + CategoryName + "'"
                                + ", MainCategoryCode = '" + MainCategoryCode[1] + "', Type = '" + Type + "'"
                                + ", BaseCategoryCode = '" + BaseCategoryCode + "' where SubCategoryCode = '" + CategoryCode + "'";
                        stmt.execute(UpdateQuery);
                        JOptionPane.showMessageDialog(this, "Sub category details are updated.");
                        Refresh();
                    } else if (x == JOptionPane.NO_OPTION) {
                        txt_SubCategoryCode.requestFocus();
                    }

                } else if (!rset.next()) {
                    String UpdateQuery = "insert into SubCategory (SubCategoryCode, SubCategoryName"
                            + ", MainCategoryCode, Type, BaseCategoryCode) values ( '" + CategoryCode + "'"
                            + ",'" + CategoryName + "', '" + MainCategoryCode[1] + "', '" + Type + "'"
                            + ", '" + BaseCategoryCode + "') ";
                    stmt.execute(UpdateQuery);
                    JOptionPane.showMessageDialog(this, "New sub category is saved.");
                    Refresh();
                }
                rset.close();
            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (CategoryCode.isEmpty() || CategoryName.isEmpty() || Type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields before save.", "Empty fields", JOptionPane.OK_OPTION);
            txt_SubCategoryCode.requestFocus();
        }
    }

    private void rBtnCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnCodeActionPerformed
        //  SubAccountCategory sub = new SubAccountCategory(null, true);
        //  sub.setLocationRelativeTo(null);
        //  sub.setVisible(true);
    }//GEN-LAST:event_rBtnCodeActionPerformed

    private void rBtnCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rBtnCodeKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            rBtnName.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rBtnCode.setSelected(true);
            //        SubAccountCategory sub = new SubAccountCategory(null, true);
            //        sub.setLocationRelativeTo(null);
            //        sub.setVisible(true);
            btnSave.requestFocus();

        }
    }//GEN-LAST:event_rBtnCodeKeyPressed

    private void rBtnNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rBtnNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            rBtnCode.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            rBtnName.setSelected(true);
            btnSave.requestFocus();
        }
    }//GEN-LAST:event_rBtnNameKeyPressed

    private void txt_SubCategoryCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SubCategoryCodeKeyReleased
        ValidateFields.CheckForCodes(txt_SubCategoryCode);
    }//GEN-LAST:event_txt_SubCategoryCodeKeyReleased

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (rBtnCode.isSelected()) {
            SearchSubCategoryByCode(txtSearch.getText());
        } else if (rBtnName.isSelected()) {
            SearchSubCategoryByName(txtSearch.getText());
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void TableSubCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableSubCategoryMouseClicked
        String Code, Name, Type, MainCode, MainName = "", BaseCode = "";

        Code = TableSubCategory.getValueAt(TableSubCategory.getSelectedRow(), 0).toString();
        Name = TableSubCategory.getValueAt(TableSubCategory.getSelectedRow(), 1).toString();
        Type = TableSubCategory.getValueAt(TableSubCategory.getSelectedRow(), 2).toString();
        MainCode = TableSubCategory.getValueAt(TableSubCategory.getSelectedRow(), 3).toString();

        try {
            ResultSet reset;
            Statement stmt;
            String query;
            query = "SELECT * FROM MainCategory where MainCategoryCode = '" + MainCode + "'";
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            if (reset.next()) {
                MainName = reset.getString("MainCategoryName");
                BaseCode = reset.getString("BaseCategoryCode");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }

        txt_SubCategoryCode.setText(Code);
        txtSubCategoryName.setText(Name);
        cmbMainCategory.setSelectedItem(MainName + "--" + MainCode);
        txtType.setText(Type);
        TextBaseCode.setText(BaseCode);
    }//GEN-LAST:event_TableSubCategoryMouseClicked

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) || evt.isControlDown()) {
            Refresh();
        }
    }//GEN-LAST:event_panel1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        CheckBeforeDelete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cmbMainCategoryPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbMainCategoryPopupMenuWillBecomeInvisible
        LoadMainCategoryDetails();
    }//GEN-LAST:event_cmbMainCategoryPopupMenuWillBecomeInvisible

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        SubCat.toFront();
    }//GEN-LAST:event_formInternalFrameIconified

    private void CheckBeforeDelete() {
        String CategoryCode = txt_SubCategoryCode.getText();
        if (!CategoryCode.isEmpty()) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String query = "select MainCategoryCode From SubCategory where MainCategoryCode = '" + CategoryCode + "'";
                ResultSet rset = stmt.executeQuery(query);

                if (rset.next()) {
                    JOptionPane.showMessageDialog(this, "There are some items allocate to this sub category. Can't delete.", "Can't delete", JOptionPane.ERROR_MESSAGE);
                } else if (!rset.next()) {
                    DeleteCategory();
                }

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }
        } else if (CategoryCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please insert a valid sub category code before delete.", "Empty sub category code", JOptionPane.OK_OPTION);
            txt_SubCategoryCode.requestFocus();
        }
    }

    private void DeleteCategory() {
        String Code = txt_SubCategoryCode.getText();
        int x = JOptionPane.showConfirmDialog(this, "Are you sure To delete this?", "Delete sub category?", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            try {
                java.sql.Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                java.sql.Statement Checkstmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

                String Checkquery = "select SubCategoryCode From SubCategory where SubCategoryCode = '" + Code + "'";
                ResultSet Checkrset = Checkstmt.executeQuery(Checkquery);

                if (Checkrset.next()) {
                    String query = "delete From SubCategory where SubCategoryCode = '" + Code + "'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(this, "Sub category is deleted.");
                    Refresh();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid sub category code. Please insert a valid sub category code.", "Invalid sub category code", JOptionPane.OK_OPTION);
                    txt_SubCategoryCode.requestFocus();
                }

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "Please contact for support.");
            }

        } else if (x == JOptionPane.NO_OPTION) {
            txt_SubCategoryCode.requestFocus();
        }
    }

    private void Refresh() {
        RefreshTableAndLoadAgain();
        txt_SubCategoryCode.setText("");
        txtSubCategoryName.setText("");
        cmbMainCategory.setSelectedIndex(0);
        txtType.setText("");
        txtSearch.setText("");
        TextBaseCode.setText("");
    }

    private void RefreshTableAndLoadAgain() {
        try {
            int row = model_SubCategoryTable.getRowCount();
            for (int j = 0; j < row; j++) {
                model_SubCategoryTable.removeRow(0);
            }
            LoadSubCategories();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void SearchSubCategoryByCode(String CategoryCode) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            RefreshTable();

            if (!CategoryCode.equals("")) {
                query = "SELECT * FROM SubCategory WHERE SubCategoryCode LIKE '" + CategoryCode + "%'";
            } else {
                query = "SELECT * FROM SubCategory  WHERE SubCategoryCode LIKE '" + CategoryCode + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_SubCategoryTable.addRow(new Object[model_SubCategoryTable.getColumnCount()]);
                TableSubCategory.setValueAt(reset.getString("SubCategoryCode"), rowCount, 0);
                TableSubCategory.setValueAt(reset.getString("SubCategoryName"), rowCount, 1);
                TableSubCategory.setValueAt(reset.getString("Type"), rowCount, 2);
                TableSubCategory.setValueAt(reset.getString("MainCategoryCode"), rowCount, 3);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void SearchSubCategoryByName(String CategoryName) {
        try {
            ResultSet reset;
            Statement stmt;
            String query;
            int rowCount = 0;
            RefreshTable();

            if (!CategoryName.equals("")) {
                query = "SELECT * FROM SubCategory WHERE SubCategoryName LIKE '%" + CategoryName + "%'";
            } else {
                query = "SELECT * FROM SubCategory  WHERE SubCategoryName LIKE '%" + CategoryName + "%'";
            }
            stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            reset = stmt.executeQuery(query);

            while (reset.next()) {

                model_SubCategoryTable.addRow(new Object[model_SubCategoryTable.getColumnCount()]);
                TableSubCategory.setValueAt(reset.getString("SubCategoryCode"), rowCount, 0);
                TableSubCategory.setValueAt(reset.getString("SubCategoryName"), rowCount, 1);
                TableSubCategory.setValueAt(reset.getString("Type"), rowCount, 2);
                TableSubCategory.setValueAt(reset.getString("MainCategoryCode"), rowCount, 3);
                rowCount++;
            }
            reset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(this, "Please contact for support.");
        }
    }

    private void RefreshTable() {
        try {
            int row = model_SubCategoryTable.getRowCount();
            for (int j = 0; j < row; j++) {
                model_SubCategoryTable.removeRow(0);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableSubCategory;
    private javax.swing.JTextField TextBaseCode;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbMainCategory;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel1;
    private javax.swing.JRadioButton rBtnCode;
    private javax.swing.JRadioButton rBtnName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSubCategoryName;
    private javax.swing.JTextField txtType;
    private javax.swing.JTextField txt_SubCategoryCode;
    // End of variables declaration//GEN-END:variables

    private void exit() {
        
        if (SubCat != null) {
            SubCat = null;
        }
        
        this.dispose();
    }
}
