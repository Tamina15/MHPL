package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Department;

public class DepartmentDAL extends DatabaseManager  {

	    Date d;

	    public DepartmentDAL() {
	        super();
	        ConnectDatabase();
	    }

	    public ArrayList ReadDepartment() throws SQLException {
	        String sql = "select * from department where EnrollmentDate > 0";
	        ResultSet rs = ExecuteQuery(sql);
	        ArrayList<Department> array = new ArrayList<>();
	        while (rs.next()) {
	            Department s = new Department(rs.getInt("DepartmentID"), rs.getString("Name"), rs.getDouble("Budget"), Date.valueOf(rs.getString("StartDate")), rs.getInt("Administrator"));
	            array.add(s);
	        }
	        return array;
	    }

	    public int InsertDerpartment(Department s) throws SQLException {
	        String sql = "INSERT INTO department (Name, Burget, StartDate, Administrator) VALUES (?,?,?)";
	        PreparedStatement ps = this.getConnection().prepareStatement(sql);
	        ps.setString(1, s.getName());
	        ps.setDouble(2, s.getBudget());
	        ps.setString(3, s.getStartDate().toString());
	        ps.setInt(3, s.getAD());
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

	    public int UpdateDepartment(Department s) throws SQLException {
	        String sql = "UPDATE department SET Name = ?, Budget = ?, StartDate = ?, Administrator WHERE DepartmentID = ?";
	        PreparedStatement ps = this.getConnection().prepareStatement(sql);
	        ps.setString(1, s.getName());
	        ps.setDouble(2, s.getBudget());
	        ps.setString(3, s.getStartDate().toString());
	        ps.setInt(3, s.getAD());
	        int result = ps.executeUpdate();
	        return result;
	    }

	    public ArrayList SearchDepartment(String name) throws SQLException {
	        String sql = "SELECT * FROM person WHERE concat(Firstname,' ', Lastname) = ?";
	        PreparedStatement ps = this.getConnection().prepareStatement(sql);
	        ps.setString(1, name);
	        ResultSet rs = ps.executeQuery();
	        ArrayList<Department> array = new ArrayList<>();
	        while (rs.next()) {
	            Department s = new Department(rs.getInt("DepartmentID"), rs.getString("Name"), rs.getDouble("Budget"), Date.valueOf(rs.getString("StartDate")), rs.getInt("Administrator"));
	            array.add(s);
	        }
	        return array;
	    }

}
