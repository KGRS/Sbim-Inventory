/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import MainFiles.IndexPage;
import MainFiles.LoginPage;
import MainFiles.IndexPage;
import db.ConnectSql;
//import PMS.IndexPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruwan
 */
public class EnableFeatuers {

    public void enableFeatuers() {
        try {
            Statement stmt = ConnectSql.conn.createStatement();
            ResultSet rset = stmt.executeQuery("Select * from tblUserRoles where UserID = '" + IndexPage.user + "' AND ModuleCode='7'");
            String roles = "";
            if (rset.next()) {
                roles = rset.getString("UserRoles");
            }
            //roles=this.getUserRoles(roles);
            String[] a_roles = roles.split(",");
            ArrayList main = new ArrayList();
            ArrayList sub1 = new ArrayList();
            ArrayList sub2 = new ArrayList();
            ArrayList sub3 = new ArrayList();
            ArrayList sub4 = new ArrayList();
            ArrayList sub5 = new ArrayList();
            ArrayList sub31=new ArrayList();
            for (int i = 0; i < a_roles.length; i++) {
                if (a_roles[i].length() == 1) {
                    main.add(a_roles[i]);
                } else if (a_roles[i].length() == 2 || a_roles[i].length() == 3) {
                    if (a_roles[i].startsWith("1")) {
                        sub1.add(a_roles[i]);
                    } else if (a_roles[i].startsWith("2")) {
                        sub2.add(a_roles[i]);
                    } else if (a_roles[i].startsWith("3")) {
                        sub3.add(a_roles[i]);
                        if (a_roles[i].startsWith("36")) {
                            sub31.add(a_roles[i]);
                        }
                    } else if (a_roles[i].startsWith("4")) {
                        sub4.add(a_roles[i]);
                    } else if (a_roles[i].startsWith("5")) {
                        sub5.add(a_roles[i]);
                    }
                }
            }
            Collections.sort(main);
            Collections.sort(sub1);
            Collections.sort(sub2);
            Collections.sort(sub3);
            Collections.sort(sub4);
            Collections.sort(sub5);

            Iterator ite = main.iterator();
            while (ite.hasNext()) {
                int value = Integer.parseInt(((String) ite.next()));
                switch (value) {
                    case 1: {
                        IndexPage.TabMenuMainFiles.setEnabled(true);
                        Iterator ite_s = sub1.iterator();
                        while (ite_s.hasNext()) {
                            int value_s = Integer.parseInt(((String) ite_s.next()).substring(1));
                            switch (value_s) {
                                case 1: {
                                    IndexPage.MenuMainCategory.setEnabled(true);
                                    break;
                                }
                                case 2: {
                                    IndexPage.MenuSubCategory.setEnabled(true);
                                    break;
                                }
                                case 3: {
                                    IndexPage.MenuSupplier.setEnabled(true);
                                    break;
                                }
                                case 4: {
                                    IndexPage.MenuCustomer.setEnabled(true);
                                    break;
                                }
                                case 5: {
                                    IndexPage.MenuItem.setEnabled(true);
                                    break;
                                }
                                
                            }
                        }
                        break;
                    }
                    case 2: {
                        IndexPage.TabMenuTransactions.setEnabled(true);
                        Iterator ite_s = sub2.iterator();
                        while (ite_s.hasNext()) {
                            int value_s = Integer.parseInt(((String) ite_s.next()).substring(1));
                            switch (value_s) {
                                case 1: {
                                    IndexPage.MenuPurchaseOrders.setEnabled(true);
                                    break;
                                }
                                case 2: {
                                    IndexPage.MenuGRNItemCodeWise.setEnabled(true);
                                    break;
                                }
                                case 3: {
                                    IndexPage.MenuReturnToSupplier.setEnabled(true);
                                    break;
                                }                               
                            }
                        }
                        break;
                    }
                    case 3: {
                        IndexPage.TabMenuReports.setEnabled(true);
                        Iterator ite_s = sub3.iterator();
                        while (ite_s.hasNext()) {
                            int value_s = Integer.parseInt(((String) ite_s.next()).substring(1));
                            switch (value_s) {
                                case 1: {
                                    IndexPage.MenuDataReports.setEnabled(true);
                                    break;
                                }
                                

                            }
                        }
                        break;
                    }



                    case 4: {
                        IndexPage.TabMenuTools.setEnabled(true);
                        Iterator ite_s = sub4.iterator();
                        while (ite_s.hasNext()) {
                            int value_s = Integer.parseInt(((String) ite_s.next()).substring(1));
                            switch (value_s) {
                                case 1: {
                                    IndexPage.MenuPersonalization.setEnabled(true);
                                    break;
                                }

                            }
                        }
                        break;
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnableFeatuers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getUserRoles(String roles) {
        String arr[] = roles.split(",");
        String foRoles = "";
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith("I")) {
                if (a == 0) {
                    foRoles = arr[i].substring(1);
                    a++;
                } else {
                    foRoles = foRoles + "," + arr[i].substring(1);
                    a++;
                }
            }
        }
        return foRoles;
    }
}
