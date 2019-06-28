package com.app.thestream.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class UserPref {

public static SharedPreferences.Editor editor;
    public static SharedPreferences.Editor sharedEditor(Activity context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("UserPref",Context.MODE_PRIVATE);
         editor=sharedPreferences.edit();
        return editor;

    }


    public static  SharedPreferences getSharedPref(Activity activity){


        return activity.getSharedPreferences("UserPrf",Context.MODE_PRIVATE);
    }
}
