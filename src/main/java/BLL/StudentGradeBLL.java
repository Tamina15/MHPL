package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAL.StudentGradeDAL;
import DTO.StudentGrade;

public class StudentGradeBLL {

    StudentGradeDAL dal;
    ArrayList<StudentGrade> studentGrades;

    public StudentGradeBLL() {
        dal = new StudentGradeDAL();
        studentGrades = new ArrayList<>();
    }

    public ArrayList<StudentGrade> ReadStudentGrade() throws SQLException {
        return studentGrades = dal.ReadStudentsGrade();
    }

    public void AddStudentGrade(ArrayList<StudentGrade> array, StudentGrade p) {
        try {
            dal.InsertStudentGrade(p);
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(StudentGradeBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteStudentGrade(ArrayList<StudentGrade> array, StudentGrade toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getEnrollmentID() == toDel.getEnrollmentID()) {
                array.remove(i);
                try {
                    dal.DeleteStudentGrade(toDel.getEnrollmentID());
                } catch (SQLException ex) {
                    Logger.getLogger(StudentGradeBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ArrayList<StudentGrade> FindEnrollmentID(int id) {
        ArrayList<StudentGrade> temp = new ArrayList<>();
        for (StudentGrade g : studentGrades) {
            if (g.getEnrollmentID() == id) {
                temp.add(g);
                System.out.println(g.toString());
            }
        }
        
        return temp;
    }
//    public DefaultTableModel FindEnrollmentID(DefaultTableModel model, String name) {
//        Vector v = new Vector();
//        v.add("EnrollmentID");
//        v.add("CourseID");
//        v.add("StudentID");
//        v.add("Grade");
//        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
//        for (int i = 0; i < model.getRowCount(); i++) {
//            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
//                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3)};
//                newmodel.addRow(o);
//            }
//        }
//        return newmodel;
//    }
}
