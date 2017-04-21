package com.example.chaitanya.myquiz;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class help extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        textView = (TextView) findViewById(R.id.textView);
        String htmlText = "<h3>you have to attempt maximum right questions in limited time.if you give a wrong answer then your quiz is over...better luck next time :-) </h3>";
        textView.setText(Html.fromHtml(htmlText));
    }
}