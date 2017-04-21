package com.example.chaitanya.myquiz;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button login,signup;
    TextInputLayout TLUserName, TLPassword;


    private DbHelper db;
    private Session session;


    void initViews(){
        db = new DbHelper(this);
        session = new Session(this);
        username = (EditText)findViewById(R.id.editTextUsername);
        password = (EditText)findViewById(R.id.editTextPassword);
        TLUserName = (TextInputLayout)findViewById(R.id.TIETusername);
        TLPassword =(TextInputLayout)findViewById(R.id.TIETpassword);
        username.setHint("Username");
        password.setHint("Password");
        login = (Button)findViewById(R.id.buttonLogin);
        signup = (Button)findViewById(R.id.buttonSignup);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        if (session.loggedin()){
            Intent i = new Intent(Login.this,Profile.class);
            startActivity(i);
            finish();
        }


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       if(item.getItemId()== R.id.action_help){
           Intent i = new Intent(Login.this,help.class);
           startActivity(i);
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonLogin){
            String strusername = username.getText().toString();
            String strpassword = password.getText().toString();

            if(strusername.equalsIgnoreCase("chaitanya") && strpassword.equalsIgnoreCase("5153")){
                db.addUsers(strusername,strpassword);
            }
            if (db.getUser(strusername, strpassword)) {
                if(strusername.equalsIgnoreCase("chaitanya") && strpassword.equalsIgnoreCase("5153")){
                    session.SetLoggedin(true);
                    Intent i = new Intent(Login.this,admin.class);
                    i.putExtra("Username",strusername);
                    startActivity(i);
                }
                else {
                    session.SetLoggedin(true);
                    Intent i = new Intent(Login.this, Profile.class);
                    i.putExtra("Username", strusername);
                    startActivity(i);
                }
            }
            //
            else{
                Toast.makeText(this,"Invalid username/password",Toast.LENGTH_LONG).show();
            }

        }
        else if (v.getId() == R.id.buttonSignup){
            Intent i = new Intent(Login.this,Register.class);
            startActivity(i);
        }
    }
}


