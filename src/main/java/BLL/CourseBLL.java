/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class CourseBLL {
    CourseDAL couDal;
    public CourseBLL() {
        couDal = new CourseDAL();
    }
    public List LoadCourses(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = couDal.readCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }

    public List findCourse(String title) throws SQLException {
        List list = new ArrayList();
        list = couDal.findStudents(title);
        return list;
    }

    public Course getCourse(int courseID) throws SQLException {
        Course c = couDal.getCourse(courseID);
        return c;
    }

    public int addCourse(Course c) throws SQLException {
        int result = couDal.insertCourse(c);
        return result;
    }
    
}
