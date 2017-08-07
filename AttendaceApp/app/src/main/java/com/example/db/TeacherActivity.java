package com.example.db;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.UpdateBuilder;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TeacherActivity extends Activity {

	int ctr,c;
	TextView totalStudent;
	TextView Name;
	TextView RollNum;
	int TotalStudent=0;
	int CurrentRolNum=0;
	String _date=null;
	
	//DatabaseHelper dbHelper;
	private StudentDB Std;
	private ArrayList<StudentDB> Students;
	List<StudentDB> AllDb;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        totalStudent = (TextView) findViewById(R.id.tv_toalcount);
        Name = (TextView) findViewById(R.id.tv_name);
        RollNum = (TextView) findViewById(R.id.tv_rollnum);
        
        //Take todays date
        _date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        System.out.println(_date);
        DatabaseHelper dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
						//studentDao.createIfNotExists(arg0)
		Students= new ArrayList<StudentDB>();
		//Std = new StudentDB();	
		//Queryy
		AllDb = studentDao.queryForAll();//return all the db
		String firstName = AllDb.get(0).getName();
		int FirstRollNum = AllDb.get(0).getRollnum();
		Name.setText(firstName);
		RollNum.setText(Integer.toString(FirstRollNum));
		
		
		System.out.println("--total size- "+AllDb.size());
		TotalStudent = AllDb.size();
		totalStudent.setText(Integer.toString(TotalStudent));			
		//At the end release the helper
		OpenHelperManager.releaseHelper();	// TODO Auto-generated method stub
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.teacher_menu, menu);
		return true;
	}
    public void onTakeAttendance(View view){
    
    	
    	for(StudentDB std : AllDb){
    		
    	}
    	
    }
   
    public void onCheckRecord(MenuItem m){
        Intent intent=new Intent(this,CheckAttendanceActivity.class);
        startActivity(intent);
    }
    

    
    public void onPresent(View view){
		//int f=Count();
    	if(CurrentRolNum<TotalStudent){
    		UpdateDb(CurrentRolNum,1);

    	}
    	else{

    		CurrentRolNum=0;
    	}
    	
    }
    
    public void onStdRecord(MenuItem m){
    	  Intent intent=new Intent(this,CheckAttendanceActivityStd.class);
          startActivity(intent);
    	
    }
    
    
	public void onAbsent(View view){
		//int f=Count();
		if(CurrentRolNum<TotalStudent){
			UpdateDb(CurrentRolNum,0);
    	}
    	else{
    		CurrentRolNum=0;
    	}
    	
    
    }
	private void UpdateDb(int RolNum, int i) {
		
		//Open Databse
    	DatabaseHelper dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
        studentDao = dbHelper.getStudentExceptionDAo();
        
        //Get current Student to update using rollenumber
        StudentDB _Std = AllDb.get(RolNum);
        
        if(!AllDb.get(RolNum).getUpdatedOn().contains(_date)){
        	
        	if(i==1){
				//Count();
        	//Set the date to inert in  UpdatedOn string
            _Std.setUpdatedOn(AllDb.get(RolNum).getUpdatedOn()+_date+"#");
            //Increase the attendance and updated on field
            _Std.setAttendance(AllDb.get(RolNum).getAttendance()+i);
				c=_Std.getAttendance()+i;
            //update the database
    		studentDao.update(_Std);
        	}
    		
        }
        else if(i==0){
			//ctr=c;
			//c=c+1;
			//_Std.setNoAttendence(c);
        	Toast.makeText(this, "Already updated today", Toast.LENGTH_SHORT).show();
        }
      
		//Close the helper
		OpenHelperManager.releaseHelper();
		
		
		CurrentRolNum++;
		if(CurrentRolNum>=TotalStudent){
			CurrentRolNum=0;
			Toast.makeText(this, "Finished taking attendance", Toast.LENGTH_SHORT).show();
     	}
    	System.out.println(" --CurrentRolNum "+CurrentRolNum);
		Name.setText(AllDb.get(CurrentRolNum).getName());
		RollNum.setText(Integer.toString(AllDb.get(CurrentRolNum).getRollnum()));
		
	}

	public void onDefList(MenuItem m){
		Intent intent=new Intent(this,LessAttendenceActivity.class);
		startActivity(intent);
	}
    
    public void onLogOut(MenuItem m){
        super.onBackPressed();
    	/*DatabaseHelper l_dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
    	RuntimeExceptionDao<StudentDB, Integer> l_studentDao = l_dbHelper.getStudentExceptionDAo();
  		//Queryy
    	List<StudentDB> l_AllDb = l_studentDao.queryForAll();
    	System.out.println("---"+l_AllDb.toString());
    	OpenHelperManager.releaseHelper();	// TODO Auto-generated method stub*/
    }

	public void Count(){

		ctr++;
		//CheckAttendanceActivityStd c=new CheckAttendanceActivityStd();
		//c.Counter(ctr);

	}
}
