/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Onsite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class OnsiteDAL extends DatabaseManager {

    public OnsiteDAL() {
        super();
        ConnectDatabase();
    }
    public ArrayList ReadOnsites() throws SQLException {
        String sql = "SELECT * FROM onsitecourse WHERE 1";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Onsite> array = new ArrayList<>();
        while (rs.next()) {
            Onsite off = new Onsite(rs.getInt("CourseID"), rs.getString("Location"), rs.getString("Date"), Time.valueOf(rs.getString("Time")));
            array.add(off);
        }
        return array;
    }

    public int InsertOnsite(Onsite off) throws SQLException {
        String sql = "INSERT INTO onsitecourse (CourseID, Location, Days, Time) VALUES (?,?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, off.getCourseID());
        ps.setString(2, off.getLocal());
        ps.setString(3, off.getDays());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteOnsite(int id) throws SQLException {
        String sql = "DELETE FROM person WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateOnsite(Onsite off) throws SQLException {
        String sql = "UPDATE person SET Lastname = ?, Firstname = ?, EnrollmentDate = ? WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getLastName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getEnrollmentDate().toString());
        ps.setInt(4, s.getPersonID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchOnsite(String name) throws SQLException {
        String sql = "SELECT * FROM person WHERE concat(Firstname,' ', Lastname) = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        ArrayList<Onsite> array = new ArrayList<>();
        while (rs.next()) {
            Onsite off = new Onsite(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), Date.valueOf(rs.getString("EnrollmentDate")));
            array.add(off);
        }
        return array;
    }
}
