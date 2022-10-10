/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Instructor;


public class InstructorDAL extends DatabaseManager {
	public InstructorDAL(){
        super();
        ConnectDatabase();
    }

    public ArrayList ReadInstructors() throws SQLException {
        String sql = "select * from Instructor";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Instructor> array = new ArrayList<>();
        while (rs.next()) {
            Instructor d = new Instructor(rs.getInt("CourseID"),rs.getInt("PersonID") );
        }
        return array;
    }

    public int InsertInstructor(Instructor d) throws SQLException {
        String sql = "INSERT INTO CourseInstructor(CourseID,PersonID) VALUES (?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, Integer.toString(d.getCourseID()));
        ps.setString(2, Integer.toString(d.getPersonID()));
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteInstructor(int id) throws SQLException {
        String sql = "DELETE FROM CourseInstructor WHERE PersonID = ? AND CourseID=?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateInstructor(Instructor d) throws SQLException {
        String sql = "UPDATE CourseInstructor SET CourseID=?, PersonID=?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, Integer.toString(d.getCourseID()));
        ps.setString(2, Integer.toString(d.getPersonID()));
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchInstructor(String dname) throws SQLException {
        String sql = "SELECT * FROM CourseInstructor WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, dname);
        ResultSet rs = ps.executeQuery();
        ArrayList<Instructor> array = new ArrayList<>();
        while (rs.next()) {
        	Instructor d = new Instructor(rs.getInt("CourseID"),rs.getInt("PersonID") );
            array.add(d);
        }
        return array;
    }
}
