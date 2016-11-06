/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class EnhanceBarCode {

    /**
     * Full path of the image.
     */
    private String barcodeLocation;

    /**
     * Barcode will be stored as an image.
     */
    private BufferedImage barcodeImage;

    /**
     * Location of the finished image will be stored in here.
     */
    private String finalImageLocation;

    /**
     * Name of the final image.
     */
    private String finalImageName;

    /* Default Constructor */
    public EnhanceBarCode() {

    }

    /**
     * By using this method given text will be added to barcode image.
     *
     * @param textToAdd Text to be added to the barcode
     * @param barcodeImage given text will be added to this image
     */
    public void enhanceBarcode(String textToAdd, BufferedImage barcodeImage) throws IOException {
        this.barcodeImage = barcodeImage;
        int height = this.barcodeImage.getHeight();
        int width = this.barcodeImage.getWidth();

        if (barcodeImage == null) {
            System.err.println("Barcode could not locate");
            return;
        }

        BufferedImage textImage = createTextImage(width, height, textToAdd);
        BufferedImage mergeImage = mergeImage(barcodeImage, textImage);

        // Sorting out the image name
        if (finalImageName == null || finalImageName.trim().isEmpty()) {
            finalImageName = "FinalImage.png";
        }

        // Sorting out the image location
        if (finalImageLocation == null || finalImageLocation.trim().isEmpty()) {
            finalImageLocation = "";
        }

        System.out.println("About to cerate the File");
        ImageIO.write(mergeImage, "png", new File(finalImageLocation + finalImageName));
        System.out.println("File has created");

    }
    
      /**
     * By using this method given text will be added to barcode image.
     *
     * @param textToAdd Text to be added to the barcode
     * @param barcodeLocation this contains the barcode image location
     *  provide full path including the name of the file.
     *  ex : "/desktop/document/image.png"
     */
    public void enhanceBarcode(String textToAdd, String barcodeLocation) throws IOException {
        
        BufferedImage barcode = null;
        try {
            barcode = ImageIO.read(new File(barcodeLocation));
        } catch (IOException ex) {            
            ex.printStackTrace();
            return;            
        }        
        this.barcodeImage = barcode;
        
        if(this.barcodeImage == null){
            System.err.println("Barcode path cannot specified");
        }
        
        int height = this.barcodeImage.getHeight();
        int width = this.barcodeImage.getWidth();

        if (barcodeImage == null) {
            System.err.println("Barcode could not located");
            return;
        }

        BufferedImage textImage = createTextImage(width, height, textToAdd);
        BufferedImage mergeImage = mergeImage(barcodeImage, textImage);

        // Sorting out the image name
        if (finalImageName == null || finalImageName.trim().isEmpty()) {
            finalImageName = "FinalImage.png";
        }

        // Sorting out the image location
        if (finalImageLocation == null || finalImageLocation.trim().isEmpty()) {
            finalImageLocation = "";
        }
        
        if(!barcodeLocation.isEmpty()){
            finalImageName = "";
        }

        System.out.println("About to cerate the File");
        ImageIO.write(mergeImage, "png", new File(finalImageLocation + finalImageName));
        System.out.println("File has created");

    }

    /**
     * This method will be used to produce a text as a image
     *
     * @param width width of the creating image
     * @param height height of the creating image
     * @param textToAdd by this text image will be produced
     * @return
     */
    private BufferedImage createTextImage(int width, int height, String textToAdd) {
        BufferedImage textImage = null;
        textImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = textImage.createGraphics();

        // Setting up the Font
        Font f = new Font("Arial", Font.BOLD, 16);
        //g.setFont(g.getFont().deriveFont(10F));
        graphics.setFont(f);
        graphics.setColor(Color.BLACK);

        if (textToAdd == null || textToAdd.trim().isEmpty()) {
            textToAdd = "Default Text";
        }

        // At Font size 14 widest letter is take 9.6px lets drop the 0.6
        // Maximum Charcters 32
        int x_cordinate = (width - textToAdd.trim().length() * 9) / 2;
        graphics.drawString(textToAdd, x_cordinate, height-4);
        graphics.dispose();

        return textImage;
    }

    /**
     * This method will be used to merge barcode image and text image are given
     * as parameters
     *
     * @param barcodeImage barcode image
     * @param textImage text image
     * @return
     */
    private BufferedImage mergeImage(BufferedImage barcodeImage, BufferedImage textImage) {
        int rows = 2;
        int cols = 1;
        int chunks = rows * cols;
        int chunkWidth;
        int chunkHeight;
        int imageType;

        BufferedImage[] buffImage = new BufferedImage[chunks];
        buffImage[0] = textImage;
        buffImage[1] = barcodeImage;

        imageType = buffImage[0].getType();
        chunkWidth = buffImage[0].getWidth();
        chunkHeight = buffImage[0].getHeight();

        // Initializing the final image
        BufferedImage finalImage = new BufferedImage(chunkWidth * cols, chunkHeight * rows, BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = finalImage.createGraphics();

        int num = 0;
        for (int i = 0; i < rows; i++) { // Counting rows
            for (int j = 0; j < cols; j++) { // Counting columns
                graphics.drawImage(buffImage[num], chunkWidth * j, chunkHeight * i, null);
                System.out.println(" [ Width : " + (chunkWidth * j) + "]  [Height : " + (chunkHeight * i) + "]");
                num++;
            } // End of cols
        }// End of rows

        System.out.println("Image Concatenated...!!");

        return finalImage;
    }

    public static void main(String[] args) throws IOException {

        EnhanceBarCode en = new EnhanceBarCode();
        //BufferedImage createTextImage = en.createTextImage(200, 48, "7878");

        BufferedImage barcode = null;
//        try {
//            barcode = ImageIO.read(new File("mybarcode.png"));
//        } catch (IOException ex) {
//            Logger.getLogger(DrawText2Image.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        en.enhanceBarcode("Rs 100.00 ", "mybarcode.png");
        

    }   

    /**
     * @param barcodeLocation the barcodeLocation to set
     */
    public void setBarcodeLocation(String barcodeLocation) {
        this.barcodeLocation = barcodeLocation;
    }   

    /**
     * @param barcodeImage the barcodeImage to set
     */
    public void setBarcodeImage(BufferedImage barcodeImage) {
        this.barcodeImage = barcodeImage;
    }
    
    /**
     * @param finalImageLocation the finalImageLocation to set
     */
    public void setFinalImageLocation(String finalImageLocation) {
        this.finalImageLocation = finalImageLocation;
    }   

    /**
     * @param finalImageName the finalImageName to set
     */
    public void setFinalImageName(String finalImageName) {
        this.finalImageName = finalImageName;
    }
    
    
    

}
