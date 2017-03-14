package com.example.android.attendanceapp.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 01-04-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //database verson
    public static final int database_version=1;

    //table names
    public static final String DATABASE_NAME = "database_info";
    public static final String TABLE_NAME_TEACHER = "teacher_name";
    public static final String TABLE_NAME_STUDENT="student";

    //teacher colum names
    public static final String COL_ID = "id";
    public static final String TEACHER_USER_NAME = "teacher_user_name";
    public static final String TEACHER_PASS_WORD = "teacher_password";
    public static final String TEACHER_NAME = "teacher_name";

    //student column names
    public static final String ROLL_NO="student_roll_no";
    public static final String STUDENT_NAME="student_name";
    public static final String STUDENT_PHN_NUMBER="student_phn_no";


    //teacher table
    private static final String CREATE_TABLE_TEACHER
            = String.format("create table %s(%s integer not null primary key autoincrement," +
            "%s text not null,%s text null,%s text not null)",TABLE_NAME_TEACHER,COL_ID, TEACHER_USER_NAME,TEACHER_NAME,TEACHER_PASS_WORD);



    //student table
    private static final String CREATE_STUDENT_TABLE=String.format("create table %s(%s integer not null primary key autoincrement,"+
            "%s text not null,%s integer not null",TABLE_NAME_STUDENT,ROLL_NO,STUDENT_NAME,STUDENT_PHN_NUMBER);






    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,database_version);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_TEACHER);
        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }






}
