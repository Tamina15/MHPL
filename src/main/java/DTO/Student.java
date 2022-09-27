/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Tran Minh Nhat
 */
public class Student {

    private int StudentID;
    private String LastName, FirstName;
    private Date EnrollmentDate;

    public Student() {

    }

    public Student(int id, String lastname, String firstname, Date date) {
        StudentID = id;
        LastName = lastname;
        FirstName = firstname;
        EnrollmentDate = date;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public Date getEnrollmentDate() {
        return EnrollmentDate;
    }

    public void setEnrollmentDate(Date EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
    }

    public String getFullName() {
        return FirstName + " " + LastName;
    }
}
