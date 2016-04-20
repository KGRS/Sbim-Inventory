/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package functions;

import MainFiles.IndexPage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Sameera
 */
public class Informations extends TimerTask{
    
     public static void setTimeAnd_date() {

         
//        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = new Date();
//        String cur_date = dateFormat.format(date);
//        IndexPage.LabelTime.setText(cur_date);
    }

    @Override
    public void run() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
         String time = format.format(new Date());
        IndexPage.LabelTime.setText(time);
    }
    
}
