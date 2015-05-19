package com.example.android.dinnerapp;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jocelyn on 12/10/14.
 */
public class Utility {

    public static void showMyToast (String toastText, Context appContext) {

        // Show a toast with tonights dinner
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


}
