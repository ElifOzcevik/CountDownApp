package com.example.elifozcevik.week3;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {

    CountDownTimer myTimer;
    int hour;
    int minute;
    int second;
    boolean resume=true;
    TextView text_hour;
    TextView text_minute;
    TextView text_second;

    int zaman;
    int size;
    String color;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        text_hour=findViewById(R.id.textView7);
        text_minute=findViewById(R.id.textView8);
        text_second=findViewById(R.id.textView9);




        Intent myIntent=getIntent();
        hour=(myIntent.getIntExtra("hour",0));
        minute=(myIntent.getIntExtra("minute",0));
        second=(myIntent.getIntExtra("second",0));
        size=(myIntent.getIntExtra("size",0));;
        color=(myIntent.getStringExtra("color"));

        text_hour.setTextSize(size);
        text_minute.setTextSize(size);
        text_second.setTextSize(size);

        zaman=hour*3600 + minute*60 + second;

        switch (color) {
            case "black": {
                            text_hour.setTextColor(Color.BLACK);
                            text_minute.setTextColor(Color.BLACK);
                            text_second.setTextColor(Color.BLACK);
                            break;
                    }
            case "red":{
                            text_hour.setTextColor(Color.RED);
                            text_minute.setTextColor(Color.RED);
                            text_second.setTextColor(Color.RED);
                            break;
                            }
            case "blue": {
                            text_hour.setTextColor(Color.BLUE);
                            text_minute.setTextColor(Color.BLUE);
                            text_second.setTextColor(Color.BLUE);
                            break;
                        }
            case "green": {
                            text_hour.setTextColor(Color.GREEN);
                            text_minute.setTextColor(Color.GREEN);
                            text_second.setTextColor(Color.GREEN);
                            break;
                           }
        }

        text_hour.setText(hour+"\n");
        text_minute.setText(minute+"\n");
        text_second.setText(second+"\n");


        myTimer=new CountDownTimer(zaman*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                second--;

                text_second.setText(second+"\n");

                if(second==0) {
                                if (minute!=0) minute--;
                                text_minute.setText(minute+"\n");
                                second=60;
                                }
                if(minute==0) {
                                if (hour!=0) {hour--;
                                              minute=60;
                                                }
                                text_hour.setText(hour+"\n");
                                //if (hour!=0 && second!=0) minute=60;
                                }
            }


            @Override
            public void onFinish() {

            }
        };
        myTimer.start();
    }


    public void stop(View v){
        myTimer.cancel();
        Intent myint=new Intent();
        myint.putExtra("saat",hour);
        myint.putExtra("dakika",minute);
        myint.putExtra("saniye",second);
        setResult(RESULT_OK,myint);
        myTimer.onFinish();

    }

    public void resume(View v){


        if (resume) {
                        pauseTimer();
                    }
                    else{
                            startTimer();
                             }

    }

    public void pauseTimer(){
        myTimer.cancel();
        myTimer.cancel();
        Intent myint=new Intent();
        myint.putExtra("saat",hour);
        myint.putExtra("dakika",minute);
        myint.putExtra("saniye",second);
        setResult(RESULT_OK,myint);

        resume=false;

    }

    public void startTimer(){
        myTimer.start();

        resume=true;

        }



    public void re(View v){

        finish();
    }
}

