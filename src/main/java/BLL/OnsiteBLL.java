package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import DAL.OnsiteDAL;
import DTO.Onsite;

public class OnsiteBLL {
	OnsiteDAL dal;
    ArrayList<Onsite> Onsites;

    public OnsiteBLL() {
        dal = new OnsiteDAL();
        Onsites = new ArrayList<>();
    }

    public ArrayList<Onsite> ReadOnsite() throws SQLException {
        return Onsites = dal.ReadOnsites();
    }

    public void AddOnsite(ArrayList<Onsite> array, Onsite p) {
        try {
            dal.InsertOnsite(p);
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteOnsite(ArrayList<Onsite> array, Onsite toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID()== toDel.getCourseID()) {
                array.remove(i);
            }
        }
//        try {
//            dal.DeleteOnsite(p.getOnsiteID());
//        } catch (SQLException ex) {
//            Logger.getLogger(OnsiteBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public DefaultTableModel FindOnsiteByFullName(DefaultTableModel model, String name) {
        Vector v = new Vector();
        v.add("CourseID");
        v.add("Location");
        v.add("Days");
        v.add("Time");
        DefaultTableModel newmodel = new DefaultTableModel(v, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1),model.getValueAt(i, 2),model.getValueAt(i, 3)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }
}
