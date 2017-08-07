package com.example.db;

/**
 * Created by Karan on 18-03-2016.
 */
public class Student {
    private long roll;
    private String name;
    private Long mobile;
    Student(long r,String n,Long m){
        roll=r;
        name=n;
        mobile=m;
    }

    public long getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public Long getMobile() {
        return mobile;
    }
}
