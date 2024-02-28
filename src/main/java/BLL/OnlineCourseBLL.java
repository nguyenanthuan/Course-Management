/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineCourseDAL;
import DTO.Course;
import DTO.OnlineCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OnlineCourseBLL {
    OnlineCourseDAL olcdal;
    public OnlineCourseBLL() {
        olcdal = new OnlineCourseDAL();
    }
    
    public List LoadOnlineCourses(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = olcdal.readOnlineCourse();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }

//    public List findCourse(String title) throws SQLException {
//        List list = new ArrayList();
//        list = olcdal.findOnlineCourse(title);
//        return list;
//    }

    public OnlineCourse getOnlineCourse(int courseID) throws SQLException {
        OnlineCourse olc = olcdal.getOnlineCourse(courseID);
        return olc;
    }

    public int addOnlineCourse(OnlineCourse olc) throws SQLException {
        int result = olcdal.insertOnlineCourse(olc);
        return result;
    }
}
