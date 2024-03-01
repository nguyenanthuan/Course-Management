/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnsiteCourseDAL;
import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OnsiteCourseBLL {
    OnsiteCourseDAL oscdal;
    public OnsiteCourseBLL() {
        oscdal = new OnsiteCourseDAL();
    }
    
    public List LoadOnsiteCourses(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = oscdal.readOnsiteCourse();
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

    public OnsiteCourse getOnsiteCourse(int courseID) throws SQLException {
        OnsiteCourse osc = oscdal.getOnsiteCourse(courseID);
        return osc;
    }

    public int addOnsiteCourse(OnsiteCourse osc) throws SQLException {
        int result = oscdal.insertOnsiteCourse(osc);
        return result;
    }
    public int removeCourse(int id) throws SQLException {
        int result = oscdal.deleteCourse(id);
        return result;
    }
    
    public int updateCourse(OnsiteCourse c) throws SQLException {
        int result = oscdal.updateOnsiteCourse(c);
        return result;
    }
}
