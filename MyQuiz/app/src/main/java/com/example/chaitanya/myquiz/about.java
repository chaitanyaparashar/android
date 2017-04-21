package com.example.chaitanya.myquiz;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class about extends Activity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        textView = (TextView) findViewById(R.id.textView);
        String htmlText = "<p> Chaitanya Parashar </p><p>Jaspreet Kaur</p> <p> +91 8437538555 </p> <p> cparashar007@gmail.com </p>";
        textView.setText(Html.fromHtml(htmlText));
    }
}