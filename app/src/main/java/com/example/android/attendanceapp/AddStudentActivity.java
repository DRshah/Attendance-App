package com.example.android.attendanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.android.attendanceapp.db.AttendanceDBAdapter;
import com.example.android.attendanceapp.db.TableData;

public class AddStudentActivity extends AppCompatActivity {
    private EditText nameEt, mobileEt;
    private Button button;
    private TableData td;
    private String name;
    private int mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        nameEt= (EditText) findViewById(R.id.et_student_name);
        mobileEt= (EditText) findViewById(R.id.et_student_mobile);
        button= (Button) findViewById(R.id.btn_confirm_add);
        td=new TableData(this);
        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             name=nameEt.getText().toString();
             mobile= Integer.parseInt(mobileEt.getText().toString());
             boolean insert=td.putInformationSTUDENT(name,mobile);
                if(insert){
                    Toast.makeText(AddStudentActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else
                    Toast.makeText(AddStudentActivity.this,"error",Toast.LENGTH_SHORT).show();

            }
        }));

    }
}