package com.example.db;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;

public class Edit_activity extends Activity implements AdapterView.OnItemClickListener {

    private EditText studentEt;
    private ListView listView;
    private List<StudentDB> students;
    List<String> StdName;
    //ArrayAdapter<String> adapter;

    private StudentsAdapter studentsAdapter;
    // private AttendanceDBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_activity);

        studentEt= (EditText) findViewById(R.id.et_edit_student);
        listView= (ListView) findViewById(R.id.lv_student_edit);
        students=new ArrayList<StudentDB>();
        //adapter=new AttendanceDBAdapter(this);
        //students=adapter.getStudent();

        DatabaseHelper dbHelper = (DatabaseHelper) OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<StudentDB, Integer> studentDao = dbHelper.getStudentExceptionDAo();

        students = studentDao.queryForAll();
        OpenHelperManager.releaseHelper();
        studentsAdapter=new StudentsAdapter(this,students);


        //adapter = new ArrayAdapter<String>(this,
        //android.R.layout.simple_list_item_1, android.R.id.text1,StdName );

        listView.setAdapter(studentsAdapter);
        listView.setOnItemClickListener(this);
        studentEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = studentEt.getText().toString().toLowerCase();
                studentsAdapter.filter(str);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        StudentDB st= (StudentDB) listView.getItemAtPosition(position);
        Intent intent=new Intent(this,EditStudentActivity.class);
        intent.putExtra("name",st.getName());
        intent.putExtra("id",st.getRollnum());
        startActivity(intent);
    }

    class StudentsHolder{
        TextView name, rollnum;
    }
    class StudentsAdapter extends BaseAdapter {
        Context mContext;
        private List<StudentDB> studentlist;
        private ArrayList<StudentDB> arrayList;
        LayoutInflater inflater;

        public StudentsAdapter(Context context,List<StudentDB> studentlist){

            this.studentlist=studentlist;
            mContext=context;
            inflater=LayoutInflater.from(mContext);
            this.arrayList=new ArrayList<StudentDB>();
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
            StudentsHolder holder;
            if (convertView==null){

                convertView=inflater.inflate(R.layout.list_student,null);
                holder=new StudentsHolder();
                holder.name= (TextView) convertView.findViewById(R.id.tv_name);
                holder.rollnum= (TextView) convertView.findViewById(R.id.tv_roll);
                convertView.setTag(holder);
            }
            else {
                holder = (StudentsHolder) convertView.getTag();
            }
            StudentDB s= (StudentDB) getItem(position);
            holder.name.setText(""+s.getName());
            holder.rollnum.setText(""+s.getRollnum());
            return convertView;
        }
        public void filter(String str){
            str=str.toLowerCase();
            studentlist.clear();
            if (str.length()==0){
                studentlist.addAll(arrayList);
            }
            else {
                for(StudentDB st:arrayList){
                    if (st.getName().toLowerCase().contains(str))
                        studentlist.add(st);
                }
            }
            studentsAdapter.notifyDataSetChanged();
        }
    }
}
