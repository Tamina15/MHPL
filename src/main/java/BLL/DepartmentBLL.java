package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import DAL.DepartmentDAL;
import DTO.Department;

public class DepartmentBLL {
	DepartmentDAL dal;
    ArrayList<Department> Departments;

    public DepartmentBLL() {
        dal = new DepartmentDAL();
        Departments = new ArrayList<>();
    }

    public ArrayList<Department> ReadDepartment() throws SQLException {
        return Departments = dal.ReadDepartments();
    }

    public void AddDepartment(ArrayList<Department> array, Department p) {
        try {
            dal.InsertDepartment(p);
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteDepartment(ArrayList<Department> array, Department toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getDepartmentID() == toDel.getDepartmentID()) {
                array.remove(i);
            }
        }
//        try {
//            dal.DeleteDepartment(p.getDepartmentID());
//        } catch (SQLException ex) {
//            Logger.getLogger(DepartmentBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public DefaultTableModel FindDepartmentByFullName(DefaultTableModel model, String name) {
        Vector v = new Vector();
        v.add("DepartmentID");
        v.add("Name");
        v.add("Budget");
        v.add("StartDate");
        v.add("Administrator");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3), model.getValueAt(i, 4)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

    public DefaultTableModel SelectDepartmentType(DefaultTableModel model, String type) {
        int column;
        Vector v = new Vector();
        v.add("DepartmentID");
        v.add("Name");
        v.add("Budget");
        v.add("StartDate");
        v.add("Administrator");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, column) != null) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3), model.getValueAt(i, 4)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

}
