package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("","","",30);
    }

    public Course(String n, String cid) {
        if(n != "") {
            this.course_name = n;
        }
        else {
            this.course_name = "TBA";
        }
        if(cid != "") {
            this.course_id = cid;
        }
        else {
            this.course_id = "000000";
        }
        this.lecturer = "TBA";
        this.max_students = 30;
    }

    public Course(String n, String cid, String l) {
        if(n != "") {
            this.course_name = n;
        }
        else {
            this.course_name = "TBA";
        }
        if(cid != "") {
            this.course_id = cid;
        }
        else {
            this.course_id = "000000";
        }
        if(l != "") {
            this.lecturer = l;
        }
        else {
            this.lecturer = "TBA";
        }

        this.max_students = 30;
    }

    public Course(String n, String cid, String l, int max) {
        if(n != "") {
            this.course_name = n;
        }
        else {
            this.course_name = "TBA";
        }
        if(cid != "") {
            this.course_id = cid;
        }
        else {
            this.course_id = "000000";
        }
        if(l != "") {
            this.lecturer = l;
        }
        else {
            this.lecturer = "TBA";
        }

        this.max_students = max;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return this.course_id;
    }

    public void setCourse_id(String course_id) {
        if(isValidCourse_id(course_id)) {
            this.course_id = course_id;
        }
    }

    // implement the other get and set methods here
    public String getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer .equalsIgnoreCase("")?lecturer :this.lecturer ;
    }

    public int getMax_students() {
        return this.max_students;
    }

    public void setMax_students(int max_students) {
        if(max_students>=10) {
            this.max_students = max_students;
        }
    }

    public int getNo_students() {
        return this.no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students<this.max_students && no_students>=0) {
            this.no_students = no_students;
        }
    }

    @Override
    public String toString() {
        String o = this.course_name + " ("
                + this.course_id + "), Teacher: "
                + this.lecturer + ", has ";

        if(this.no_students==0) {
            o = o+"NO"+" student, [maximum: "+this.max_students+"]"; ;
        }
        else if(this.no_students==1) {
            o = o+"ONE"+" student, [maximum: "+this.max_students+"]";;
        }
        else {
            o = o+this.no_students+" students, [maximum: "+this.max_students+"]";;
        }
        return o;
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        if(!(m.find()) || id.length()>6) {
            return false;
        }
        else
            return true;
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "\\d{6}";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students=0;
}
