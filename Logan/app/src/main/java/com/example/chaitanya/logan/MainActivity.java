package com.example.chaitanya.logan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button login,signup;

    EditText user,pass;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button)findViewById(R.id.bt1);
        login.setOnClickListener(this);
        signup = (Button)findViewById(R.id.bt2);
        signup.setOnClickListener(this);
        user = (EditText)findViewById(R.id.ed1);
        pass = (EditText)findViewById(R.id.ed2);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.bt2){

            try {

                String abc = user.getText().toString();
                String bcd = pass.getText().toString();
                dbHelper db = new dbHelper(getApplicationContext());
                if(abc .equalsIgnoreCase("") && bcd .equalsIgnoreCase("")) {
                 Toast.makeText(this,"Enter something",Toast.LENGTH_LONG).show();
                }
                else{
                    db.put(abc,bcd);

                    Toast.makeText(this, "record added", Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                }
            }

            catch (Exception e){
                Toast.makeText(this, "exception="+e, Toast.LENGTH_LONG).show();
            }

        }
        else if(view.getId()==R.id.bt1) {
            int count = 0;
            String abc = user.getText().toString();
            String bcd = pass.getText().toString();

            try {

                SQLiteDatabase sql = openOrCreateDatabase("oops", SQLiteDatabase.CREATE_IF_NECESSARY,
                        null);
                Cursor cursor = sql.rawQuery("SELECT * FROM Login", null);
                cursor.moveToFirst();

                do{

                    String u = cursor.getString(cursor.getColumnIndex("username"));
                    String p = cursor.getString(cursor.getColumnIndex("password"));
                    Log.d(u,"here");

                    if (abc.equalsIgnoreCase(u) && bcd.equalsIgnoreCase(p)) {
                        Intent i = new Intent(this, second.class);
                        user.setText("");
                        pass.setText("");
                        startActivity(i);
                   Log.d(u,"here");
                        count = 1;
                    }

                }while (cursor.moveToNext());
                if(count == 0){
                    Toast.makeText(this, "Inavlid user", Toast.LENGTH_LONG).show();
                }

            }
            catch (Exception e){
                Toast.makeText(this, "exception="+e, Toast.LENGTH_LONG).show();
            }
        }
    }
}
