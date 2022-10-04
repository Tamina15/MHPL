package DTO;

import java.sql.*;

public class Onsite {
	private int CourseID;
	private String Local;
	private String Days;
	private Time Time;
	
	public Onsite() {
		
	}
	
	public Onsite(int CoID, String Local, String Days, Time Time) {
		this.CourseID=CoID;
		this.Local=Local;
		this.Days=Days;
		this.Time=Time;
	}
	
	public int getCourseID() {
		return CourseID;
	}
	
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	
	public String getLocal() {
		return Local;
	}
	
	public void setLocal(String local) {
		Local = local;
	}
	
	public String getDays() {
		return Days;
	}
	
	public void setDays(String days) {
		Days = days;
	}
	
	public Time getTime() {
		return Time;
	}
	
	public void setTime(Time time) {
		Time = time;
	}
}
