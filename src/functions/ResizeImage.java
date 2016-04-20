/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import db.ConnectSql;
import MainFiles.IndexPage;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruwan
 */
public class ResizeImage {

    public static BufferedImage resize() {
        try {
            Statement stmt = ConnectSql.conn.createStatement();
            ResultSet rset = stmt.executeQuery("Select * from tblSettings");
            if (rset.next()) {
                BufferedImage originalImage = ImageIO.read(new File(rset.getString("BackG_image")));
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                int screenWidth = (int) dim.getWidth();
                int screenHeight = (int) dim.getHeight();

                int w = originalImage.getWidth();
                int h = originalImage.getHeight();
                BufferedImage dimg = dimg = new BufferedImage(screenWidth, screenHeight, originalImage.getType());
                Graphics2D g = dimg.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(originalImage, 0, 0, screenWidth, screenHeight, 0, 0, w, h, null);
                g.dispose();

                rset.close();
                return dimg;
            } else {
                BufferedImage originalImage = ImageIO.read(IndexPage.url);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                int screenWidth = (int) dim.getWidth();
                int screenHeight = (int) dim.getHeight();

                int w = originalImage.getWidth();
                int h = originalImage.getHeight();
                BufferedImage dimg = dimg = new BufferedImage(screenWidth, screenHeight, originalImage.getType());
                Graphics2D g = dimg.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(originalImage, 0, 0, screenWidth, screenHeight, 0, 0, w, h, null);
                g.dispose();

                rset.close();
                return dimg;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "SQL");
            return null;
        } catch (IOException ex) {
            try {
                BufferedImage originalImage = ImageIO.read(IndexPage.url);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                int screenWidth = (int) dim.getWidth();
                int screenHeight = (int) dim.getHeight();
                int w = originalImage.getWidth();
                int h = originalImage.getHeight();
                BufferedImage dimg = dimg = new BufferedImage(screenWidth, screenHeight, originalImage.getType());
                Graphics2D g = dimg.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(originalImage, 0, 0, screenWidth, screenHeight, 0, 0, w, h, null);
                g.dispose();
                return dimg;
            } catch (Exception e) {
                Logger.getLogger(ResizeImage.class.getName()).log(Level.SEVERE, null, e);
                return null;
            }
        }
    }
}
