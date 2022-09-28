/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Teacher;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class TeacherDAL extends DatabaseManager{
    Date d;

    public TeacherDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadTeachers() throws SQLException {
        String sql = "select * from person where HireDate > 0";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Teacher> array = new ArrayList<>();
        while (rs.next()) {
            Teacher s = new Teacher(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), Date.valueOf(rs.getString("HireDate")));
            array.add(s);
        }
        return array;
    }

    public int InsertTeacher(Teacher s) throws SQLException {
        String sql = "INSERT INTO person (FirstName, LastName, HireDate) VALUES (?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getFirstName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getHireDate().toString());
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

    public int UpdateTeacher(Teacher s) throws SQLException {
        String sql = "UPDATE person SET Lastname = ?, Firstname = ?, HireDate = ? WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getLastName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getHireDate().toString());
        ps.setInt(4, s.getPersonID());
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
            Teacher s = new Teacher(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), Date.valueOf(rs.getString("HireDate")));
            array.add(s);
        }
        return array;
    }
}

