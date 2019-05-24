package com.example.elifozcevik.week3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {

    EditText textSize;
    CheckBox check;
    RadioButton black,red,blue,green;
    String renk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        textSize=findViewById(R.id.editText4);
        check=findViewById(R.id.checkBox);
        black=findViewById(R.id.radioButton9);
        red=findViewById(R.id.radioButton8);
        blue=findViewById(R.id.radioButton7);
        green=findViewById(R.id.radioButton6);
        check=findViewById(R.id.checkBox);


    }
    public void  set(View v){
        Intent myint=new Intent();

        if (red.isChecked()) {
            renk="red";
            myint.putExtra("color",renk);
        }
        else if (blue.isChecked()){
            renk="blue";
            myint.putExtra("color",renk);
        }
        else if (black.isChecked()) {
            renk="black";
            myint.putExtra("color",renk);
        }
        else                    {
            renk="green";
            myint.putExtra("color",renk);
        }

        myint.putExtra("size",Integer.parseInt(textSize.getText().toString()));
        //myint.putExtra("check",check.isChecked());

        setResult(RESULT_OK,myint);
        finish();
    }
}
