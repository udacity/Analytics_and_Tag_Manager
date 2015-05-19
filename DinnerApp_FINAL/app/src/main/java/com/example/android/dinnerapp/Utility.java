package com.example.android.dinnerapp;

import android.content.Context;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by jocelyn on 12/10/14.
 */
public class Utility {

    public static void showMyToast (String toastText, Context appContext) {

        // Show a toast
        // Context context = getApplicationContext();
        // CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(appContext, toastText, duration);
        toast.show();

    }

    public static String[] combine(String[] a, String[] b){
        int length = a.length + b.length;
        String[] result = new String[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static String[] combine(String[] a, String[] b, String[] c, String[] d){
        return combine(combine(a, b), combine(c, d));
    }

    // The ID of a dinner is encoded in the first two characters
    public static String getDinnerId (String dinner) {

        return dinner.substring(0,2);
    }

    // Gets the current time as a String
    public static String getCurrentTime () {
        Date curDate = new Date();
        SimpleDateFormat format = format = new SimpleDateFormat("dd-M hh:mm:ss");
        return format.format(curDate);
    }

    public static String getUniqueTransactionId (String productId) {
        return ("T-" + getCurrentTime() + productId );
    }


}
