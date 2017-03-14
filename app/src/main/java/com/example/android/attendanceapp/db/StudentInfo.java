package com.example.android.attendanceapp.db;

/**
 * Created by User on 01-04-2016.
 */
public class StudentInfo {
    String name;
    String mobile;

    public StudentInfo(String mobile, String name) {
        this.mobile = mobile;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
