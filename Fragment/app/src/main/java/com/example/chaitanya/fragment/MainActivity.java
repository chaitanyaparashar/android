package com.example.chaitanya.fragment;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b;
    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.bn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(!status) {
                    FragmentOne f1 = new FragmentOne();
                    fragmentTransaction.add(R.id.fragment_container,f1);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    b.setText("load first fragment");
                    status = true;

                }
                else {
                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container, f2);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    b.setText("load second fragment");
                    status = false;
                }
            }
        });
    }
}
