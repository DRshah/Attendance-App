package com.example.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckAttendanceActivityStd extends Activity {

	int c;
  	List<StudentDB> AllDb;
  	TextView presentdated;
  	TextView StdInfo;  	
  	EditText Rollnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_attendance_std);
        StdInfo = (TextView) findViewById(R.id.tv_StdInfo);
        presentdated = (TextView) findViewById(R.id.tv_presentDAtes); 
        Rollnum = (EditText) findViewById(R.id.et_rollnum);
        StdInfo.setText("");
        presentdated.setText("");

        DatabaseHelper dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
        AllDb = studentDao.queryForAll();
        OpenHelperManager.releaseHelper();
      }

    
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }






    public void onViewStdRec(View view){
    	  StdInfo.setText("");
    	  presentdated.setText("");
    	  hideKeyboard(this);
    	boolean recordFound = false;
    	if(!Rollnum.getText().toString().isEmpty()){
    		int EnterNum = Integer.valueOf(Rollnum.getText().toString());
    		
    		for(StudentDB std : AllDb){
        		if(std.getRollnum()==EnterNum){
        			System.out.println("Record found");
        			System.out.println(std.toString());
        			String AllDates = std.getUpdatedOn();
        			AllDates = AllDates.substring(1, AllDates.length());
        			List<String> elephantList = Arrays.asList(AllDates.split("#"));
					//TeacherActivity teacherActivity=new TeacherActivity();

					//StudentDB studentDB=new StudentDB();
					//c=studentDB.getNoAttendence();
        			  StdInfo.setText("Name : "+std.getName()+"      Total attendance "+std.getAttendance()+"/");
        			  presentdated.setText(" Present on "+elephantList.toString());
        			  System.out.println(elephantList.toString());
        		
        			recordFound = true;
        		}
        	}
    		
    		if(!recordFound){
        		Toast.makeText(this, "Roll number dosen't exist", Toast.LENGTH_SHORT).show();
        	}
    	}
    	else{
    		Toast.makeText(this, "Please enter Roll number", Toast.LENGTH_SHORT).show();
    	}
    	
    	
    	
    }
    
    
	public void onView(View view){

    }
}
