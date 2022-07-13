package com.example.intent_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button sumbit_btn,page1_btn,page2_btn,page3_btn;
    private EditText name, age, location;
    TextView displayresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        location = findViewById(R.id.location);
        sumbit_btn = (Button)  findViewById(R.id.sumbit);
        sumbit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This onClick method get the value of the text field
                String nameValue=name.getText().toString();
                String ageValue=age.getText().toString();
//                int ageValue=Integer.parseInt(age.getText().toString());
                String locationValue=location.getText().toString();
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent.putExtra("EXTRA_NAME",nameValue);
//                intent.putExtra("EXTRA_AGE",ageValue);
//                intent.putExtra("EXTRA_LOCATION",locationValue);
//                startActivity(intent);
                openSecondActivity(nameValue,ageValue,locationValue);
            }
        });
        //These button launch the activity corresponding pages
        page1_btn=(Button) findViewById(R.id.page1);
        page2_btn=(Button) findViewById(R.id.page2);
        page3_btn=(Button) findViewById(R.id.page3);
        page1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent the page1(SecondActivity)
                Intent i1=new Intent(getBaseContext(),SecondActivity.class);
                startActivity(i1);
            }
        });
        page2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent the page2(ThirdActivity)
                Intent i2=new Intent(getBaseContext(),ThirdActivity.class);
                //assigning the launch mode using addFlags()
                i2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i2);
            }
        });
        page3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent the page3(FourtyActivity)
                Intent i3=new Intent(getBaseContext(),FourtyActivity.class);
                startActivity(i3);
            }
        });


    }

    public void openSecondActivity(String name,String age,String location) {
//        String nameValue = name.getText().toString();
//        int ageValue = Integer.parseInt(age.getText());
//        String locationValue = location.getText().toString();
        Log.d("values",name);
        Log.d("values",location);
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("EXTRA_NAME",name);
        intent.putExtra("EXTRA_AGE", "");
        intent.putExtra("EXTRA_LOCATION", location);

//        startActivity(intent);
        //start the activity with requestcode(it helps you to find which intent launched
            startActivityForResult(intent,0);
    }
    @Override
    public void onActivityResult(int resquestCode,int resultCode,Intent data ) {

        super.onActivityResult(resquestCode, resultCode, data);
        if(resquestCode == 0){

            if(resultCode== RESULT_OK){
                String result= data.getStringExtra("result");
                displayresult=findViewById(R.id.textView);
                displayresult.setText(result);
            }
        }
    }

}