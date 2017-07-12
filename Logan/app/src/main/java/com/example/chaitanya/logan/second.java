package com.example.chaitanya.logan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by chaitanya on 27-Jun-17.
 */

public class second extends Activity implements View.OnClickListener{
    TextView t1;
    Button show,del,mod;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        show = (Button)findViewById(R.id.bt);
        t1 = (TextView)findViewById(R.id.tx);
        show.setOnClickListener(this);
        del = (Button)findViewById(R.id.bt4);
        mod = (Button)findViewById(R.id.bt5);
        del.setOnClickListener(this);
        mod.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt) {
            SQLiteDatabase sql = openOrCreateDatabase("oops", SQLiteDatabase.CREATE_IF_NECESSARY, null);
            Cursor cursor = sql.rawQuery("SELECT * FROM Login", null);
            cursor.moveToFirst();

            do {
                String u = cursor.getString(cursor.getColumnIndex("username"));
                t1.append(u + "\n");
            } while (cursor.moveToNext());
            Toast.makeText(this, "Total users " + cursor.getCount(), Toast.LENGTH_LONG).show();
        }
        else if(view.getId()==R.id.bt4){
          Intent i = new Intent(this,third.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.bt5){
            Intent i = new Intent(this,fourth.class);
            startActivity(i);
        }
    }
}
