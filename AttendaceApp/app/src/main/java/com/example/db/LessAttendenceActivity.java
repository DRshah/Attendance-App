package com.example.db;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class LessAttendenceActivity extends Activity {


    List<StudentDB> defaulters;
    List<StudentDB> AllDb;
    ListView listView;
    List<String> StdName;
    private StudentsAdapter2 studentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_less_attendence);
        listView = (ListView) findViewById(R.id.list_std);



        DatabaseHelper dbHelper = (DatabaseHelper) OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();
        AllDb = studentDao.queryForAll();
        OpenHelperManager.releaseHelper();
        defaulters=new ArrayList<StudentDB>();
        StdName = new ArrayList<String>();
        SetViewStdRec();
        studentsAdapter=new StudentsAdapter2(this,defaulters);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, StdName);


        // Assign adapter to ListView
        listView.setAdapter(studentsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                StudentDB itemValue = (StudentDB) listView.getItemAtPosition(position);
                for (StudentDB std : AllDb) {
                    if (std.getName().equals(itemValue.getName())) {
                        System.out.println(" -- calling" + std.getMobileNumnber()+itemValue.getName());
                        Intent callIntent = new Intent();
                        callIntent.setAction(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:" + std.getMobileNumnber()));
                    }
                }

            }

        });
        // ListView Item Click Listener
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                StudentDB itemValue = (StudentDB) listView.getItemAtPosition(position);
                for (StudentDB std : defaulters) {
                    if (std.getName().equals(itemValue)) {
                        System.out.println(" -- calling" + itemValue.getMobileNumnber());
                        Intent callIntent = new Intent();
                        callIntent.setAction(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:" + itemValue.getMobileNumnber()));
                        startActivity(callIntent);
                    }
                }*/
                         /*
                        String mobile = superHero.getMobile();
        String strUri = "tel:" + mobile;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse(strUri));
        startActivity(intent);
                        * */



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

    public void SetViewStdRec() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 2) {
            Toast.makeText(this, "List to be displayed at the end of the week", Toast.LENGTH_SHORT).show();
            //StdName.add("List to be displayed at the end of the week");
            StdName.clear();
            super.onBackPressed();

        } else if (day == 1) {
            for (StudentDB std : AllDb) {
                if (std.getAttendance() < 2) {
                    System.out.println("Name:" + std.getName() + "\nSap Id:" + std.getRollnum() + "\t\t\t\t\t\t" + std.getAttendance());
                    defaulters.add(std);
                }
            }

        } else {

            Toast.makeText(this, "List to be displayed at the end of the week", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
            //StdName.add("List to be displayed at the end of the week.");
        }
        //Toast.makeText(this, "Please enter Roll number", Toast.LENGTH_SHORT).show();

    }


    public void onView(View view) {

    }
    class StudentsHolder2{
        TextView name, rollnum,attendance;
    }

    class StudentsAdapter2 extends BaseAdapter {
        Context mContext;
        private List<StudentDB> studentlist;
        private ArrayList<StudentDB> arrayList;
        LayoutInflater inflater;

        public StudentsAdapter2(Context context, List<StudentDB> studentlist) {

            this.studentlist = studentlist;
            mContext = context;
            inflater = LayoutInflater.from(mContext);
            this.arrayList = new ArrayList<StudentDB>();
            this.arrayList.addAll(studentlist);
        }


        @Override
        public int getCount() {
            return studentlist.size();
        }

        @Override
        public Object getItem(int position) {
            return studentlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
             StudentsHolder2 holder;
            if (convertView == null) {

                convertView = inflater.inflate(R.layout.list_defauters, null);
                holder = new StudentsHolder2();
                holder.name = (TextView) convertView.findViewById(R.id.tv_defaulter_name);
                holder.rollnum = (TextView) convertView.findViewById(R.id.tv_defaulterroll);
                holder.attendance= (TextView) convertView.findViewById(R.id.tv_defaulter_att);
                convertView.setTag(holder);
            } else {
                holder = (StudentsHolder2) convertView.getTag();
            }
            StudentDB s = (StudentDB) getItem(position);
            holder.name.setText("" + s.getName());
            holder.rollnum.setText("" + s.getRollnum());
            holder.attendance.setText(""+s.getAttendance());
            return convertView;
        }
    }
}