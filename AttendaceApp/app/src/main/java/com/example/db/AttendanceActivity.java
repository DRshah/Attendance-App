package com.example.db;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

public class AttendanceActivity extends Activity {

    private TextView date;
    private ListView student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        date= (TextView) findViewById(R.id.tv_date);
        Calendar c=Calendar.getInstance();
        String d= String.valueOf(c.get(Calendar.DATE));

        date.setText(d);
    }
    //list view coding
}

