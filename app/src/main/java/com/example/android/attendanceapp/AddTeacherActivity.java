package com.example.android.attendanceapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.attendanceapp.db.TableData;

import static android.widget.Toast.LENGTH_SHORT;

public class AddTeacherActivity extends AppCompatActivity {
    private EditText username,name,password;
    private String uname,pword,names;
    //private TableData td;
    private Button button;
    Context context=this;

    TableData td;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);
        td=new TableData(context);
        username= (EditText) findViewById(R.id.et_teacher_username);
        name= (EditText) findViewById(R.id.et_teacher_name);
        password= (EditText) findViewById(R.id.et_teacher_password);
        button= (Button) findViewById(R.id.btn_confirm_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname=username.getText().toString();
                pword=password.getText().toString();
                names=name.getText().toString();

                boolean insert=td.putInformationTEACHER(uname,pword,names);
                if(insert) {
                    Toast.makeText(AddTeacherActivity.this,"success",LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(AddTeacherActivity.this, "ERROR", LENGTH_SHORT).show();
                }
            }
        });

        //td=new TableData(this);
    }
    /*public void onTeacherConfirm(View view){

        boolean insert=td.putInformationTEACHER(uname,pword,names);
        if(insert) {
            Toast.makeText(this, "Add sucess", Toast.LENGTH_SHORT).show();
            finish();
        }
        else
        Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();


    }*/
}
