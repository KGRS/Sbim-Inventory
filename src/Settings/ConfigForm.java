/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package Settings;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class ConfigForm extends javax.swing.JFrame {

    /**
     * Creates new form ConfigForm
     */
    public ConfigForm() {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
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

        mainPanel = new javax.swing.JPanel();
        lDBType = new javax.swing.JLabel();
        cDBType = new javax.swing.JComboBox();
        lDBIP = new javax.swing.JLabel();
        tDBIP = new javax.swing.JTextField();
        lDBName = new javax.swing.JLabel();
        tBDName = new javax.swing.JTextField();
        lUserName = new javax.swing.JLabel();
        tUserName = new javax.swing.JTextField();
        lPassword = new javax.swing.JLabel();
        tPassword = new javax.swing.JPasswordField();
        btOK = new javax.swing.JButton();
        btReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connection Settings");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDBType.setText("Database Type");
        mainPanel.add(lDBType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 120, 20));

        cDBType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MS SQL Server 2005", "MS SQL Server 2000", "MySQL" }));
        mainPanel.add(cDBType, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 190, -1));

        lDBIP.setText("Server IP");
        mainPanel.add(lDBIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 20));
        mainPanel.add(tDBIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, -1));

        lDBName.setText("Database Name");
        mainPanel.add(lDBName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 120, 20));
        mainPanel.add(tBDName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 190, -1));

        lUserName.setText("User Name");
        mainPanel.add(lUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 20));
        mainPanel.add(tUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, -1));

        lPassword.setText("Password");
        mainPanel.add(lPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 120, 20));
        mainPanel.add(tPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 190, -1));

        btOK.setText("OK");
        btOK.setMaximumSize(new java.awt.Dimension(60, 25));
        btOK.setMinimumSize(new java.awt.Dimension(60, 25));
        btOK.setPreferredSize(new java.awt.Dimension(60, 25));
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });
        mainPanel.add(btOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 80, 20));

        btReset.setText("Exit");
        btReset.setMaximumSize(new java.awt.Dimension(60, 25));
        btReset.setMinimumSize(new java.awt.Dimension(60, 25));
        btReset.setPreferredSize(new java.awt.Dimension(60, 25));
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });
        mainPanel.add(btReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        this.dispose();
    }//GEN-LAST:event_btResetActionPerformed

//    private void Refresh() {
//        cDBType.setSelectedIndex(0);
//        tDBIP.setText("");
//        tBDName.setText("");
//        tUserName.setText("");
//        tPassword.setText("");
//    }

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        String server_type = (String) cDBType.getSelectedItem();
        if (server_type.equals("MS SQL Server 2005")) {
            server_type = "SQL2005";
        } else if (server_type.equals("MS SQL Server 2000")) {
            server_type = "SQL2000";
        } else if (server_type.equals("MySQL")) {
            server_type = "MySQL";
        }
        String db_ip = tDBIP.getText();
        String db_name = tBDName.getText();
        String user_name = tUserName.getText();
        char[] t_password = tPassword.getPassword();
        String password = new String(t_password);
        if ((!server_type.equals("")) && (!db_ip.equals("")) && (!db_name.equals("")) && (!user_name.equals(""))) {
            try {
                Properties prop = new Properties();
                prop.load(new FileInputStream("Config/Config.properties"));
                prop.setProperty("db_driver", server_type);
                prop.setProperty("db_ip", db_ip);
                prop.setProperty("db_name", db_name);
                prop.setProperty("db_username", user_name);
                prop.setProperty("db_password", password);
                prop.store(new FileOutputStream("Config/Config.properties"), "Saved");
            } catch (IOException ex) {
                Logger.getLogger(ConfigForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Please restart application", "Config", JOptionPane.ERROR_MESSAGE);
            this.dispose();
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter valied details and try again", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("Config/Config.properties"));
            String driver = prop.getProperty("db_driver");
            String ip = prop.getProperty("db_ip");
            String dbName = prop.getProperty("db_name");
            String db_username = prop.getProperty("db_username");
            String db_password = prop.getProperty("db_password");

            cDBType.getSelectedItem();
            if (driver.equals("SQL2005")) {
                cDBType.setSelectedItem("MS SQL Server 2005");
            } else if (driver.equals("SQL2000")) {
                cDBType.setSelectedItem("MS SQL Server 2000");
            } else if (driver.equals("MySQL")) {
                cDBType.setSelectedItem("MySQL");
            }
            tDBIP.setText(ip);
            tBDName.setText(dbName);
            tUserName.setText(db_username);
            tPassword.setText(db_password);
        } catch (IOException ex) {
            Logger.getLogger(ConfigForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConfigForm().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOK;
    private javax.swing.JButton btReset;
    public static javax.swing.JComboBox cDBType;
    private javax.swing.JLabel lDBIP;
    private javax.swing.JLabel lDBName;
    private javax.swing.JLabel lDBType;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lUserName;
    private javax.swing.JPanel mainPanel;
    public static javax.swing.JTextField tBDName;
    public static javax.swing.JTextField tDBIP;
    public static javax.swing.JPasswordField tPassword;
    public static javax.swing.JTextField tUserName;
    // End of variables declaration//GEN-END:variables
    public static boolean edit = false;
}
