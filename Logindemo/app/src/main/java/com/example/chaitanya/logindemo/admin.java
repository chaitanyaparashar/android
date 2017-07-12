package com.example.chaitanya.logindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by chaitanya on 23-Jun-17.
 */

public class admin extends Activity implements View.OnClickListener{
    Button del,mod,close;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        del = (Button)findViewById(R.id.delete);
        mod = (Button)findViewById(R.id.modify);
        close = (Button)findViewById(R.id.close);
        txt = (TextView)findViewById(R.id.textView2);
        del.setOnClickListener(this);
        mod.setOnClickListener(this);
        close.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.delete){
            Intent i = new Intent(admin.this,table.class);
            startActivity(i);

        }
        else if(view.getId()==R.id.modify){
            Intent i = new Intent(admin.this,table.class);
            startActivity(i);
        }
        else if(view.getId()==R.id.close){
            finish();
        }
    }
}
