/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Tran Minh Nhat
 */
public class Student extends Person {

    public Student() {

    }

    public Student(int id, String lastname, String firstname, Timestamp date) {
        super(id, lastname, firstname, null, date);
    }

    @Override
    public Timestamp getHireDate() {
        return null;
    }

    @Override
    public void setHireDate(Timestamp HireDate) {
        HireDate = null;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + ", " + this.getEnrollmentDate();
    }
}
