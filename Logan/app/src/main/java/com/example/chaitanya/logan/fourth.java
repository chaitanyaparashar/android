package com.example.chaitanya.logan;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by chaitanya on 28-Jun-17.
 */

public class fourth extends Activity implements View.OnClickListener {
    EditText ouser, nuser, epas;
    ;
    Button subm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);
        ouser = (EditText) findViewById(R.id.et3);
        nuser = (EditText) findViewById(R.id.et2);
        epas = (EditText) findViewById(R.id.et1);
        subm = (Button) findViewById(R.id.but);
        subm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String abc = ouser.getText().toString();
        String nuse = nuser.getText().toString();
        String npass = epas.getText().toString();
        int count = 0;
        dbHelper db = new dbHelper(getApplicationContext());
        SQLiteDatabase sql = openOrCreateDatabase("oops", SQLiteDatabase.CREATE_IF_NECESSARY,
                null);
        Cursor cursor = sql.rawQuery("SELECT * FROM Login", null);
        cursor.moveToFirst();

        do {
            String u = cursor.getString(cursor.getColumnIndex("username"));
            if (abc.equalsIgnoreCase(u)) {
                db.onUpdate(abc,nuse,npass);
                count = 1;
                Toast.makeText(this, "Record Updated Successfully", Toast.LENGTH_LONG).show();
                ouser.setText("");
                nuser.setText("");
                epas.setText("");
            }
        } while (cursor.moveToNext());
        if (count == 0) {
            Toast.makeText(this, "Invalid entry", Toast.LENGTH_LONG).show();
        }
    }
}
