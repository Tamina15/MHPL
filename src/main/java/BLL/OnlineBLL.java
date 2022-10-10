package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import DAL.OnlineDAL;
import DTO.Online;

public class OnlineBLL {
	OnlineDAL dal;
    ArrayList<Online> Onlines;

    public OnlineBLL() {
        dal = new OnlineDAL();
        Onlines = new ArrayList<>();
    }

    public ArrayList<Online> ReadOnline() throws SQLException {
        return Onlines = dal.ReadOnlines();
    }

    public void AddOnline(ArrayList<Online> array, Online p) {
        try {
            dal.InsertOnline(p);
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(OnlineBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteOnline(ArrayList<Online> array, Online toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID()== toDel.getCourseID()) {
                array.remove(i);
            }
        }
//        try {
//            dal.DeleteOnline(p.getOnlineID());
//        } catch (SQLException ex) {
//            Logger.getLogger(OnlineBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public DefaultTableModel FindOnlineByFullName(DefaultTableModel model, String name) {
        Vector v = new Vector();
        v.add("CourseID");
        v.add("URL");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

    public DefaultTableModel SelectOnlineType(DefaultTableModel model, String type) {
        int column;
        Vector v = new Vector();
        v.add("CourseID");
        v.add("URL");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, column) != null) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

}
