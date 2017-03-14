package com.example.android.attendanceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.attendanceapp.db.TableData;

public class TeacherLoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    //private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        username = (EditText) findViewById(R.id.techer_username);
        password = (EditText) findViewById((R.id.techer_password));

    }
    public void TLogin(View view){
                String uname=username.getText().toString();
                String pword=password.getText().toString();


                    TableData tableData=new TableData(TeacherLoginActivity.this);
                    //tableData.Open();
                    if(tableData.Login(uname,pword))
                    {
                        Toast.makeText(TeacherLoginActivity.this,"LOGGED IN SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(this,TeacherActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(TeacherLoginActivity.this,"USER DOESNT EXISTS",Toast.LENGTH_SHORT).show();
                    }

                    //tableData.Close();

            }
        }


