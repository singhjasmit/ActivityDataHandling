package com.androidclass.activitydatahandling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn1, btn2, btn3;
    TextView dataView;

    final static int MY_REQ_CODE = 300;

    final static String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate()");


        btn1 = (Button) findViewById(R.id.btn_1);
        btn2 = (Button) findViewById(R.id.btn_2);
        btn3 = (Button) findViewById(R.id.btn_3);

        dataView = (TextView) findViewById(R.id.return_data);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;
        Bundle b;

       switch(view.getId()){

           case R.id.btn_1:
               // call activity without any data passed to it
               i = new Intent(this, MainActivity2.class);
               startActivity(i);
               break;
           case R.id.btn_2:
                // call the activity and send some data to it
               i = new Intent(this, MainActivity2.class);
               b = new Bundle();
               b.putString("msg_from_activity_one", "I am sending you some data from btn 2");
               b.putInt("count", 2);
               i.putExtras(b);
               startActivity(i);

               break;

           case R.id.btn_3:

               // call the activity, send some data to it and expect some data to return

               i = new Intent(this, MainActivity2.class);
               b = new Bundle();
               b.putString("msg_from_activity_one", "I am sending you some data from btn 3");
               b.putInt("count", 3);
               i.putExtras(b);

               //---create my own custom object that is serializable---
               Person myObject = new Person();
               myObject.setName("Jasmit Singh");
               myObject.setEmail("singh.jasmit@gmail.com");
               i.putExtra("MyObject", myObject);


               startActivityForResult(i, MY_REQ_CODE);
               break;


           default:

               break;


       }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d(TAG, "onActivityResult()");


        if ((requestCode== MY_REQ_CODE) && (resultCode == RESULT_OK)) {

            // check for data that may have returned from the second activity

            Bundle b = data.getExtras();
            if (b!=null) {
                String msg = b.getString("msg_from_activity_two");
                if (dataView!=null) dataView.setText(msg);

                Fruit myFruit = data.getParcelableExtra("myfruit");

                if (myFruit !=null) {
                    Toast.makeText(this, myFruit.toString(),
                            Toast.LENGTH_SHORT).show();
                }

            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
