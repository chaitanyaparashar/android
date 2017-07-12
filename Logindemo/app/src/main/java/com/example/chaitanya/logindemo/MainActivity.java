package com.example.chaitanya.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;
    Button signup;
    EditText usrn;
    EditText passw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = (Button)findViewById(R.id.button);
        signup = (Button)findViewById(R.id.button2);
        usrn = (EditText)findViewById(R.id.usrnm);
        passw = (EditText)findViewById(R.id.pass);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            String usr = usrn.getText().toString();
            String pas = passw.getText().toString();
            if(usr.equalsIgnoreCase("admin") && pas.equalsIgnoreCase("admin")){
                Intent i = new Intent(MainActivity.this, admin.class);
                startActivity(i);
                finish();
            }
        }
        else if(view.getId()==R.id.button2){
            Intent i = new Intent(MainActivity.this,Register.class);
            startActivity(i);
            finish();
        }
    }
}
