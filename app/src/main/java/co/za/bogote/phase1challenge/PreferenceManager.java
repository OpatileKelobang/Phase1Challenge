/*
 * Copyright (c) 2019.
 * Opatile Kelobang
 * http://www.bogote.co.za
 * Android App Development
 */

package co.za.bogote.phase1challenge;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private Context context;
    private SharedPreferences sharedPreferences;

    public PreferenceManager(Context context)
    {
        this.context = context;
        getSharedPreference();
    }

    private void getSharedPreference()
    {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_preferences), Context.MODE_PRIVATE);
    }


    public void writePreference()
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_preferences_key), "INIT_OK");
        editor.commit();
    }

    public boolean checkPreference()
    {
        boolean status = false;

        if(sharedPreferences.getString(context.getString(R.string.my_preferences_key), "null").equals("null"))
        {
            status = false;
        }
        else
            {
                status = true;
            }
        return status;
    }

    public void clearPreference()
    {
        sharedPreferences.edit().clear().commit();
    }


}
