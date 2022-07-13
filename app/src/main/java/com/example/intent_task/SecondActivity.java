package com.example.intent_task;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView info;
    EditText nameField;
    Button sendData;
    private Button page1_btn,page2_btn,page3_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameField=(EditText)findViewById(R.id.field);
        sendData=(Button)findViewById(R.id.send);
        Intent intent = getIntent();


        if (intent != null ) {
//            boolean name = intent.getBooleanExtra("EXTRA_NAME",true);
            String name =intent.getStringExtra("EXTRA_NAME");
            String age = intent.getStringExtra("EXTRA_AGE");
//        int ageInt=Integer.parseInt(age);
            String location = intent.getStringExtra("EXTRA_LOCATION");
//        Log.d("second",loaction);
//
            info = (TextView) findViewById(R.id.person);
//        info.setText("Name: "+name);
            info.setText("Name : " + name + "\nAge : " + age + "\nLocation : " + location);
        }
//        else{
//            info = (TextView) findViewById(R.id.person);
//            info.setText("Fields are empty");
//        }

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameValue =nameField.getText().toString();
                intent.putExtra("result",nameValue);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

        page1_btn=(Button) findViewById(R.id.page1);
        page2_btn=(Button) findViewById(R.id.page2);
        page3_btn=(Button) findViewById(R.id.page3);
        page1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(getBaseContext(),SecondActivity.class);
                startActivity(i1);
            }
        });
        page2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(getBaseContext(),ThirdActivity.class);
                i2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i2);
            }
        });
        page3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3=new Intent(getBaseContext(),FourtyActivity.class);
                startActivity(i3);
            }
        });


    }

}