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
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class studentsignup extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2,b3;
    EditText t1, t2, t3, t4, t5,t6,t7;
    private ProgressDialog pDialog;
    JSONParser jParser = new JSONParser();
    JSONArray q = null;

    private static String url = "https://podgier-woman.000webhostapp.com/abc.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentsignup);

        b1 = (Button) findViewById(R.id.studentsubmit);
        b2=(Button)findViewById(R.id.studentclear);
        b3=(Button)findViewById(R.id.studentback);

        t1 = (EditText) findViewById(R.id.rollno);
        t2 = (EditText) findViewById(R.id.name);
        t3 = (EditText) findViewById(R.id.pass);
        t4 = (EditText) findViewById(R.id.branch);
        t5 = (EditText) findViewById(R.id.mobileno);
        t6=  (EditText) findViewById(R.id.email);
        t7=  (EditText) findViewById(R.id.dob);

        b1.setOnClickListener(this);
        b3.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.studentback:
                Intent i1 = new Intent(studentsignup.this, MainActivity.class);
                startActivity(i1);
                break;
            case R.id.studentsubmit:
                r = t1.getText().toString();
                n = t2.getText().toString();
                p = t3.getText().toString();
                b = t4.getText().toString();
                mob = t5.getText().toString();
                e = t6.getText().toString();
                d = t7.getText().toString();
                grove g1 = new grove();
                g1.execute();
                break;
            case R.id.studentclear:
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
        }
    }

    String r = "";
    String n = "";
    String p = "";
    String b = "";
    String mob = "";
    String e="";
    String d="";
    String msg = "gggvvn";

    class grove extends AsyncTask<String, String, String> {
        protected void onPreExecute()

        {
            super.onPreExecute();
            pDialog = new ProgressDialog(studentsignup.this);
            pDialog.setMessage("keep calm");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            java.util.List<NameValuePair> pr = new ArrayList<NameValuePair>();

            pr.add(new BasicNameValuePair("rollno", r));
            pr.add(new BasicNameValuePair("name", n));
            pr.add(new BasicNameValuePair("password", p));
            pr.add(new BasicNameValuePair("branch", b));
            pr.add(new BasicNameValuePair("mobileno",mob));
            pr.add(new BasicNameValuePair("email", e));
            pr.add(new BasicNameValuePair("dob",d));

            JSONObject json = jParser.makeHttpRequest(url, "GET", pr);
            try {
                Log.d("ok", json.toString());
                int success = json.getInt("code");
                Log.d("fine", Integer.toString(success));
                JSONArray p = null;
                if (success == 1) {
                    Intent i1=new Intent(studentsignup.this,student.class);
                    startActivity(i1);
                    msg = "Student added";
                } else {
                    msg = "Student is invalid";
                }

            } catch (JSONException e) {

                msg = "problm";
            }
            return null;
        }


        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            Toast.makeText(studentsignup.this, msg, Toast.LENGTH_LONG).show();
        }
    }
}