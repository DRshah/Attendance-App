package com.example.db;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class EditStudentActivity extends Activity {
    String editname;
    long editId;
    EditText Etstudent,Etroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Etstudent= (EditText) findViewById(R.id.edit_name);
        Etroll= (EditText) findViewById(R.id.edit_roll);

        editname=getIntent().getExtras().getString("name");
        editId=getIntent().getExtras().getInt("id");
        Etstudent.setText(editname);
        Etroll.setText(""+editId);
    }
}
