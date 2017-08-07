package com.example.db;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends Activity {

    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login2);
        username= (EditText) findViewById(R.id.et_admin_username);
        password= (EditText) findViewById((R.id.et_admin_password));
    }

    public void onAdminLogin(View view){
        String uname=username.getText().toString();
        String pword=password.getText().toString();
        if(uname.equals("admin")&&pword.equals("admin")) {
            Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
            Intent intent = new Intent(this, AdminActivity.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(this,"LOGIN UNSUCCESSFUL",Toast.LENGTH_SHORT).show();
        }
    }
}
