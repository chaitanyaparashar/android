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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Grover on 6/10/2017.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2;
    EditText t1,t2;
    private ProgressDialog pDialog;

    JSONParser jParser = new JSONParser();

    JSONArray q = null;

    private static String url ="https://podgier-woman.000webhostapp.com/logan.php";
    protected void onCreate(Bundle savedInstnceState)
    {
        super.onCreate(savedInstnceState);
        setContentView(R.layout.studentlogin);
        b1=(Button)findViewById(R.id.studentlogin);
        b2=(Button)findViewById(R.id.studentsignup);
        t1=(EditText)findViewById(R.id.editText);
        t2=(EditText)findViewById(R.id.editText2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.studentsignup:
                Intent ii1 = new Intent(MainActivity.this, studentsignup.class);
                startActivity(ii1);
                break;

            case R.id.studentlogin:

                u = t1.getText().toString();
                p = t2.getText().toString();
                gro g1 = new gro();
                g1.execute();
                break;
        }

    }

    String u = "";
    String p = "";
    String msg = "grove";
    class gro extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("logging up");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            java.util.List<NameValuePair> pr = new ArrayList<NameValuePair>();

            pr.add(new BasicNameValuePair("rollno", u));
            pr.add(new BasicNameValuePair("password", p));


            JSONObject json = jParser.makeHttpRequest(url, "GET", pr);

            try {

                Log.d("ok", json.toString());
                int success = json.getInt("code");
                Log.d("fine", Integer.toString(success));
                JSONArray p = null;
                if (success == 1) {

                        Intent i14 = new Intent(MainActivity.this, student.class);
                        startActivity(i14);
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
        }
    }
}