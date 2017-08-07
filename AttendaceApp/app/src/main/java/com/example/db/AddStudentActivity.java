package com.example.db;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddStudentActivity extends Activity {
    private EditText nameEt, mobileEt;
    private Button button;
    //private TableData td;
    private String name;
    private String mobile;
    public int RollNumAdded=-1;
    boolean insert ;

    TextView displaymsgs;

    DatabaseHelper dbHelper;
    private StudentDB Std;
    List<StudentDB> AllDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        nameEt= (EditText) findViewById(R.id.et_student_name);
        mobileEt= (EditText) findViewById(R.id.et_student_mobile);
        button= (Button) findViewById(R.id.btn_confirm_add);
        displaymsgs = (TextView)findViewById(R.id.tv_displaymsgs);
        //td=new TableData(this);

        displaymsgs.setText("");

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=nameEt.getText().toString();
                mobile= mobileEt.getText().toString();
                //boolean insert=td.putInformationSTUDENT(name,mobile);
                if(name.length()==0 || mobile.length()==0){
                    Toast.makeText(AddStudentActivity.this,"Insert valid information",Toast.LENGTH_SHORT).show();
                }
                else{
                    insert = AddNewSTUDENT(name,mobile);
                }

                if(insert){
                    Toast.makeText(AddStudentActivity.this,"Success",Toast.LENGTH_SHORT).show();
                    //finish();
                }
            }
        }));

    }

    protected boolean AddNewSTUDENT(String name2, String mobile2) {
        dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
        AllDb = studentDao.queryForAll();
        boolean StudentExist =false;

        for(StudentDB std : AllDb){
            if(std.getName().equals(name2)){
                StudentExist =true;
                displaymsgs.setText("Name : "+name2+" is already exist");

            }
        }

        if(!StudentExist)
        {
            Std = new StudentDB();
            RollNumAdded = AllDb.size()+1;
            Std.setRollnum(RollNumAdded);
            Std.setName(name2);
            Std.setAttendance(0);
            Std.setUpdatedOn("#");
            Std.setMobileNumnber(mobile2);
            studentDao.createIfNotExists(Std);

            displaymsgs.setText("Name : "+name2+" is added on Roll number "+RollNumAdded);
        }

        //At the end release the helper
        OpenHelperManager.releaseHelper();	// TODO Auto-generated method stub
        return !StudentExist;
    }
    public void onStudentConfirm(View view){
        super.onBackPressed();
    }
}