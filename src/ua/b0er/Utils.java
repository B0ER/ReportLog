package ua.b0er;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String currentDir(Object obj){
        String directory = "" + obj.getClass().getProtectionDomain().getCodeSource().getLocation() + "\\" ;
        return directory.substring(6, directory.length()-1);
    }
    public static String getDate(){
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        return formatForDateNow.format(new Date());
    }
}
