/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.StudentDAL;
import DTO.Student;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class StudentBLL {

    StudentDAL studentDAL;
    ArrayList<Student> students;

    public StudentBLL() {
        studentDAL = new StudentDAL();
        students =  new ArrayList<>();
    }
    
    public ArrayList<Student> ReadStudent() throws SQLException {
       return studentDAL.ReadStudents();
    }

    public int AddStudent(Student s) throws SQLException {
        return studentDAL.InsertStudent(s);
    }

    public String[] RemoveStudent() {
        String[] string = null;
        return string;

    }

    public String[] UpdateStudent() {
        String[] string = null;
        return string;

    }

    public String[] SearchStudent() {
        String[] string = null;
        return string;

    }
}
