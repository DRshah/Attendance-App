package com.example.android.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class CheckAttendanceActivity extends AppCompatActivity {
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_attendance);
        datePicker= (DatePicker) findViewById(R.id.datePicker);
        int dd=datePicker.getDayOfMonth();
        int mm=datePicker.getMonth();
        int yy=datePicker.getYear();
    }
    public void onView(View view){

    }
}
