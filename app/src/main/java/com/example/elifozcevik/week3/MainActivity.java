package com.example.elifozcevik.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // EditText[] edit=new EditText[3];
    EditText  second;
    EditText hour;
    EditText  minute;
    TextView history;
    int size;
    String renk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // edit[0]=findViewById(R.id.editText);
        //edit[1]=findViewById(R.id.editText3);
       // edit[2]=findViewById(R.id.editText5);
        hour=findViewById(R.id.editText);
        minute=findViewById(R.id.editText3);
        second=findViewById(R.id.editText5);
        history=findViewById(R.id.textView12);
        history.append("History");



    }

    public void Start(View v){
        Intent counterIntent=new Intent(this,CountActivity.class);
        counterIntent.putExtra("second", Integer.parseInt(second.getText().toString()));
        counterIntent.putExtra("minute", Integer.parseInt(minute.getText().toString()));
        counterIntent.putExtra("hour", Integer.parseInt(hour.getText().toString()));
        counterIntent.putExtra("size",size);
        counterIntent.putExtra("color",renk);
        //counterIntent.putExtra("size", size);
        startActivityForResult(counterIntent,300);

    }

    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==300){

            //size=data.getIntExtra("size",0);
            int rs=data.getIntExtra("saat",0);
            int dk=data.getIntExtra("dakika",0);
            int sn=data.getIntExtra("saniye",0);
            renk=data.getStringExtra("color");
            size=data.getIntExtra("size",0);
            history.append("\n Finish time:"+rs+":"+dk+":" +sn);



            //logtext.append("Timer Stopped at "+rs);
        }
    }

    public void StartOpt(View v){
        Intent counterIntent=new Intent(this,OptionsActivity.class);
        startActivityForResult(counterIntent,300);

    }

}
