package com.example.chaitanya.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.round;

// Main activity class
public class MainActivity extends AppCompatActivity {
     TextView textview1;
     TextView textview2;
     TextView textview3;
    // This method would be called when What's the weather button would be pressed
    public void findtheweather(View view) {

        //Assigning the value which user entered to String s

        // Calling download task function
        download task = new download();

        // Executing download task and change this " uk&appid=9f681051b003f104ae5e2a0cbef19a02" with your own API KEY
        task.execute("https://newsapi.org/v1/articles?source=the-hindu&sortBy=top&apiKey=01f653b7c801438d8fa6ed98606b0536");

    }

    // onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Using id to tell where to make changes


    }

    // Creating download method with Async Task ( we r going to use this to get data from internet and parse it )
    private class download extends AsyncTask<String, Void, String> {

        // This method execute after doInBackground method and Parse the Json

        @Override
        protected void onPostExecute(String result) {
// Try and catch block to catch any errors
            try {
                textview1 = (TextView) findViewById(R.id.textView1);
                textview2 = (TextView) findViewById(R.id.textView2);
                textview3 = (TextView) findViewById(R.id.textView3);
                // linking result1 with textView with id result

//                calling  JSONObject as jsonObject
                JSONObject jsonObject = new JSONObject(result);

//                using jsonObject to get String from Json which is tagged as weather
                JSONArray title = jsonObject.getJSONArray("articles");
//        calling JSONArray as arr

               // int arr    = mainVarr.getInt("temp");
// using for loop to loop through arr array

                JSONObject c = title.getJSONObject(0);
                    // using result1 to set Text of that Text view with id Result  to this
                String title1= c.getString("title");
                textview1.setText("1."+title1+".");
                JSONObject d = title.getJSONObject(1);
                String title2= d.getString("title");
                textview2.setText("2."+title2+".");
                JSONObject e = title.getJSONObject(3);
                String title3= e.getString("title");
                textview3.setText("3."+title3+".");

//                e.printStackTrace will just print a error report like a normal program do when it crashes u can change this with anything u like
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

        // do doInBackground method we r using this method to download Json from site.
        @Override
        protected String doInBackground(String... urls) {
            String result = "";

//            calling url as url
            URL url;
//            calling HttpUrlConnection as urlConnection
            HttpURLConnection urlConnection;

//            Using try and catch block to find any errors
            try {
                // assigning url value of first object in array called urls which is declared in this start of this method
                url = new URL(urls[0]);

                // using urlConnection to open url which we assigning URL before
                urlConnection = (HttpURLConnection) url.openConnection();

                // Using InputStream to download the content
                InputStream inputStream = urlConnection.getInputStream();
                // Using InputStreamReader to read the inputstream or the data we r downloading
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

//                using it to check if we reached the end of String / Data
                int Data = inputStreamReader.read();
//              using While loop to assign that data to string called result because InputStreamReader reads only one character at a time
                while (Data != -1) {

                    char current = (char) Data;

                    result += current;

                    Data = inputStreamReader.read();
                }

                // returning value of result

                return result;

//                Try and catch block to catch any errors
            } catch (Exception e) {
//                e.printStackTrace will just print a error report like a normal program do when it crashes u can change this with anything u like
                e.printStackTrace();
            }

            return null;
        }


    }

}