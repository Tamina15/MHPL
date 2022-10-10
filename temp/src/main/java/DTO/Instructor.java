package DTO;

public class Instructor {
	
	private int CourseID;
	private int PersonID;
	
	public Instructor() {
		
	}
	
	public Instructor(int CoID, int PerID) {
		this.CourseID=CoID;
		this.PersonID=PerID;
	}
	
	public int getCourseID() {
		return CourseID;
	}
	
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	
	public int getPersonID() {
		return PersonID;
	}
	
	public void setPersonID(int personID) {
		PersonID = personID;
	}
}
