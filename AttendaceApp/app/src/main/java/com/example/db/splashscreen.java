package com.example.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        int SPLASH_TIME_OUT=3000;

        /*Handler handler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }
        };*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(splashscreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        },SPLASH_TIME_OUT);

}

}
