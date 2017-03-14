package com.example.android.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {
    private EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        username= (EditText) findViewById(R.id.et_admin_username);
        password= (EditText) findViewById(R.id.et_admin_password);
    }
    public void onAdminLogin(View view){
        String uname=username.getText().toString();
        String pword=password.getText().toString();
        if(uname.equals("admin")&&pword.equals("admin")) {
            Toast.makeText(this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(this,"LOGIN UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
        }
    }
}