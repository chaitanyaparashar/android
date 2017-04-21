package com.example.chaitanya.myquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;


public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textResult = (TextView) findViewById(R.id.textResult);
        TextView textResult2 = (TextView) findViewById(R.id.textResult2);
        TextView textResult3 = (TextView) findViewById(R.id.textResult3);

        Bundle b = getIntent().getExtras();

        int score = b.getInt("score");

        textResult3.setText("Your score is " + " " + score + " Thanks for playing my game.I Hope u enjoyed it \n");
        textResult3.setText("Remarks:-");
        if(score<=5){
            textResult3.setText("Your score is "+ ""+ score + "\n Remarks:-You can do it try again\n" +
                    "Thanks for playing my game.I Hope u enjoyed it");
        }
        else if(score<=10 && score>5){
            textResult3.setText("Your score is "+ " "+ score + "\n" +
                    " Remarks:-Good\n" +
                    "Thanks for playing my game.I Hope u enjoyed it");
        }
        else if(score<=19 && score>10){
            textResult3.setText("Your score is "+ " "+ score + "\n" +
                    " Remarks:-Hii..Genius\n" +
                    "Thanks for playing my game.I Hope u enjoyed it");
        }
        else if(score<=21 && score>19){
            textResult3.setText("Your score is "+ " "+ score + "\n" +
                    "Remarks:- Hi.. Chaitanya Parashar\n" +
                    "Thanks for playing my game.I Hope u enjoyed it");
        }
        textResult.setText("Current Score:"+score);
        SharedPreferences settings = getSharedPreferences("GAME_DATA",Context.MODE_PRIVATE);
        int highscore= settings.getInt("HIGH_SCORE",0);
        if(score>highscore){
            textResult2.setText("highscore :"+score);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE",score);
            editor.commit();
        }
        else{
            textResult2.setText("highscore :"+highscore);
        }
    }

    public void playagain(View o) {

        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
        finish();
    }

    public void homes(View o) {

        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}