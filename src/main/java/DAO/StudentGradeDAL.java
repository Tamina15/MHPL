/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.StudentGrade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class StudentGradeDAL extends DatabaseManager {

    public StudentGradeDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadStudentsGrade() throws SQLException {
        String sql = "SELECT * FROM `studentgrade` WHERE 1";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<StudentGrade> array = new ArrayList<>();
        while (rs.next()) {
            StudentGrade s = new StudentGrade(rs.getInt("EnrollmentID"), rs.getInt("CourseID"), rs.getInt("StudentID"), rs.getFloat("Grade"));
            array.add(s);
        }
        return array;
    }

    public int InsertStudentGrade(StudentGrade s) throws SQLException {
        String sql = "INSERT INTO `studentgrade`(`EnrollmentID`, `CourseID`, `StudentID`, `Grade`) VALUES (?,?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, s.getEnrollmentID());
        ps.setInt(2, s.getCourseID());
        ps.setInt(3, s.getStudentID());
        ps.setFloat(4, s.getGrade());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteStudentGrade(int id) throws SQLException {
        String sql = "DELETE FROM `studentgrade` WHERE  EnrollmentID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateStudentGrade(StudentGrade s) throws SQLException {
        String sql = "UPDATE `studentgrade` SET `CourseID`=?,`StudentID`=?,`Grade`=? WHERE `EnrollmentID`=?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, s.getCourseID());
        ps.setInt(2, s.getStudentID());
        ps.setFloat(3, s.getGrade());
        ps.setInt(4, s.getEnrollmentID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchStudentGrade(String name) throws SQLException {
        String sql = "SELECT * FROM person WHERE concat(Firstname,' ', Lastname) = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        ArrayList<StudentGrade> array = new ArrayList<>();
        while (rs.next()) {
            StudentGrade s = new StudentGrade(rs.getInt("EnrollmentID"), rs.getInt("CourseID"), rs.getInt("StudentID"), rs.getFloat("Grade"));
            array.add(s);
        }
        return array;
    }
}
