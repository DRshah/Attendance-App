package com.example.db;

import java.sql.SQLException;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

	private static final String DATABASE_NAME = "notes.db";
	private static final int DATABASE_VERSION = 1;

	private Dao<StudentDB, Integer> studentDao = null;
	private RuntimeExceptionDao<StudentDB, Integer> studentRuntimeDAo = null;

	public DatabaseHelper(Context context){
		super(context,DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		// TODO Auto-generated method stub

		try {
			TableUtils.createTable(connectionSource, StudentDB.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@Override
	public void onUpgrade(SQLiteDatabase databse, ConnectionSource connectionSource, int arg2,
						  int arg3) {
		// TODO Auto-generated method stub

		try {
			TableUtils.dropTable(connectionSource, StudentDB.class, true);
			onCreate(databse,connectionSource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Dao<StudentDB, Integer> getDao() throws SQLException{
		if(studentDao==null){
			studentDao = getDao(StudentDB.class);
		}

		return studentDao;
	}


	public RuntimeExceptionDao<StudentDB, Integer> getStudentExceptionDAo(){
		if(studentRuntimeDAo==null){
			studentRuntimeDAo = getRuntimeExceptionDao(StudentDB.class);
		}
		return studentRuntimeDAo;
	}


}
