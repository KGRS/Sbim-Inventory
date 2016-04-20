/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruwan
 */
public class GetRealPrinters {

    public ArrayList getPrinters(ArrayList duplicated) {
        ArrayList printers = new ArrayList();
        try {
            Iterator iterator = duplicated.iterator();
            while (iterator.hasNext()) {
                String printer = (String) iterator.next();
                Iterator ite = printers.iterator();
                if (printers.size() > 0) {
                    while (ite.hasNext()) {
                        String exist = (String) ite.next();
                        if (exist.equals(printer)) {
                            printer = "";
                            break;
                        }
                    }
                }
                if (printer != null) {
                    if (!printer.equals("") && !printer.equals("0")) {
                        printers.add(printer);
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(GetRealPrinters.class.getName()).log(Level.SEVERE, null, ex);
        }
        return printers;
    }
}
