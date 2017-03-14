package com.example.android.attendanceapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by User on 01-04-2016.
 */
public class TableData {

        public static final int database_version=1;
        public static final String TEACHER_USER_NAME = "teacher_user_name";
        public static final String TEACHER_PASS_WORD = "teacher_password";
        public static final String TEACHER_NAME = "teacher_name";
        public static final String DATABASE_NAME = "database_info";
        public static final String TABLE_NAME_TEACHER = "teacher_name";
        public static final String COL_ID = "id";
        public static final String ROLL_NO="student_roll_no";
        public static final String STUDENT_NAME="student_name";
        public static final String STUDENT_PHN_NUMBER="student_phn_no";
        public static final String TABLE_NAME_STUDENT="student";



    private static final String CREATE_TABLE_TEACHER
            = String.format("create table %s(%s integer not null primary key autoincrement," +
            "%s text not null,%s text null,%s text not null)",TABLE_NAME_TEACHER,COL_ID, TEACHER_USER_NAME,TEACHER_NAME,TEACHER_PASS_WORD);

    private static final String CREATE_STUDENT_TABLE=String.format("create table %s(%s integer not null primary key autoincrement,"+
            "%s text not null,%s integer not null)",TABLE_NAME_STUDENT,ROLL_NO,STUDENT_NAME,STUDENT_PHN_NUMBER);


    private SQLiteDatabase db;

    private DatabaseOperations d;


    public TableData(Context context){
        DatabaseOperations dob=new DatabaseOperations(context);
        db=dob.getWritableDatabase();
    }
    public void Open()throws SQLiteException{
        db=d.getWritableDatabase();
    }

    public TableData(){

    }

    //PUTTING STUDENTS INFO
    public boolean putInformationSTUDENT(String name,int phn_number){
        // SQLiteDatabase db=dob.getWritableDatabase();
        ContentValues values=new ContentValues();
        //values.put(ROLL_NO,roll_no);
        values.put(STUDENT_NAME,name);
        values.put(STUDENT_PHN_NUMBER,phn_number);

        long id=db.insert(TABLE_NAME_STUDENT,null,values);
        //Log.d("databse operations","one row inserted");
        if(id==-1){
            return false;
        }
        return true;
    }



    //PUTTING TEACHER INFO
    public boolean putInformationTEACHER(String username,String password,String name){
       // SQLiteDatabase db=dob.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TEACHER_USER_NAME,username);
        values.put(TEACHER_PASS_WORD,password);
        values.put(TEACHER_NAME,name);
        //values.put(TEACHER_USER_NAME,username);
        //values.put(TEACHER_PASS_WORD,password);
        //values.put(TEACHER_NAME,name);

        long id=db.insert(TABLE_NAME_TEACHER,null,values);
        Log.d("databse operations","one row inserted");
        if(id==-1){
            return false;
        }
        return true;
    }



    public boolean Login(String username, String password) throws SQLiteException
    {
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME_TEACHER + " WHERE teacher_user_name=? AND teacher_password=?", new String[]{username, password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }
    public void Close(){
        d.close();
    }






    class DatabaseOperations extends SQLiteOpenHelper {
        //public static final int database_version = 1;

        public DatabaseOperations(Context context) {
            super(context, DATABASE_NAME, null, database_version);
            //.d("DATABSE operations", "database created");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(CREATE_TABLE_TEACHER);
            db.execSQL(CREATE_STUDENT_TABLE);
            //Log.d("DATABSE operations", "table created created");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        //public void putInformation(TableData tableData,){

//        }
    }
}