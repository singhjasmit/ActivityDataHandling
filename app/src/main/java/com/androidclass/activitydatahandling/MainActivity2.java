package com.androidclass.activitydatahandling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView dataView;

    final static String TAG = MainActivity2.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.d(TAG, "onCreate()");


        dataView = (TextView) findViewById(R.id.rec_data);


        Bundle b = getIntent().getExtras();
        if (b!=null) {

            String msg = b.getString("msg_from_activity_one");
            int count = b.getInt("count", -1);

            Toast.makeText(getBaseContext(), "activity one sent: " + msg + " count: "+ count, Toast.LENGTH_SHORT).show();

            if (dataView!=null) {
                dataView.setText(msg);

            }
        }
    }

     @Override
     public void finish() {

         Log.d(TAG, "finish()");

         // return data to the first activity

         Intent i = new Intent();
         i.putExtra("msg_from_activity_two", "I said hello!");
         setResult(RESULT_OK,i);
         super.finish();

     }
}
