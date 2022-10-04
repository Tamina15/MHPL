package DTO;

public class Online {
	
	private int CourseID;
	private String Url;
	
	public Online() {
		
	}
	
	public Online(int CoID, String Url) {
		this.CourseID=CoID;
		this.Url=Url;
	}
	
	public int getCourseID() {
		return CourseID;
	}
	
	public void setCourseID(int courseID) {
		CourseID = courseID;
	}
	
	public String getUrl() {
		return Url;
	}
	
	public void setUrl(String url) {
		Url = url;
	}
}
