package functions;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Charman
 */
public class ValidateValues {

    private static boolean checkInt(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void validateInt(JTextField txt, int length) {
        try {
            String s = txt.getText();
            while (!checkInt(s)) {
                String s1 = s.substring(0, s.length() - 1);
                s = s1;
                txt.setText(s1);
            }
            if (s.length() > length) {
                String s1 = s.substring(0, length);
                txt.setText(s1);
            }
        } catch (Exception e) {
        }
    }

    public static void validateInt(JTextField txt) {
        try {
            String s = txt.getText();
            while (!checkInt(s)) {
                String s1 = s.substring(0, s.length() - 1);
                s = s1;
                txt.setText(s1);
            }

        } catch (Exception e) {
        }
    }

    public static boolean validateEmail(String s) {
        return s.contains("@") && s.contains(".");
    }

    public static void validateTextfieldWithSize(JTextField field, int size) {
        String text = field.getText();
        int length = text.length();

        if (length > size) {
            JOptionPane.showMessageDialog(field, "<html>Maximum charcters has reached <br> on this Field");
            String s = text.substring(0, size);
            field.setText(s);

        }

    }

    /**
     *
     * @param field whose text field must check
     *
     */
    public static void checkEcapeChars(JTextField field) {
        String text_ = field.getText();
        /* if (0 < text.length()) {
         String lastChar = text.substring(text.length() - 1, text.length());
         System.out.println(lastChar);
         if (lastC) {
                
         }
         }// */

        if (text_.contains("/") || text_.contains("'") || text_.contains("\\") || text_.contains("#") || text_.contains("<") || text_.contains(">")) {
            JOptionPane.showMessageDialog(field, "<html>This Charcters are not alowed in this field  <br><b>/</b> , <b>'</b> ,<b> \\</b> ,<b> #</b> , <b><</b> , <b>></b>");
            String substring = text_.substring(0, text_.length() - 1);
            field.setText(substring);

        }

    }

    public static String checkEcapeChars(String field) {
        String text_ = field;
        /* if (0 < text.length()) {
         String lastChar = text.substring(text.length
         () - 1, text.length());
         System.out.println(lastChar);
         if (lastC) {
                
         }
         }// */

        if (text_.contains("/") || text_.contains("'")
                || text_.contains("\\") || text_.contains("#")
                || text_.contains("<") || text_.contains(">")) {
            //JOptionPane.showMessageDialog(field,"<html>This Charcters are not alowed in this field  <br><b>/</b> , <b>'</b> ,<b> \\</b> ,<b> #</b> , <b><</b> , <b>></b>");            
            String substring = text_.substring(0,text_.length() - 1);
            field = substring;

        }
        return field;

    }
}
