package com.example.android.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onTeacher(View view){
        Intent intent=new Intent(this,TeacherLoginActivity.class);
        startActivity(intent);
    }
    public void onAdmin(View view){
        Intent intent=new Intent(this,AdminLoginActivity.class);
        startActivity(intent);
    }
}
