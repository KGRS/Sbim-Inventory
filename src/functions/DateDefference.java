/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is used for the purpose of to get Date defference
 *
 * @author Yasitha Charman
 */
public class DateDefference {

    private Date today;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    private SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    private long seconds;
    private long minutes;
    private long hours;
    private long days;

    /**
     * Can get date differnce between current date and given date as a parameter
     * Given date should be in this format "yyyy-MM-dd hh:mm a" a- AM or PM
     * 
     * Differnce can get as a seconds,minutes,hours or days
     * 
     * 
     * @param date
     * @throws ParseException
     * 
     */
    public void initilizeDateDifferentFromToday(String date) throws ParseException {
        today = new Date();
        Date parseDate = dateFormat.parse(date);
        long differnce = today.getTime() - parseDate.getTime();
        setSeconds(differnce / 1000);
        setMinutes(differnce / (1000 * 60));
        setHours(differnce / (1000 * 60 * 60));
        setDays(differnce / (1000 * 60 * 60 * 24));
    }
    
    public void initilizeDateDifferentFromToDates(String date1,String date2) throws ParseException{
        Date d1 = null;
        Date d2 = null;
        
        d1 = dateFormat2.parse(date1);
        d2 = dateFormat2.parse(date2);
        
        long differnce = d1.getTime() - d2.getTime();
        long days = differnce / (1000 * 60 * 60 * 24);
        
        setDays(days);
        
    }

    public static void main(String[] args) {
        String startDate = "2013-05-09 12:55:55 AM";
        String endDate = "2013-05-10 12:55:55 PM";

        Date d1 = null;
        Date d2 = null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        try {
            d1 = format.parse(startDate);
            d2 = format.parse(endDate);
        } catch (ParseException ex) {
            Logger.getLogger(DateDefference.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean after = d2.after(d1);
        if (after) {
            System.out.println("yes after");
        }


        long differnce = d2.getTime() - d1.getTime();

        long minutes = differnce / (1000 * 60);
        long hours = differnce / (1000 * 60 * 60);
        long days = differnce / (1000 * 60 * 60 * 24);

        System.out.println("difference in second : " + differnce / 1000);
        System.out.println("difference in minutes : " + minutes);
        System.out.println("difference in hours : " + hours);
        System.out.println("difference in days : " + days);

        /**
         * SELECT
         * tblAccReceiptInfor.ReceiptNo,tblAccReceiptInfor.Tour_ID,tblAccReceiptInfor.InvoiceNO,tblAccReceiptInfor.PaidAmount,
         * tblPosMaster.halfPayment as duePay,
         * tblAccPosting.tr_date,tblAccPosting.tr_time FROM tblAccReceiptInfor
         * INNER JOIN tblPOSMaster ON tblPOSMaster.InvoiceNO =
         * tblAccReceiptInfor.InvoiceNO INNER JOIN tblAccPosting ON
         * tblAccPosting.RecieptNo=tblAccReceiptInfor.ReceiptNo Where
         * tblAccReceiptInfor.Tour_ID like '12' AND tblAccPosting.DRCR like 'CR'
         */
    }

    /**
     * @return the seconds
     */
    public long getSeconds() {
        return seconds;
    }

    /**
     * @param seconds the seconds to set
     */
    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    /**
     * @return the minutes
     */
    public long getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    /**
     * @return the hours
     */
    public long getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(long hours) {
        this.hours = hours;
    }

    /**
     * @return the days
     */
    public long getDays() {
        return days;
    }

    /**
     * @param days the days to set
     */
    public void setDays(long days) {
        this.days = days;
    }
}
