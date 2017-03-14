package com.example.android.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void onAdd(View view){
        Intent intent=new Intent(this,AddActivity.class);
        startActivity(intent);
    }
    public void onEdit(View view){
        Intent intent=new Intent(this,Edit_activity.class);
        startActivity(intent);
    }
    public void onBackup(View view){

    }
    public void onLogout(View view){
        super.onBackPressed();
    }
}
