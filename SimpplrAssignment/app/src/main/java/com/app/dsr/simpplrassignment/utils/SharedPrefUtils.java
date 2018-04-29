package com.app.dsr.simpplrassignment.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.app.dsr.simpplrassignment.network.model.UserPrivate;
import com.app.dsr.simpplrassignment.network.model.UserPublic;

public class SharedPrefUtils {

    private static final String USER_PREF_FILENAME = "User_Pref";
    private static final String APP_PREF_FILENAME = "App_Pref";


    public static String getStringSharedPreference(Context context,String prefKey,String defaultValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREF_FILENAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(prefKey,defaultValue);
    }
    public static void setStringSharedPreference(Context context,String prefKey,String value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREF_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(prefKey,value);
        editor.apply();
    }

    public static void setUserPrivateSharedPreference(Context context, UserPrivate userPrivate){
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREF_FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(AppConstants.SharedPrefernce.KEY_USER_ID,userPrivate.getId());
        editor.putString(AppConstants.SharedPrefernce.KEY_USER_EMAIL,userPrivate.getEmail());
        editor.putString(AppConstants.SharedPrefernce.KEY_USER_NAME,userPrivate.getDisplay_name());
        editor.putString(AppConstants.SharedPrefernce.KEY_USER_COUNTRY,userPrivate.getCountry());
        if (userPrivate.getImages() != null && userPrivate.getImages().size()>0) {
            editor.putString(AppConstants.SharedPrefernce.KEY_USER_IMAGE, userPrivate.getImages().get(0).getUrl());
        }
        editor.apply();
    }

}
