/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Online;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class OnlineDAL extends DatabaseManager {

    public OnlineDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadOnlines() throws SQLException {
        String sql = "select * from person where EnrollmentDate > 0";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Online> array = new ArrayList<>();
        while (rs.next()) {
            Online o = new Online(rs.getInt("CourseID"), rs.getString("url"));
            array.add(o);
        }
        return array;
    }

    public int InsertOnline(Online o) throws SQLException {
        String sql = "INSERT INTO onlinecourse (CourseID, url) VALUES (?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, o.getCourseID());
        ps.setString(2, o.getUrl());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteOnline(int id) throws SQLException {
        String sql = "DELETE FROM onlinecourse WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateOnline(Online o) throws SQLException {
        String sql = "UPDATE onlinecourse SET url = ? WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, o.getUrl());
        ps.setInt(2, o.getCourseID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchOnline(int id) throws SQLException {
        String sql = "SELECT * FROM onlinecourse WHERE CourseID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ArrayList<Online> array = new ArrayList<>();
        while (rs.next()) {
            Online o = new Online(rs.getInt("CourseID"), rs.getString("url"));
            array.add(o);
        }
        return array;
    }
}
