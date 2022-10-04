package DTO;

import java.sql.*;

public class Onsite {
	private int CourseID;
	private String Local;
	private Date Days;
	private Date Time;
	
	public Onsite() {
		
	}
	
	public Onsite(int CoID, String Local, Date Days, Date Time) {
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
	
	public Date getDays() {
		return Days;
	}
	
	public void setDays(Date days) {
		Days = days;
	}
	
	public Date getTime() {
		return Time;
	}
	
	public void setTime(Date time) {
		Time = time;
	}
}
