package DTO;

public class Course {

    private int CourseID;
    private int DepartmentID;
    private String Title;
    private int Credits;

    public Course() {

    }

    public Course(int CoID, int DeID, String Tit, int Cre) {
        this.CourseID = CoID;
        this.DepartmentID = DeID;
        this.Title = Tit;
        this.Credits = Cre;
    }

    public Object[] toObject() {
        Object[] o = {CourseID, Title, Credits, DepartmentID};
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
}
