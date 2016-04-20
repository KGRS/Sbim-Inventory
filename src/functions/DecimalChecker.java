package functions;

import java.math.BigDecimal;

public class DecimalChecker {

    public static void main(String args[]) {


//        String s = new DecimalChecker().checkDecimal("123.5a6");
//
//        System.out.println("------------------------------");
//        System.out.println("123.5a6");
//        System.out.println("After procedure : " + s);
//
//        System.out.println("------------------------------");
//        String d = DecimalChecker.decimalchecker("45", 2);
//
//        System.out.println("D : "+d);
        String d = DecimalChecker.decimalchecker("-10.234", 2);

        System.out.println("D : " + d);
        //        String t = new DecimalChecker().decimalchecker("12.311", 2);
        //        System.out.println("Before format : 12.35689");
        //        System.out.println("After format  : "+t);
        String dt = DecimalChecker.roundtoNearestDecimalPoint(23, 2);
        System.out.println(dt);


    }

    public static String checkDecimal(String numberForCheck) {


        String text = "";
        String number = "";

        if (numberForCheck.contains("-")) {
            number = numberForCheck.substring(1, numberForCheck.length());
        } else {
            number = numberForCheck;
        }



        //	String number = "123..a56";

        int lengthOfNumber = number.length();
        //	boolean isPeriodContains = number.contains(".");
        boolean periodNotContains = true;
        boolean otherCharacterExist = false;

        //	System.out.println("Number : "+number);
        //	System.out.println("Number Length : "+lengthOfNumber);
        //	System.out.println("Period Contain : "+isPeriodContains);

        for (int i = 0; i < lengthOfNumber; i++) {
            String s = number.substring(i, i + 1);
            //		System.out.println(s);

            try {
                Double.parseDouble(s);
                text += s;

            } catch (Exception e) {

                String c = number.substring(i, i + 1);
                //	System.out.println("Not number character : "+c);
                //	System.out.println("Not number index : "+c);
                if (c.equals(".")) {
                    periodNotContains = false;
                    if (!text.contains(".")) {
                        text += c;
                    } else {
                        text = number.substring(0, i);
                        break;

                    }
                } else {
                    text = number.substring(0, i);
                    break;
                }
            }

        }



        return text;



    }

    public static String decimalchecker(String text, int nmbersAfterDecimalPoint) {

        String number = "";


        if (text.contains("-")) {
            number = text.substring(1, text.length());
        } else {
            number = text;
        }


        String s = checkDecimal(number);
        //System.out.println("Ssss : "+s);
        boolean periodContains = s.contains(".");
        // System.out.println(" period con : "+periodContains);
        int indexOfDecimal = -1;
        String withDecimal = "";
        if (periodContains) {


            int length = s.length();
            for (int i = 0; i < length; i++) {
                String k = s.substring(i, i + 1);
                if (k.equals(".")) {
                    indexOfDecimal = i;
                    break;
                }
            }
            withDecimal = number.substring(0, indexOfDecimal + 1);

            if (indexOfDecimal < number.length()) {
                String afterDecimal = number.substring(indexOfDecimal + 1, number.length());
                int length1 = afterDecimal.length();

                if (length1 >= nmbersAfterDecimalPoint) {
                    String last2_chars = afterDecimal.substring(0, nmbersAfterDecimalPoint);
                    withDecimal += last2_chars;
                } else if (length1 == 1) {
                    String last_char = afterDecimal.substring(0, length1);
                    withDecimal += last_char;
                    withDecimal += "0";
                } else if (length1 == 0) {
                    withDecimal += "00";
                }
            }

        } else {
            withDecimal = s + ".00";
        }

        String t = "";

        if (text.contains("-")) {
            t += "-" + withDecimal;
        } else {
            t = withDecimal;
        }

        return t;

    }

    public static String roundtoNearestDecimalPoint(double value, int decimalPoint) {
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(decimalPoint, BigDecimal.ROUND_HALF_UP);        
        return bd.toString();

    }  
    
    
    
}
