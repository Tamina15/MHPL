/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

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
        String sql = "SELECT * FROM courseinstructor WHERE 1";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Instructor> array = new ArrayList<>();
        while (rs.next()) {
            Instructor d = new Instructor(rs.getInt("CourseID"),rs.getInt("PersonID") );
        }
        return array;
    }

    public int InsertInstructor(Instructor d) throws SQLException {
        String sql = "INSERT INTO courseinstructor(CourseID, PersonID) VALUES (?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, Integer.toString(d.getCourseID()));
        ps.setString(2, Integer.toString(d.getPersonID()));
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteInstructor(int personid) throws SQLException {
        String sql = "DELETE FROM courseinstructor WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, personid);
        int result = ps.executeUpdate();
        return result;
    }
    public int DeleteCourse(int courseid) throws SQLException {
        String sql = "DELETE FROM courseinstructor WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, courseid);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateInstructor(Instructor old, Instructor newI) throws SQLException {
        String sql = "UPDATE courseinstructor SET CourseID=?,PersonID=? WHERE CourseID=?,PersonID=?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, old.getCourseID());
        ps.setInt(2, old.getPersonID());
        ps.setInt(3, newI.getCourseID());
        ps.setInt(4, newI.getPersonID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchInstructor(String dname) throws SQLException {
        String sql = "SELECT * FROM courseinstructor WHERE PersonID = ?";
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
