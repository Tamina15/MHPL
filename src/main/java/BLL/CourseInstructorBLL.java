package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import DAL.InstructorDAL;
import DTO.Instructor;

public class CourseInstructorBLL {

    InstructorDAL dal;
    ArrayList<Instructor> Instructors;

    public CourseInstructorBLL() {
        dal = new InstructorDAL();
        Instructors = new ArrayList<>();
    }

    public ArrayList<Instructor> ReadInstructor() throws SQLException {
        return Instructors = dal.ReadInstructors();
    }

    public void AddInstructor(ArrayList<Instructor> array, Instructor p) {
        try {
            dal.InsertInstructor(p);
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(CourseInstructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateInstructor(ArrayList<Instructor> array, Instructor toChange, Instructor old) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID() == old.getCourseID() && array.get(i).getPersonID() == old.getPersonID()) {
                array.set(i, toChange);
                try {
                    dal.UpdateInstructor(old, toChange);
                } catch (SQLException ex) {
                    Logger.getLogger(CourseInstructorBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
    }

    public void DeleteInstructor(ArrayList<Instructor> array, Instructor toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID() == toDel.getCourseID() && array.get(i).getPersonID() == toDel.getPersonID()) {
                array.remove(i);
                try {
                    dal.DeleteInstructor(toDel);
                } catch (SQLException ex) {
                    Logger.getLogger(CourseInstructorBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<Instructor> FindInstructorByFullName(String name) {
        ArrayList<Instructor> array = new ArrayList<>();
        for (Instructor i : Instructors) {
            if (i.getPersonName().equals(name)) {
                array.add(i);
            }
        }
        return array;
    }

}
