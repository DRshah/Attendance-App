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

public class CheckAttendanceActivity extends Activity {
    private DatePicker dp;
  //DatabaseHelper dbHelper;
  	List<StudentDB> AllDb;
  	TextView total;
  	TextView present;
  	TextView absent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_attendance);
        total = (TextView) findViewById(R.id.tv_total);
        present = (TextView) findViewById(R.id.tv_present);    
        absent = (TextView) findViewById(R.id.tv_absent);
        dp= (DatePicker) findViewById(R.id.datePicker);
        //int dd=dp.getDayOfMonth();
        //int mm=dp.getMonth();
        //int yy=dp.getYear();
        DatabaseHelper dbHelper = (DatabaseHelper)OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
        AllDb = studentDao.queryForAll();
        OpenHelperManager.releaseHelper();
        
        total.setText(Integer.toString(AllDb.size()));
        dp.init(dp.getYear(), dp.getMonth(), dp.getDayOfMonth(),new OnDateChangedListener() {
        	   
        	   @Override
        	   public void onDateChanged(DatePicker arg0, int year, int month, int date) {
        	    // TODO Auto-generated method stub
        		   String month_ = null;
        		   String date_ = null;
        		   if((month+1)<10){
        			   month_ = "0"+Integer.toString(month+1);
        		   }else{
        			   month_ = Integer.toString(month+1);
        		   }
        		   
        		   if(date < 10){
        			   date_ = "0"+Integer.toString(date);
        		   }else{
        			   date_ = Integer.toString(date);
        		   }
        		   
        		   String dateToCheck = year+"-"+month_+"-"+date_;
        		   showRecordByDate(dateToCheck);
        		  
        	   }
        	  } );
    }
    
    protected void showRecordByDate(String date) {
    	int Counter = 0;
    	 for(StudentDB std : AllDb){
			   String datelist = std.getUpdatedOn();
	    		if(datelist.contains(date)){
	    			Counter++;//+1
	    		}
	    	}
    	 present.setText(Integer.toString(Counter));
    	 absent.setText(Integer.toString(AllDb.size()-Counter));
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
    
	public void onView(View view){

    }
}
