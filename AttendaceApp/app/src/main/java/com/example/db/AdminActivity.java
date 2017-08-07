package com.example.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AdminActivity extends Activity {

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
        Toast.makeText(this,"Server connectivity name id needed",Toast.LENGTH_LONG).show();

    }
    public void onLogOut(View view){
        super.onBackPressed();
    }
}
