/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import MainFiles.Main;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ReadConfig {

    public static String db_driver;
    public static String db_url;
    public static String db_username;
    public static String db_password;
        
    public static String EnableSellPricePresentage;    
    public static String BarCodeImageType;    
    public static String UpdateSellPriceAtGRN;
    public static String branch;
    public static String department;
    
//    public static String invoice_data_from_tblPosMaster;
//    public static String should_receipt_form_viewed;
//    public static String application_location_code;
//    public static String cheque_printer_name;
//    public static String should_view_printPreview;
//    public static String should_print_automatically;   
//    public static String reconcilation_account_type ;   
//    public static String reconcilation_sc_code ;    
    public static String Date;
//    public static String themeColour;
   
    
    static {
        try {
            Properties prop     = new Properties();
            prop.load(new FileInputStream(Main.path+"Config\\Config.properties"));

            String driver       = prop.getProperty("db_driver");
            String ip           = prop.getProperty("db_ip");
            String dbName       = prop.getProperty("db_name");
            db_username         = prop.getProperty("db_username");
            db_password         = prop.getProperty("db_password");
            
            if (db_password.equals("")) {
                db_password = "RavSam$#@!";
            }
            
            //------------------------------------------------------------------
            EnableSellPricePresentage      = prop.getProperty("EnableSellPricePresentage");            
            BarCodeImageType      = prop.getProperty("BarCodeImageType");
            UpdateSellPriceAtGRN =  prop.getProperty("UpdateSellPriceAtGRN");
            branch =  prop.getProperty("Branch");
            department =  prop.getProperty("Departments");
            
//            invoice_data_from_tblPosMaster      = prop.getProperty("invoice_data_from_tblPosMaster");
//            should_receipt_form_viewed      = prop.getProperty("should_receipt_form_viewed");
//            application_location_code      = prop.getProperty("application_location_code");
//            cheque_printer_name      = prop.getProperty("cheque_printer_name");
//            should_view_printPreview      = prop.getProperty("should_view_printPreview");
//            should_print_automatically      = prop.getProperty("should_print_automatically");
//            reconcilation_account_type      = prop.getProperty("reconcilation_account_type");
//            reconcilation_sc_code      = prop.getProperty("reconcilation_sc_code");
            

            if(driver.equals("SQL2000")){
                db_driver   =   "com.microsoft.jdbc.sqlserver.SQLServerDriver";
                db_url      =   "jdbc:microsoft:sqlserver://"+ip+":1433;DatabaseName="+dbName;
            }else if(driver.equals("SQL2005")){
                db_driver   =   "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                db_url      =   "jdbc:sqlserver://"+ip+":1433;databaseName="+dbName;
            }else if(driver.equals("MySQL")){
                db_driver   =   "com.mysql.jdbc.Driver";
                db_url      =   "jdbc:mysql://"+ip+":3306/"+dbName;
            }
            
            Date = prop.getProperty("DateType");
//            themeColour = prop.getProperty("ThemeColour");
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Can't read cofig files");
            Logger.getLogger(ReadConfig.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
}
