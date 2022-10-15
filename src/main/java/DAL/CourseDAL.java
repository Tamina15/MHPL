/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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
        String sql = "SELECT * FROM course";
        ResultSet rs = this.ExecuteQuery(sql);
        ArrayList<Course> array = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"));
            array.add(c);
        }
        return array;
    }

    public ArrayList<Course> ReadOnlineCourse() throws SQLException {
        String sql = "SELECT * FROM course,onlinecourse WHERE course.CourseID = onlinecourse.CourseID";
        ResultSet rs = this.ExecuteQuery(sql);
        ArrayList<Course> array = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"), rs.getString("url"));
            array.add(c);
        }
        return array;
    }

    public ArrayList<Course> ReadOfflineCourse() throws SQLException {
        String sql = "SELECT * FROM course,onsitecourse WHERE course.CourseID = onsitecourse.CourseID";
        ResultSet rs = this.ExecuteQuery(sql);
        ArrayList<Course> array = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"), rs.getString("Location"), rs.getString("Days"), Time.valueOf(rs.getString("Time")));
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
        ps.setString(4, Integer.toString(c.getDepartmentID()));
        int result = ps.executeUpdate();
        return result;
    }

    public void InsertOnlineCourse(Course c) throws SQLException {
        InsertCourse(c);
        new OnlineDAL().InsertOnline(c.getOnline());
    }

    public void InsertOfflineCourse(Course c) throws SQLException {
        InsertCourse(c);
        new OnsiteDAL().InsertOnsite(c.getOffline());
    }

    public int DeleteCourse(int courseid) throws SQLException {
        new OnsiteDAL().DeleteOnsite(courseid);
        new OnlineDAL().DeleteOnline(courseid);
        String sql = "DELETE FROM course WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, courseid);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateCourse(Course c) throws SQLException {
        String sql = "UPDATE course SET Title = ?, Credits = ?, DepartmentID = ? WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, c.getTitle());
        ps.setString(2, Integer.toString(c.getCredits()));
        ps.setString(3, Integer.toString(c.getDepartmentID()));
        ps.setInt(4, c.getCourseID());
        int result = ps.executeUpdate();
        return result;
    }

    public void UpdateOnlineCourse(Course c) throws SQLException {
        new OnlineDAL().UpdateOnline(c.getOnline());
        UpdateCourse(c);
    }

    public void UpdateOfflineCourse(Course c) throws SQLException {
        new OnsiteDAL().UpdateOnsite(c.getOffline());
        UpdateCourse(c);
    }

    public ArrayList SearchCourse(String title) throws SQLException {
        String sql = "SELECT * FROM course WHERE Title = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, title);
        ResultSet rs = ps.executeQuery();
        ArrayList<Course> array = new ArrayList<>();
        while (rs.next()) {
            Course c = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"));
            array.add(c);
        }
        return array;
    }

}
