/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Timestamp;

public class Person {

    private int PersonID;
    private String LastName, FirstName;
    private Timestamp EnrollmentDate, HireDate;

    public Person() {

    }

    public Person(int id, String lastname, String firstname, Timestamp hiredate, Timestamp enrollmentdate) {
        PersonID = id;
        LastName = lastname;
        FirstName = firstname;
        EnrollmentDate = enrollmentdate;
        HireDate = hiredate;
    }

    public Object[] toObject() {
        Object[] o = {PersonID, LastName, FirstName, HireDate, EnrollmentDate};
        return o;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
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

    public Timestamp getEnrollmentDate() {
        return EnrollmentDate;
    }

    public void setEnrollmentDate(Timestamp EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
    }

    public Timestamp getHireDate() {
        return HireDate;
    }

    public void setHireDate(Timestamp HireDate) {
        this.HireDate = HireDate;
    }

    public String getFullName() {
        return FirstName + " " + LastName;
    }

    @Override
    public String toString() {
        return "Person{" + "PersonID=" + PersonID + ", LastName=" + LastName + ", FirstName=" + FirstName + ", EnrollmentDate=" + EnrollmentDate + ", HireDate=" + HireDate + '}';
    }
}
