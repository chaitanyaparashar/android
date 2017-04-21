package com.example.chaitanya.myquiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends Activity {
    Button play,about,help,quit;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        play=(Button)findViewById(R.id.play);
        about=(Button)findViewById(R.id.about);
        quit=(Button)findViewById(R.id.quit);
        help=(Button)findViewById(R.id.help);

        play.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(getApplicationContext(),catogaries.class);
                startActivity(intent);
                finish();
            }
        });
        quit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),about.class);
                startActivity(intent);
            }
        });
        help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),help.class);
                startActivity(intent);
            }
        });

    }

}