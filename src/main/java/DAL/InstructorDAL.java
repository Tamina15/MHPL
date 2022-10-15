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

    public InstructorDAL() {
        super();
        ConnectDatabase();
    }

    public ArrayList ReadInstructors() throws SQLException {
        String sql = "SELECT courseinstructor.CourseID, courseinstructor.PersonID, course.Title, concat(person.Lastname ,' ',person.Firstname) as name FROM courseinstructor, course, person WHERE course.CourseID= courseinstructor.CourseID AND person.PersonID = courseinstructor.PersonID";
        ResultSet rs = ExecuteQuery(sql);
        ArrayList<Instructor> array = new ArrayList<>();
        while (rs.next()) {
            Instructor d = new Instructor(rs.getInt("CourseID"), rs.getInt("PersonID"), rs.getString("Title"), rs.getString("name"));
            array.add(d);
        }
        return array;
    }

    public int InsertInstructor(Instructor d) throws SQLException {
        String sql = "INSERT INTO courseinstructor(CourseID, PersonID) VALUES (?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, d.getCourseID());
        ps.setInt(2, d.getPersonID());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteInstructor(Instructor d) throws SQLException {
        String sql = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, d.getCourseID());
        ps.setInt(2, d.getPersonID());
        int result = ps.executeUpdate();
        if (result == 1) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
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
        String sql = "UPDATE courseinstructor SET CourseID = ? , PersonID = ? WHERE CourseID = ? AND PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, newI.getCourseID());
        ps.setInt(2, newI.getPersonID());
        ps.setInt(3, old.getCourseID());
        ps.setInt(4, old.getPersonID());
        int result = ps.executeUpdate();
                if (result == 1) {
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Sửa thất bại");
        }
        return result;
    }

}
