package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import DAL.CourseDAL;
import DTO.Course;

public class CourseBLL {
	CourseDAL dal;
    ArrayList<Course> Courses;

    public CourseBLL() {
        dal = new CourseDAL();
        Courses = new ArrayList<>();
    }

    public ArrayList<Course> ReadCourse() throws SQLException {
        return Courses = dal.ReadCourse();
    }

    public void AddCourse(ArrayList<Course> array, Course p) {
        try {
            dal.InsertCourse(p);
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteCourse(ArrayList<Course> array, Course toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID() == toDel.getCourseID()) {
                array.remove(i);
            }
        }
//        try {
//            dal.DeleteCourse(p.getCourseID());
//        } catch (SQLException ex) {
//            Logger.getLogger(CourseBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public DefaultTableModel FindCourseByFullName(DefaultTableModel model, String name) {
        Vector v = new Vector();
        v.add("CourseID");
        v.add("Title");
        v.add("Credits");
        v.add("DepartmentID");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

    public DefaultTableModel SelectCourseType(DefaultTableModel model, String type) {
        int column;
        Vector v = new Vector();
        v.add("CourseID");
        v.add("Title");
        v.add("Credits");
        v.add("DepartmentID");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, column) != null) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

}
