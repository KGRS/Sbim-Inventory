package functions;

//import errors.BarcodeExist;
import javax.swing.*;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;
//import reconciliation.Information;

/**
 *
 * @author Ravindu
 */

public class BarcodeGenerate {

    private String barcodeLocation;
    
    public void usingBarbecueAsSwingComponent(JPanel pnl, String text) {
        JPanel panel = new JPanel();
        

        // Always get a Barcode from the BarcodeFactory
        Barcode barcode = null;
        try {
            //barcode = BarcodeFactory.createCode128B("yasitha_charman");
            barcode = BarcodeFactory.createCode128A(text);

        } catch (BarcodeException e) {
            System.exit(0);
        }

        /* Because Barcode extends Component, you can use it just like any other
         * Swing component. In this case, we can add it straight into a panel
         * and it will be drawn and layed out according to the layout of the panel.
         */
        //panel.add(barcode);
        pnl.add(barcode);
    }

    public void drawingBarcodeDirectToGraphics() throws BarcodeException, OutputException {
        // Always get a Barcode from the BarcodeFactory
        Barcode barcode = BarcodeFactory.createCode128B("My Barcode");

        // We are created an image from scratch here, but for printing in Java, your
        // print renderer should have a Graphics internally anyway
        BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_BYTE_GRAY);
        // We need to cast the Graphics from the Image to a Graphics2D - this is OK
        Graphics2D g = (Graphics2D) image.getGraphics();

        // Barcode supports a direct draw method to Graphics2D that lets you position the
        // barcode on the canvas
        barcode.draw(g, 10, 56);
    }

    public void outputtingBarcodeAsPNG(String text) throws BarcodeException, BarcodeExist, OutputException {
        String projectPath = System.getProperty("user.dir");
        // get a Barcode from the BarcodeFactory
        Barcode barcode = BarcodeFactory.createCode128B(text);
        
//        File dir = new File(Information.intilzeInformation().getPROJECT_LOCATION() + "/barcode");
        File dir = new File(projectPath +  "/barcode");
        
        if (!dir.exists()) {
            dir.mkdir();
        }

        //File f = new File(projectPath  + "/barcode/" + text + ".tif");
        String location = projectPath  + "/barcode/" + text + ".png";
        this.barcodeLocation = location;
        File f = new File(location);
        boolean exists = f.exists();
        if (exists) {
            throw new BarcodeExist("barcode is already exist on this item code : " + text);
            //int x = JOptionPane.showConfirmDialog(null, "Refresh Item window?", "Refresh", JOptionPane.YES_NO_OPTION);
            
        }
        System.out.println("heloeere");

        // Let the barcode image handler do the hard work
        BarcodeImageHandler.savePNG(barcode, f);

    }

    
    public String getBarcodeLocation() {
        return barcodeLocation;
    }

    
    
    
    
}
