package com.example.chaitanya.myquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jaspreet on 19-Mar-17.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG =DbHelper.class.getSimpleName();
    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 2;

    public static final String USER_TABLE ="users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USERNAME + " TEXT,"
            + COLUMN_PASSWORD + " TEXT);";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + USER_TABLE);
        onCreate(db);
    }

    public void addUsers(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,username);
        values.put(COLUMN_PASSWORD, password);
        long id = db.insert(USER_TABLE,null,values);
        String query = "INSERT INTO "+USER_TABLE+" ("+COLUMN_USERNAME+","+COLUMN_PASSWORD+") VALUES('chaitanya','5153');";
        db.execSQL(query);
        db.close();

        Log.d(TAG, "user inserted" + id);
    }

    public boolean getUser(String username,String password){
        String selectQuery = "select * from " + USER_TABLE + " where " + COLUMN_USERNAME + " = " + "'" +username+  "'" + " and " +
                COLUMN_PASSWORD + " = " + "'" +password+  "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            return true;
        }
        cursor.close();
        db.close();

        return  false;
    }

}
