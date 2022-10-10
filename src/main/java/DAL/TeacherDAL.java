/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class TeacherDAL extends DatabaseManager {

    public TeacherDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadTeachers() throws SQLException {
        String sql = "select * from person where HireDate > 0";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Teacher> array = new ArrayList<>();
        while (rs.next()) {
            Teacher t = new Teacher(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), Timestamp.valueOf(rs.getString("HireDate")));
            array.add(t);
        }
        return array;
    }

    public int InsertTeacher(Teacher t) throws SQLException {
        String sql = "INSERT INTO person (FirstName, LastName, HireDate) VALUES (?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, t.getFirstName());
        ps.setString(2, t.getLastName());
        ps.setString(3, t.getEnrollmentDate().toString());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteTeacher(int id) throws SQLException {
        String sql = "DELETE FROM person WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateTeacher(Teacher t) throws SQLException {
        String sql = "UPDATE person SET Lastname = ?, Firstname = ?, HireDate = ? WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, t.getLastName());
        ps.setString(2, t.getLastName());
        ps.setString(3, t.getEnrollmentDate().toString());
        ps.setInt(4, t.getPersonID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchTeacher(String name) throws SQLException {
        String sql = "SELECT * FROM person WHERE concat(Firstname,' ', Lastname) = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        ArrayList<Teacher> array = new ArrayList<>();
        while (rs.next()) {
            Teacher t = new Teacher(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), Timestamp.valueOf(rs.getString("HireDate")));
            array.add(t);
        }
        return array;
    }
}
