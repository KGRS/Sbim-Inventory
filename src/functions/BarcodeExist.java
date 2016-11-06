/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;


public class BarcodeExist extends Exception {

    /**
     * Creates a new instance of <code>BarcodeExist</code> without detail message.
     */
    public BarcodeExist() {
    }

    /**
     * Constructs an instance of <code>BarcodeExist</code> with the specified detail message.
     * @param msg the detail message.
     */
    public BarcodeExist(String msg) {
        super(msg);
    }
}
