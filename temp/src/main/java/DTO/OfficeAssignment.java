package DTO;

import java.sql.*;

public class OfficeAssignment {

    private int InstructorID;
    private String Location;
    private Date Timestamp;

    public OfficeAssignment() {

    }

    public OfficeAssignment(int Ins, String Location, Date Times) {
        this.InstructorID = Ins;
        this.Location = Location;
        this.Timestamp = Times;
    }

    public int getInstructorID() {
        return InstructorID;
    }

    public void setInstructorID(int InstructorID) {
        this.InstructorID = InstructorID;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocationtion(String Location) {
        this.Location = Location;
    }

    public Date getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Date Timestamp) {
        this.Timestamp = Timestamp;
    }

}
