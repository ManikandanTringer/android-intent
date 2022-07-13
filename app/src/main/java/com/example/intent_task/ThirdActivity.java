package com.example.intent_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    private Button page1_btn,page2_btn,page3_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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