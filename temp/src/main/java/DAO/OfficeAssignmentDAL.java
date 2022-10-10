/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.OfficeAssignment;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class OfficeAssignmentDAL extends DatabaseManager {

    public OfficeAssignmentDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadOfficeAssignments() throws SQLException {
        String sql = "SELECT * FROM officeassignment WHERE 1";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<OfficeAssignment> array = new ArrayList<>();
        while (rs.next()) {
            OfficeAssignment oa = new OfficeAssignment(rs.getInt("InstructorID"), rs.getString("Location"), Date.valueOf(rs.getString("Timestamp")));
            array.add(oa);
        }
        return array;
    }

    public int InsertOfficeAssignment(OfficeAssignment oa) throws SQLException {
        String sql = "INSERT INTO officeassignment(InstructorID, Location, Timestamp) VALUES (?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, oa.getInstructorID());
        ps.setString(2, oa.getLocation());
        ps.setString(3, oa.getTimestamp().toString());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteOfficeAssignment(int id) throws SQLException {
        String sql = "DELETE FROM officeassignment WHERE InstructorID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateOfficeAssignment(OfficeAssignment oa) throws SQLException {
        String sql = "UPDATE officeassignment SET Location=?,Timestamp=? WHERE InstructorID=?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, oa.getLocation());
        ps.setString(2, oa.getTimestamp().toString());
        ps.setInt(3, oa.getInstructorID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchOfficeAssignment(int id) throws SQLException {
        String sql = "SELECT * FROM officeassignment WHERE InstructorID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<OfficeAssignment> array = new ArrayList<>();
        while (rs.next()) {
            OfficeAssignment oa = new OfficeAssignment(rs.getInt("InstructorID"), rs.getString("Location"), Date.valueOf(rs.getString("Timestamp")));
            array.add(oa);
        }
        return array;
    }
}
