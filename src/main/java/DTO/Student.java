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
public class Student extends Person {

    public Student() {

    }

    public Student(int id, String lastname, String firstname, Date date) {
        super(id, lastname, firstname, null, date);
    }

    @Override
    public Date getHireDate() {
        return null;
    }

    @Override
    public void setHireDate(Date HireDate) {
        HireDate = null;
    }
}
