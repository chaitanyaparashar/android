package com.example.chaitanya.myquiz;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jaspreet on 19-Mar-17.
 */

public class Session {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public  Session(Context ctx){
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myapp",Context.MODE_PRIVATE);
        editor = prefs.edit();

    }
    public void SetLoggedin(boolean loggedin){
        editor.putBoolean("loggedinmode",loggedin);
        editor.commit();

    }
    public boolean loggedin(){
        return prefs.getBoolean("loggedinmode",false);
    }
}
