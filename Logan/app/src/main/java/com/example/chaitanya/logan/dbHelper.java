package com.example.chaitanya.logan;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chaitanya on 27-Jun-17.
 */

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context) {
        super(context, "oops", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE login( username TEXT,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXITS login");
    }
    long put(String u,String p) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", u);
        cv.put("password", p);
        long n=db.insert("login", null, cv);

        return n;
    }
    public void onDelete(String use){
         SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM login WHERE username = '"+use+"'");
    }
    public void onUpdate(String use,String nuse,String npass){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE login SET username = '"+nuse+"',password = '"+npass+"' WHERE username = '"+use+"'" );
    }
}
