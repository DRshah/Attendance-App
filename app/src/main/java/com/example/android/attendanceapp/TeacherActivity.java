package com.example.android.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TeacherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
    }
    public void onTakeAttendance(View view){
        Intent intent=new Intent(this,AttendanceActivity.class);
        startActivity(intent);
    }
    public void onCheckRecord(View view){
        Intent intent=new Intent(this,CheckAttendanceActivity.class);
        startActivity(intent);
    }
    public void onLogOut(View view){
        super.onBackPressed();
    }
}
