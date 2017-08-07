package com.example.db;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	DatabaseHelper dbHelper;
	private StudentDB Std;
	private ArrayList<StudentDB> Students;

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFreshDB();
    }
    public void onTeacher(View view){
        Intent intent=new Intent(this,TeacherLoginActivity.class);
        startActivity(intent);
    }
    public void onAdmin(View view){
        Intent intent=new Intent(this,AdminLoginActivity.class);
        startActivity(intent);
    }
    

	private void createFreshDB() {
		// TODO Auto-generated method stub
	dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
	RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
					
					//studentDao.createIfNotExists(arg0)
	//Students= new ArrayList<StudentDB>();
	//Std = new StudentDB();
	
	//for(int i=0;i<=0;i++) {
			//Std = new StudentDB();
			//Std.setRollnum(Std.getRollnum());
	//		Std.setName("");
	//		Std.setAttendance(0);
	//		Std.setUpdatedOn("#");
	//		studentDao.createIfNotExists(Std);

	//}
					
	//At the end release the helper
	OpenHelperManager.releaseHelper();	// TODO Auto-generated method stub
	
}
	
}
