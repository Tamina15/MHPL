/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Department;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class DepartmentDAL extends DatabaseManager {

    public DepartmentDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadDepartments() throws SQLException {
        String sql = "select * from department";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Department> array = new ArrayList<>();
        while (rs.next()) {
            Department d = new Department(rs.getInt("DepartmentID"), rs.getString("Name"), rs.getDouble("Budget"), Date.valueOf(rs.getString("StartDate")), rs.getString("Administrator"));
            array.add(d);
        }
        return array;
    }

    public int InsertDepartment(Department d) throws SQLException {
        String sql = "INSERT INTO department(DepartmentID, Name, Budget, StartDate, Administrator) VALUES (?,?,?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, Integer.toString(d.getDepartment()));
        ps.setString(2, d.getName());
        ps.setString(3, Double.toString(d.getBudget()));
        ps.setString(4, d.getStartDate().toString());
        ps.setString(5, d.getAD());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteDepartment(int id) throws SQLException {
        String sql = "DELETE FROM department WHERE DepartmentID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateDepartment(Department d) throws SQLException {
        String sql = "UPDATE department SET Name = ?, Budget = ?, StartDate = ? ,Administrator = ? WHERE DepartmentID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, d.getName());
        ps.setString(2, Double.toString(d.getBudget()));
        ps.setString(3, d.getStartDate().toString());
        ps.setString(4, d.getAD());
        ps.setString(5, Integer.toString(d.getDepartment()));
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchDepartment(String dname) throws SQLException {
        String sql = "SELECT * FROM department WHERE Name = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, dname);
        ResultSet rs = ps.executeQuery();
        ArrayList<Department> array = new ArrayList<>();
        while (rs.next()) {
            Department d = new Department(rs.getInt("DepartmentID"), rs.getString("Name"), rs.getDouble("Budget"), Date.valueOf(rs.getString("StartDate")), rs.getString("Administrator"));
            array.add(d);
        }
        return array;
    }
}
