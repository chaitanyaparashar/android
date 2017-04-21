package com.example.chaitanya.myquiz;

/**
 * Created by chaitanya on 05-Apr-17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class catogaries extends Activity {
    static int ab;

    Button Science,History,Politics,Sports,Misc;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catogaries);
        History=(Button)findViewById(R.id.History);
        Politics=(Button)findViewById(R.id.Politics);
        Science=(Button)findViewById(R.id.Science);
        Misc=(Button)findViewById(R.id.Misc);
        Sports=(Button)findViewById(R.id.Sports);

        History.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                ab=2;
                startActivity(intent);
            }
        });
        Politics.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                ab=3;
                startActivity(intent);
            }
        });
        Science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                ab=4;
                startActivity(intent);
            }
        });
        Sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                ab=1;
                startActivity(intent);
            }
        });
        Misc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),QuestionActivity.class);
                ab=5;
                startActivity(intent);
            }
        });

    }

}
