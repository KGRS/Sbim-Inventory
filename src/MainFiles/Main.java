package MainFiles;

import db.ConnectSql;

/**
 *
 * @author Ravindu
 */
public class Main {

    public static String user;
    public static StringBuilder sb;
    public static boolean conn_ok;
    public static String path = "";

    public Main() {
        CheckLogger();
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            path = args[0];
        }
        conn_ok = ConnectSql.conect();

        if (!conn_ok) {
            System.exit(0);
        } else {
            Main main = new Main();
        }
    }

    private void CheckLogger() {
        path = System.getProperty("user.dir");
        LoginPage login = new LoginPage();
        login.setVisible(true);

    }

//    public static boolean isCheckModule(String userName) {
//        boolean value = false;
//        try {
//            Statement stmt = ConnectSql.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rset1 = stmt.executeQuery("SELECT * FROM tblUserRoles where UserID = '" + userName + "' AND ModuleCode = '7'");  // 
//            if (rset1.next()) {
//                String getCode = rset1.getString("ModuleCode");
//                if (getCode.equals("7")) {
//                    value = true;
//                }
////                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(null, "please contact for support.");
//        }
//        return value;
//    }
}
