package BLL;

import java.sql.SQLException;
import java.util.ArrayList;
import DAL.CourseDAL;
import DAL.InstructorDAL;
import DAL.OnlineDAL;
import DAL.OnsiteDAL;
import DAL.StudentGradeDAL;
import DTO.Course;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public ArrayList<Course> ReadOnlineCourse() {
        try {
            return Courses = dal.ReadOnlineCourse();
        } catch (SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public ArrayList<Course> ReadOfflineCourse() {
        try {
            return Courses = dal.ReadOfflineCourse();
        } catch (SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    public void AddCourse(ArrayList<Course> array, Course p, int i) {
        try {
            switch (i) {
                case 0:
                    dal.InsertCourse(p);
                    break;
                case 1:
                    dal.InsertOnlineCourse(p);
                    break;
                case 2:
                    dal.InsertOfflineCourse(p);
                    break;
            }
            array.add(p);
        } catch (SQLException ex) {
            Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void UpdateCourse(ArrayList<Course> array, Course toChange, int c) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID() == toChange.getCourseID()) {
                array.set(i, toChange);
                try {
                    switch (c) {
                        case 0:
                            dal.UpdateCourse(toChange);
                            break;
                        case 1:
                            dal.UpdateOnlineCourse(toChange);
                            break;
                        case 2:
                            dal.UpdateOfflineCourse(toChange);
                            break;
                    }
                    dal.UpdateCourse(toChange);
                } catch (SQLException ex) {
                    Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
    }

    public void DeleteCourse(ArrayList<Course> array, Course toDel) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getCourseID() == toDel.getCourseID()) {
                array.remove(i);
                try {
                    new OnsiteDAL().DeleteOnsite(toDel.getCourseID());
                    new OnlineDAL().DeleteOnline(toDel.getCourseID());
                    new InstructorDAL().DeleteCourse(toDel.getCourseID());
                    new StudentGradeDAL().DeleteStudentGradeByCourse(toDel.getCourseID());
                    dal.DeleteCourse(toDel.getCourseID());
                } catch (SQLException ex) {
                    Logger.getLogger(CourseBLL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public ArrayList<Course> FindCourseByID(int id) {
        ArrayList<Course> array = new ArrayList<>();
        for (Course c : Courses) {
            if (c.getCourseID() == id) {
                array.add(c);
            }
        }
        return array;
    }

    public ArrayList<Course> FindCourseByName(String name) {
        ArrayList<Course> array = new ArrayList<>();
        for (Course c : Courses) {
            if (c.getTitle().equals(name)) {
                array.add(c);
            }
        }
        return array;
    }

}
