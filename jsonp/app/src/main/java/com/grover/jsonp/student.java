package com.grover.jsonp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Grover on 6/10/2017.
 */
public class student extends AppCompatActivity implements View.OnClickListener{
    Button b1,b2;
    EditText enter;
    TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7;
    private ProgressDialog pDialog;
    int success;
    String name,password,rollno,branch,mobileno,email,dob;
    JSONParser jParser = new JSONParser();
    private static String url = "https://podgier-woman.000webhostapp.com/record.php";
    String u = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student);
        enter= (EditText)findViewById(R.id.ed1);
        b1 = (Button) findViewById(R.id.a);
        b2 =(Button)findViewById(R.id.b);
        tx1=(TextView)findViewById(R.id.tx1);
        tx2=(TextView)findViewById(R.id.tx2);
        tx3=(TextView)findViewById(R.id.tx3);
        tx4=(TextView)findViewById(R.id.tx4);
        tx5=(TextView)findViewById(R.id.tx5);
        tx6=(TextView)findViewById(R.id.tx6);
        tx7=(TextView)findViewById(R.id.tx7);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    String msg = "gggvvn";

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.a){
            u = enter.getText().toString();
            gro g1 = new gro();
            g1.execute();
        }
        else if(view.getId()==R.id.b){
        Intent i = new Intent(this,record.class);
            startActivity(i);
        }
    }


    class gro extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(student.this);
            pDialog.setMessage("fetching data");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            java.util.List<NameValuePair> pr = new ArrayList<NameValuePair>();

            pr.add(new BasicNameValuePair("rollno", u));


            JSONObject json = jParser.makeHttpRequest(url, "GET", pr);

            try {

                Log.d("ok", json.toString());
                success = json.getInt("code");
                Log.d("fine", Integer.toString(success));
                JSONArray p = null;
                if (success == 1) {
                    rollno = json.getString("rollno");
                    name =json.getString("name");
                    password = json.getString("password");
                    mobileno =json.getString("mobileno");
                    branch = json.getString("branch");
                    email = json.getString("email");
                    dob = json.getString("dob");
                }
                else
                {
                    msg="user is invalid";
                }

            } catch (JSONException e) {
                msg = "problm";
            }
            return null;
        }

        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            tx2.setText("rollno : "+rollno);
            tx1.setText("name : "+name);
            tx3.setText("password : "+password);
            tx5.setText("mobileno : "+mobileno);
            tx6.setText("branch : "+branch);
            tx4.setText("email : "+email);
            tx7.setText("dob : "+dob);
            enter.setText("");
        }
    }
}
