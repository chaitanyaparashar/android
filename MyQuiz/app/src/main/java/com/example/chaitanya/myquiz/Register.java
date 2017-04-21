package com.example.chaitanya.myquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {
    EditText usernameSU,passwordSU,confirmSU;
    Button submit;
    private DbHelper db;

    void initViews(){
        db =new DbHelper(this);
        usernameSU = (EditText)findViewById(R.id.editTextUsernameSU);
        passwordSU = (EditText)findViewById(R.id.editTextPasswordSU);
        confirmSU = (EditText)findViewById(R.id.editTextConfirm);
        submit=(Button)findViewById(R.id.buttonSubmit);
        submit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSubmit){
            String username = usernameSU.getText().toString().trim();
            String password = passwordSU.getText().toString().trim();
            String strConfirmSU = confirmSU.getText().toString().trim();

            if (username.isEmpty()){
                Toast.makeText(this,"Enter your username",Toast.LENGTH_LONG).show();
            }
            else if (password.isEmpty()){
                Toast.makeText(this,"Enter password",Toast.LENGTH_LONG).show();
            }
            else if (!password.equals(strConfirmSU)){
                Toast.makeText(this,"Password doesn't match!",Toast.LENGTH_LONG).show();

            }
            else{
                db.addUsers(username,password);
                Intent i = new Intent(Register.this,Login.class );
                startActivity(i);
            }

        }


    }
}
