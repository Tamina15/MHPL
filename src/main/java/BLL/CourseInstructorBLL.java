package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

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

    public void DeleteInstructor(ArrayList<Instructor> array, Instructor toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getPersonID()== toDel.getPersonID()) {
                array.remove(i);
            }
        }
//        try {
//            dal.DeleteInstructor(p.getInstructorID());
//        } catch (SQLException ex) {
//            Logger.getLogger(InstructorBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public DefaultTableModel FindInstructorByFullName(DefaultTableModel model, String name) {
        Vector v = new Vector();
        v.add("CourseID");
        v.add("PersonID");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }


}
