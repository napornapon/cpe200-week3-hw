package cpe200;

import jdk.internal.util.xml.impl.Input;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    protected static final String DEFAULT_Name = "John Doe";
    protected static final String DEFAULT_ID = "560610000";
    protected static final int DEFAULT_YOB = 1990;
    protected static final boolean DEFAULT_Stat = false;
    protected String St_Name;
    protected String St_ID;
    protected int St_YOB;
    protected boolean St_Stat;

    public Student() {
        St_Name = DEFAULT_Name;
        St_ID = DEFAULT_ID;
        St_YOB = DEFAULT_YOB;
        St_Stat = DEFAULT_Stat;
    }

    public Student(String Name, String Stud_Id) {
        St_Name = Name;
        if(isValidStudent_id(Stud_Id)) {
            St_ID = Stud_Id;
        }
        else {
            St_ID = DEFAULT_ID;
        }
        St_YOB = DEFAULT_YOB;
        St_Stat = DEFAULT_Stat;
    }

    public Student(String Name, String Stud_Id, int YOB) {
        St_Name = Name;
        if(isValidStudent_id(Stud_Id)) {
            St_ID = Stud_Id;
        }
        else {
            St_ID = DEFAULT_ID;
        }
        if(isValidYOB(YOB)) {
            St_YOB = YOB;
        }
        else {
            St_YOB = DEFAULT_YOB;
        }
        St_Stat = DEFAULT_Stat;
    }

    public Student(String Name, String Stud_Id, int YOB, boolean Status) {
        St_Name = Name;
        if(isValidStudent_id(Stud_Id)) {
            St_ID = Stud_Id;
        }
        else {
            St_ID = DEFAULT_ID;
        }
        if(isValidYOB(YOB)) {
            St_YOB = YOB;
        }
        else {
            St_YOB = DEFAULT_YOB;
        }
        St_Stat = Status;
    }

    private boolean isValidStudent_id(String id) {
       if(id.length()>9 || id.charAt(0)!='5') {
            return false;
       }
        int inte_ID = Integer.parseInt(id);
        int X=inte_ID/10000000, P=(inte_ID/1000)%10, N=inte_ID%1000;
        if(X>=56 && X<=59 && P>=0 && P<=2 && N>=0 && N<=999 && inte_ID<=590612999) {
            return true;
        }
        else
            return false;
    }

    private boolean isValidYOB(int yob) {

        if(yob < 1989) {
            return false;
        }
        else
            return true;
    }

    public String getName() {
        return St_Name;
    }

    public String getStudent_id() {
        return St_ID;
    }

    public int getYearOfBirth() {
        return St_YOB;
    }

    public boolean isActive() {
        return St_Stat;
    }

    public void setName(String Input_name) {
        if(Input_name != "") {
            St_Name = Input_name;
        }
    }

    public void setStudent_id(String Input_ID) {
        if(isValidStudent_id(Input_ID)) {
            St_ID = Input_ID;
        }
    }

    public void setYearOfBirth(int Input_YOB) {
        if(isValidYOB(Input_YOB)) {
            St_YOB = Input_YOB;
        }

    }

    @Override
    public String toString() {

        String stg_stat;
        if(St_Stat) {
            stg_stat = "ACTIVE";
        }
        else {
            stg_stat = "INACTIVE";
        }
        String o = St_Name+" ("+St_ID+") was born in "+St_YOB+" is an "+stg_stat+" student.";
        return o;
    }

}
