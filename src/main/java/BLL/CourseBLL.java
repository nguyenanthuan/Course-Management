/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseDAL;
import DTO.*;
import GUI.CourseForm;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public List searchCoursebyDepartment(Department dpm, List lstcou) { 
        if(dpm != null) {
            for(int i = 0; i < lstcou.size(); i++) {
                Course cour = (Course) lstcou.get(i);
                if(dpm.getDepartmentID() != cour.getDepartmentId()) {
                     lstcou.remove(i);
                }
            }
        }
        return lstcou;
    } 
    
    public int generateCourseID() throws SQLException {
        boolean check = false;
        int id = 0;
        while(!check) {
            Random random = new Random();
            int ranId = random.nextInt(9000) + 1000;
            Course c = getCourse(ranId);
            if(c == null) {
                id = ranId;
                check = true;
            }
        }
        return id;
    } 
    
    public int removeCourse(int id) throws SQLException {
        int result = couDal.deleteCourse(id);
        return result;
    }
    
    public int updateCourse(Course c) throws SQLException {
        int result = couDal.updateCourse(c);
        return result;
    }
}
