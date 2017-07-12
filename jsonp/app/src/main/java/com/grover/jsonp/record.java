package com.grover.jsonp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chaitanya on 10-Jul-17.
 */

public class record extends Activity{
    private ProgressDialog pDialog;
    private static String url ="https://podgier-woman.000webhostapp.com/table.php";
    JSONParser jParser = new JSONParser();
    ArrayList<HashMap<String, String>> contactList;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        contactList = new ArrayList<>();
        new gro().execute();
        lv = (ListView) findViewById(R.id.list);
    }
    class gro extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(record.this);
            pDialog.setMessage("logging up");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... args) {
            java.util.List<NameValuePair> pr = new ArrayList<NameValuePair>();

            JSONObject json = jParser.makeHttpRequest(url, "GET", pr);

            try {
                JSONArray code = json.getJSONArray("code");
                Log.d("list :",code.toString());
                for (int i = 0; i < code.length(); i++) {
                    JSONObject c = code.getJSONObject(i);

                    String rollno = c.getString("rollno");
                    String name = c.getString("name");
                    String password = c.getString("password");
                    String branch = c.getString("branch");
                    String mobileno = c.getString("mobileno");
                    String email = c.getString("email");
                    String dob = c.getString("dob");
                    Log.d("list :",name);
                    HashMap<String, String> contact = new HashMap<>();

                    // adding each child node to HashMap key => value
                    contact.put("rollno", rollno);
                    contact.put("name", name);
                    contact.put("password", password);
                    contact.put("branch", branch);
                    contact.put("mobileno", mobileno);
                    contact.put("email", email);
                    contact.put("dob", dob);

                    // adding contact to contact list
                    contactList.add(contact);
                    JSONArray p = null;
                }
                }catch(JSONException e){

                }
                return null;

        }

        protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            ListAdapter adapter = new SimpleAdapter(
                    record.this, contactList,
                    R.layout.list_item, new String[]{"rollno", "name",
                    "password","branch","mobileno","email","dob"}, new int[]{R.id.rollno,R.id.name,
                    R.id.password, R.id.branch, R.id.mobileno, R.id.email, R.id.dob});

            lv.setAdapter(adapter);
        }
    }
}
