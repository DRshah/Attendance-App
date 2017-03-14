package com.example.android.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

    }


    public void addTeacher(View view){
        Intent intent=new Intent(this,AddTeacherActivity.class);
        startActivity(intent);

    }

    public void addStudent(View view){

        Intent intent=new Intent(this,AddStudentActivity.class);
        startActivity(intent);
    }
}
