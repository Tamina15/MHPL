package DTO;

public class Instructor {

    private int CourseID;
    private int PersonID;
    private String courseName, personName;

    public Instructor() {

    }

    public Instructor(int CourseID, int PersonID) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }

    public Instructor(int CourseID, int PersonID, String courseName, String personName) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.courseName = courseName;
        this.personName = personName;
    }

    public int getCourseID() {
        return CourseID;
    }

    public Object[] toObject() {
        return new Object[]{CourseID, courseName, PersonID, personName};
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Instructor{" + "CourseID=" + CourseID + ", PersonID=" + PersonID + '}';
    }

}
