package DTO;

import java.sql.Time;

public class Course {

    private int CourseID;
    private String Title;
    private int Credits;
    private int DepartmentID;
    private Online online;
    private Onsite offline;

    public Course() {

    }

    public Course(int CoID, String Tit, int Cre, int DeID) {
        this.CourseID = CoID;
        this.DepartmentID = DeID;
        this.Title = Tit;
        this.Credits = Cre;
    }

    public Course(int CoID, String Tit, int Cre, int DeID, String url) {
        this.CourseID = CoID;
        this.DepartmentID = DeID;
        this.Title = Tit;
        this.Credits = Cre;
        this.online = new Online(CoID, url);
        this.offline = null;
    }

    public Course(int CoID, String Tit, int Cre, int DeID, String location, String days, Time time) {
        this.CourseID = CoID;
        this.DepartmentID = DeID;
        this.Title = Tit;
        this.Credits = Cre;
        this.offline = new Onsite(CoID, location, days, time);
        this.online = null;
    }

    public Object[] toObject() {
        Object[] o = {CourseID, Title, Credits, DepartmentID};
        return o;
    }

    public Object[] toFullObject() {
        Object[] o = {CourseID, Title, Credits, DepartmentID, online.getUrl(), offline.getLocal(), offline.getDays(), offline.getTime()};
        return o;
    }

    public Object[] toOnline() {
        Object[] o = {CourseID, Title, Credits, DepartmentID, online.getUrl()};
        return o;
    }

    public Object[] toOffline() {
        Object[] o = {CourseID, Title, Credits, DepartmentID, offline.getLocal(), offline.getDays(), offline.getTime()};
        return o;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int courseID) {
        CourseID = courseID;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    public Online getOnline() {
        return online;
    }

    public void setOnline(Online online) {
        this.online = online;
    }

    public Onsite getOffline() {
        return offline;
    }

    public void setOffline(Onsite offline) {
        this.offline = offline;
    }

    @Override
    public String toString() {
        return "Course{" + "CourseID=" + CourseID + ", Title=" + Title + ", Credits=" + Credits + ", DepartmentID=" + DepartmentID + '}';
    }

}
