/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruwan
 */
public class GenarateDate {
    public String date  =   "2011-01-01";

    public void genarateDate(String input){
        if(input.equals("yyyy-mm-dd")){
            this.date   =   "";
        }else{
            if(input.equals("")){
                this.date   =   "";
            }else{
                if(input.length() != 10){
                    if(input.length() <= 2){
                        String [] months    = {"01","02","03","04","05","06","07","08","09","10","11","12",};
                        Calendar cal        =   Calendar.getInstance();
                        int year            =   cal.get(Calendar.YEAR);
                        String month        =   months[cal.get(Calendar.MONTH)];
                        if(input.length()<2){
                            this.date  =   ""+year+"-"+month+"-0"+input.trim();
                        }else{
                            this.date  =   ""+year+"-"+month+"-"+input.trim();
                        }
                    }else if(input.length() > 2 && input.length() <= 5){
                        Calendar cal        =   Calendar.getInstance();
                        int year            =   cal.get(Calendar.YEAR);
                        String [] tdate     = input.split("-");
                        if(tdate[0].length() < 2){
                            if(tdate[1].length() < 2){
                                this.date  =   ""+year+"-0"+tdate[0]+"-0"+tdate[1];
                            }else{
                                this.date  =   ""+year+"-0"+tdate[0]+"-"+tdate[1];
                            }
                        }else{
                            if(tdate[1].length() < 2){
                                this.date  =   ""+year+"-"+tdate[0]+"-0"+tdate[1];
                            }else{
                                this.date  =   ""+year+"-"+tdate[0]+"-"+tdate[1];
                            }
                        }
                    }else if(input.length() > 5){
                        String [] tdate =   input.split("-");
                        if(tdate[0].length() < 4){
                            if(tdate[1].length() < 2){
                                if(tdate[0].length() < 2){
                                    this.date  =   "20"+tdate[0]+"-0"+tdate[1]+"-0"+tdate[2];
                                }else{
                                    this.date  =   "20"+tdate[0]+"-0"+tdate[1]+"-"+tdate[2];
                                }
                            }else{
                                if(tdate[0].length() < 2){
                                    this.date  =   "20"+tdate[0]+"-"+tdate[1]+"-0"+tdate[2];
                                }else{
                                    this.date  =   "20"+tdate[0]+"-"+tdate[1]+"-"+tdate[2];
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean validateDate(String sdate){
        SimpleDateFormat sdf    =   new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(sdate);
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }

    public boolean checkCorrectDate(String sdate){
        try {
            DateFormat df   =   new SimpleDateFormat ("yyyy-MM-dd");
            Calendar cal    =   Calendar.getInstance();
            Date d1         =   cal.getTime();
            d1              =   df.parse(df.format(d1));
            Date d2         =   df.parse(sdate);
            if(d2.before(d1)){
                return false;
            }else if(d2.after(d1)){
                return true;
            }else if(d2.equals(d1)){
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(GenarateDate.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean compareDates(String date1, String date2){
        try {
            DateFormat df   =   new SimpleDateFormat ("yyyy-MM-dd");
            Date d1         =   df.parse(date1);
            Date d2         =   df.parse(date2);
            if(d2.before(d1)){
                return false;
            }else if(d2.after(d1)){
                return true;
            }else if(d2.equals(d1)){
                return false;
            }else{
                return false;
            }
        } catch (Exception ex) {
            Logger.getLogger(GenarateDate.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String getDate(){
        return date;
    }
}
