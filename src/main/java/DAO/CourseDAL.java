/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Course;
import DTO.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class CourseDAL extends DatabaseManager {

    public CourseDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadCourse() throws SQLException {
        String sql = "select * from course";
        ResultSet rs = this.ExecuteQuery(sql);
        ArrayList<Course> array = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course(rs.getInt(1), rs.getInt(4), rs.getString(2), rs.getInt(3));
            array.add(c);
        }
        return array;
    }

    public int InsertCourse(Course c) throws SQLException {
        String sql = "INSERT INTO course (CourseID, Title, Credits, DepartmentID) VALUES (?,?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, Integer.toString(c.getCourseID()));
        ps.setString(2, c.getTitle());
        ps.setString(3, Integer.toString(c.getCredits()));
        ps.setString(3, Integer.toString(c.getDepartmentID()));
        int result = ps.executeUpdate();
        return result;
    }
    public int DeleteCourse(int courseid) throws SQLException {
        String sql = "DELETE FROM course WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, courseid);
        int result = ps.executeUpdate();
        return result;
    }
    public int UpdateCOurse(Course c) throws SQLException {
        String sql = "UPDATE course SET Title = ?, Credits = ?, DepartmentID = ? WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, c.getTitle());
        ps.setString(2, Integer.toString(c.getCredits()));
        ps.setString(3, Integer.toString(c.getDepartmentID()));
        ps.setInt(4, c.getCourseID());
        int result = ps.executeUpdate();
        return result;
    }
    public ArrayList SearchCourse(String title) throws SQLException {
        String sql = "SELECT * FROM course WHERE Title = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        ArrayList<Course> array = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course(rs.getInt("CourseID"), rs.getInt("DepartmentID"), rs.getString("Title"), rs.getInt("Credits"));
            array.add(c);
        }
        return array;
    }
}
