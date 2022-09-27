/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tran Minh Nhat
 */
public class StudentDAL extends DatabaseManager {

    public StudentDAL() {
        super();
        ConnectDatabase();
    }

    public ResultSet ReadStudents() {
        String sql = "select * from person where EnrollmentDate > 0";
        ResultSet rs = ExecuteQuery(sql);
        return rs;
    }

    public int InsertStudent(Student s) throws SQLException {
        String sql = "INSERT INTO person (FirstName, LastName, EnrollmentDate) VALUES (?,?,?)";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getFirstName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getEnrollmentDate().toString());
        int result = ps.executeUpdate();
        return result;
    }

    public int DeleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM person WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result;
    }

    public int UpdateStudent(Student s) throws SQLException {
        String sql = "UPDATE person SET Lastname = ?, Firstname = ?, EnrollmentDate = ? WHERE PersonID = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, s.getLastName());
        ps.setString(2, s.getLastName());
        ps.setString(3, s.getEnrollmentDate().toString());
        ps.setInt(4, s.getStudentID());
        int result = ps.executeUpdate();
        return result;

    }

    public ResultSet SearchStudent(String name) throws SQLException {
        String sql = "SELECT * FROM person WHERE concat(Firstname,' ', Lastname) = ?";
        PreparedStatement ps = this.getConnection().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

//    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        Student st;
//        int choice = -1;
//        System.out.println("Quan ly thong tin sinh vien");
//        System.out.println("---------------------------");
//        StudentDAL student = new StudentDAL();
//        while (choice != 0) {
//            System.out.println("Enter:      0: Exit          1: List         2: Insert       3: Update       4: Delete       5: Find");
//            choice = Integer.parseInt(sc.nextLine());
//            switch (choice) {
//                case 0:
//                    System.out.println("Exit Program");
//                    break;
//                case 1:
//                    student.ReadStudents();
//                    break;
//                case 2:
//                    st = new Student();
//                    System.out.println("Enter Student Last Name: ");
//                    st.setFirstName(sc.nextLine());
//                    System.out.println("Enter Student First Name: ");
//                    st.setLastName(sc.nextLine());
//                    System.out.println("Enter Student Enrollment Date: ");
//                    st.setEnrollmentDate(Date.valueOf(sc.nextLine()));
//                    student.InsertStudent(st);
//                    break;
//                case 3:
//                    st = new Student();
//                    System.out.println("Enter Student ID to Update: ");
//                    st.setStudentID(Integer.parseInt(sc.nextLine()));
//                    System.out.println("Enter Student Last Name: ");
//                    st.setFirstName(sc.nextLine());
//                    System.out.println("Enter Student First Name: ");
//                    st.setLastName(sc.nextLine());
//                    System.out.println("Enter Student Enrollment Date: ");
//                    st.setEnrollmentDate(Date.valueOf(sc.nextLine()));
//                    student.UpdateStudent(st);
//                    break;
//                case 4:
//                    st = new Student();
//                    System.out.println("Enter Student ID to Delete: ");
//                    st.setStudentID(Integer.parseInt(sc.nextLine()));
//                    student.DeleteStudent(st.getStudentID());
//                    break;
//                case 5:
//                    st = new Student();
//                    System.out.println("Enter Student Last Name: ");
//                    st.setFirstName(sc.nextLine());
//                    System.out.println("Enter Student First Name: ");
//                    st.setLastName(sc.nextLine());
//                    student.SearchStudent(st.getFullName());
//                    break;
//            }
//        }
//    }
}
