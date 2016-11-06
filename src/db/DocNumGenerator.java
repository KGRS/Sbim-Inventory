/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DocNumGenerator {

    public int DocNumber;
    public String DocChr,mode;
    public String DocDetails;
    public void methodNumGen(String docType){

    /*
    * tblName = name of the number generator table - currently used one table for all number generations
    * as    tblDocCodeGenerator
    * Status = 1 then get available value of PR code  * PRStatus = 2 then update ++
    * docType = PO / PR/ GRN / Event Code to search the particuler record from table..
    * DocNumber = document number from the number generator table (only digits)(ie AutoCode or ManualCode)
    * DocChr = Document start charactors
    * DocDetails = details of the document.
    * formName = currently use form Name
    *
    */
        try {
            ConnectSql.conect();
            Connection conn = ConnectSql.conn;
            java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet rset = stmt.executeQuery("Select * from tblDocCodeGenerator where DocType='"+docType+"'");

            if (!rset.next()) {
                String query    =   "Insert into tblDocCodeGenerator (AutoCode,AutoStartChr,DocType) Values ('1001','"+docType+"','"+docType+"')";
                stmt.execute(query);
                DocNumber   =   1000;
                DocChr      =   docType;
            } else {
                DocNumber   =   rset.getInt("AutoCode");
                DocChr      =   rset.getString("AutoStartChr");
                rset.updateInt("AutoCode", (DocNumber+1));
                rset.updateRow();
            }
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(DocNumGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getDocChar(){
        return DocChr;
    }

    public String getMode(){
        return mode;
    }

    public int getDocNumber(){
        return DocNumber;
    }
}
