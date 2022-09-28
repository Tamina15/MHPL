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
public class Teacher extends Person {

    public Teacher() {

    }

    public Teacher(int id, String lastname, String firstname, Date date) {
        super(id, lastname, firstname, date, null);
    }

    @Override
    public Date getEnrollmentDate() {
        return null;
    }

    @Override
    public void setEnrollmentDate(Date HireDate) {
        HireDate = null;
    }
}