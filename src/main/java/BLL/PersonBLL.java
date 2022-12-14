/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.PersonDAL;
import DTO.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Minh Nhat
 */
public class PersonBLL {

    PersonDAL dal;
    ArrayList<Person> persons;

    public PersonBLL() {
        dal = new PersonDAL();
        persons = new ArrayList<>();
    }

    public ArrayList<Person> ReadPerson() throws SQLException {
        return persons = dal.ReadPersons();
    }

    public void AddPerson(ArrayList<Person> array, Person p) {
        try {
            array.add(p);
            dal.InsertPerson(p);
        } catch (SQLException ex) {
            Logger.getLogger(PersonBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeletePerson(ArrayList<Person> array, Person toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getPersonID() == toDel.getPersonID()) {
                array.remove(i);
                try {
                    dal.DeletePerson(toDel.getPersonID());
                } catch (SQLException ex) {
                    Logger.getLogger(PersonBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void UpdatePerson(ArrayList<Person> array, Person toChange) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getPersonID() == toChange.getPersonID()) {
                array.set(i, toChange);
                try {
                    dal.UpdatePerson(toChange);
                } catch (SQLException ex) {
                    Logger.getLogger(PersonBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(array.get(i).toString());
                break;
            }
        }
    }

    public DefaultTableModel FindPersonByFullName(DefaultTableModel model, String name) {
        Object[] header = {"PersonID", "LastName", "FirstName", "HireDate", "EnrollmentDate"};
        DefaultTableModel newmodel = new DefaultTableModel(header, 0);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 1).toString().concat(" " + model.getValueAt(i, 2).toString()).equals(name)) {
                Object[] o = {model.getValueAt(i, 0), model.getValueAt(i, 1), model.getValueAt(i, 2), model.getValueAt(i, 3), model.getValueAt(i, 4)};
                newmodel.addRow(o);
            }
        }
        return newmodel;
    }

    public ArrayList<Person> FindPersonByName(String name) {
        ArrayList<Person> temp = new ArrayList<>();
        for (Person p : persons) {
            if (p.getFullName().equals(name) || p.getFirstName().equals(name) || p.getLastName().equals(name)) {
                temp.add(p);
            }
        }
        return temp;
    }

    public DefaultTableModel SelectPersonType(DefaultTableModel model, String type) {
        int column;
        switch (type) {
            case "Students":
                column = 4;
                break;
            case "Teachers":
                column = 3;
                break;
            default:
                return model;
        }
        Vector v = new Vector();
        v.add("PersonID");
        v.add("LastName");
        v.add("FirstName");
        v.add("HireDate");
        v.add("EnrollmentDate");
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
