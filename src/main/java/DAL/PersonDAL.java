/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Tran Minh Nhat
 */
public class PersonDAL extends DatabaseManager {

    public PersonDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadPersons() throws SQLException {
        String sql = "select * from person";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Person> array = new ArrayList<>();
        while (rs.next()) {
            Person s = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"),
                    (rs.getString("HireDate") != null) ? Timestamp.valueOf(rs.getString("HireDate")) : null,
                    (rs.getString("EnrollmentDate") != null) ? Timestamp.valueOf(rs.getString("EnrollmentDate")) : null);
            array.add(s);
        }
        return array;
    }

    public int InsertPerson(Person s) throws SQLException {
        String sql = "INSERT INTO person (FirstName, LastName, EnrollmentDate, HireDate) VALUES (?,?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getFirstName());
        ps.setString(2, s.getLastName());
        ps.setString(3, (s.getEnrollmentDate() != null) ? s.getEnrollmentDate().toString() : null);
        ps.setString(4, (s.getHireDate() != null) ? s.getHireDate().toString() : null);
        int result = ps.executeUpdate();
        return result;
    }

    public int DeletePerson(int id) throws SQLException {
        String sql = "DELETE FROM person WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdatePerson(Person s) throws SQLException {
        String sql = "UPDATE person SET Lastname = ?, Firstname = ?, EnrollmentDate = ?, HireDate = ? WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getLastName());
        ps.setString(2, s.getLastName());
        ps.setString(3, (s.getEnrollmentDate() != null) ? s.getEnrollmentDate().toString() : null);
        ps.setString(4, (s.getHireDate() != null) ? s.getHireDate().toString() : null);
        ps.setInt(5, s.getPersonID());
        int result = ps.executeUpdate();
        return result;
    }

    public ArrayList SearchPersonByName(String name) throws SQLException {
        String sql = "SELECT * FROM person WHERE concat(Firstname,' ', Lastname) = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        ArrayList<Person> array = new ArrayList<>();
        while (rs.next()) {
            Person s = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"),
                    (rs.getString("HireDate") != null) ? Timestamp.valueOf(rs.getString("HireDate")) : null,
                    (rs.getString("EnrollmentDate") != null) ? Timestamp.valueOf(rs.getString("EnrollmentDate")) : null);
            array.add(s);
        }
        return array;
    }
}
