package com.example.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


	
@DatabaseTable(tableName = "StudentDB")
public class StudentDB {
    @DatabaseField(id = true)
    private int Rollnum;

    @DatabaseField
    private String name;

    @DatabaseField
    private int Attendance;

    @DatabaseField
    private String UpdatedOn;

    @DatabaseField
    private String MobileNumnber;

    public StudentDB() {
        // ORMLite needs a no-arg constructor
    }
    public StudentDB(int Rollnum, String name, int Attendance, String UpdatedOn, String MobileNumnber) {
        super();
        this.Rollnum = Rollnum;
        this.name = name;
        this.Attendance = Attendance;
        this.UpdatedOn = UpdatedOn;
        this.MobileNumnber = MobileNumnber;
    }

    public int getRollnum() {
        return Rollnum;
    }
    public void setRollnum(int Rollnum) {
        this.Rollnum = Rollnum;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAttendance() {
        return Attendance;
    }
    public void setAttendance(int Attendance) {
        this.Attendance = Attendance;
    }

    public String getUpdatedOn() {
        return UpdatedOn;
    }
    public void setUpdatedOn(String UpdatedOn) {
        this.UpdatedOn = UpdatedOn;
    }

    public String getMobileNumnber() {
        return MobileNumnber;
    }
    public void setMobileNumnber(String MobileNumnber) {
        this.MobileNumnber = MobileNumnber;
    }

    @Override
    public String toString() {
        return "StudentDB [Rollnum=" + Rollnum + " name=" + name+ " UpdatedOn=" + UpdatedOn +" Attendance=" + Attendance + " MobileNumnber="+MobileNumnber+"]";
    }

}
