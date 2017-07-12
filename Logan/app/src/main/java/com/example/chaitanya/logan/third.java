package com.example.chaitanya.logan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by chaitanya on 28-Jun-17.
 */

public class third extends Activity implements View.OnClickListener{
    EditText use;
    Button sub;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
     use = (EditText)findViewById(R.id.et4);
     sub = (Button)findViewById(R.id.but1);
     sub.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int count = 0;
        String abc = use.getText().toString();
        dbHelper db = new dbHelper(getApplicationContext());
        SQLiteDatabase sql = openOrCreateDatabase("oops", SQLiteDatabase.CREATE_IF_NECESSARY,
                null);
        Cursor cursor = sql.rawQuery("SELECT * FROM Login", null);
        cursor.moveToFirst();

        do{
            String u = cursor.getString(cursor.getColumnIndex("username"));
            if(abc.equalsIgnoreCase(u)){
                db.onDelete(u);
                count = 1;
                Toast.makeText(this,u+" Deleted successfully",Toast.LENGTH_LONG).show();
            }
        }while (cursor.moveToNext());
        if(count == 0){
            Toast.makeText(this,"Invalid entry",Toast.LENGTH_LONG).show();
        }
    }
}
