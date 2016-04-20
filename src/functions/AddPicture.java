/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


public class AddPicture {

    public String AddPictures(String FolderName, javax.swing.JButton btn, String Itemcode) {
        String PathToImage = "";
        JFileChooser fChooser = new JFileChooser();
        int option = fChooser.showOpenDialog(null);
        if (option == JFileChooser.OPEN_DIALOG) {

            File file = fChooser.getSelectedFile();
            File direc = new File("pictures\\" + FolderName);
            boolean m = false;
            boolean e = direc.exists();
            if (!e) {
                m = direc.mkdir();
            }
//            File dest = new File(direc.getAbsolutePath() + "\\" + file.getName());
            File dest = new File(direc.getAbsolutePath() + "\\" + Itemcode + ".jpg");
            if (dest.exists()) {
                dest.delete();
            }
            if (m || e) {
                try {
                    FileChannel fchi = new FileInputStream(file).getChannel();
                    FileChannel fcho = new FileOutputStream(dest).getChannel();
                    fchi.transferTo(0, fchi.size(), fcho);
                    fchi.close();
                    fcho.close();
                } catch (IOException ex) {
                    Logger.getLogger(AddPicture.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            PathToImage ="pictures\\" + FolderName + "\\" + file.getName();
            PathToImage ="pictures\\" + FolderName + "\\" + Itemcode + ".jpg";
            Image img = Toolkit.getDefaultToolkit().getImage(PathToImage);
            btn.setIcon(new ImageIcon(img));
        }
        return PathToImage;
    }
}
