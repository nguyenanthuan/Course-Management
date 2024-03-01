/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import DTO.OnlineCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OnlineCourseDAL extends MyDatabaseManager{
    public OnlineCourseDAL() {
        OnlineCourseDAL.connectDB();
    }
    public ArrayList readOnlineCourse() throws SQLException {
        String querry = "SELECT * FROM OnlineCourse";
        ResultSet rs = OnlineCourseDAL.doReadQuery(querry);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                OnlineCourse oc = new OnlineCourse();
                oc.setCourseId(rs.getInt("CourseID"));
                oc.setUrl(rs.getString("url"));
                list.add(oc);
            }
        }
        return list;
    }
    
    public int insertOnlineCourse(OnlineCourse oc) throws SQLException {
        String query = "Insert OnlineCourse (CourseId, url) VALUES (?, ?)";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, oc.getCourseId());
        p.setString(2, oc.getUrl());
        int result = p.executeUpdate();
        return result;
    }
    
    public OnlineCourse getOnlineCourse(int courseId) throws SQLException {
        String query = "SELECT * FROM OnlineCourse WHERE CourseID = ? ";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseId);
        ResultSet rs = p.executeQuery();
        OnlineCourse oc = null;
        if (rs != null) {
            while (rs.next()) {
                oc = new OnlineCourse();
                oc.setCourseId(rs.getInt("CourseID"));
                oc.setUrl(rs.getString("url"));
            }
        }
        return oc;
    }

    public int updateOnlineCourse(OnlineCourse c) throws SQLException {
        String query = "Update OnlineCourse SET url = ? "
                + " WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setString(1, c.getUrl());
        p.setInt(2, c.getCourseId());
        int result = p.executeUpdate();
        return result;
    }
    
//    public List findOnlineCourse(String courseId) throws SQLException {
//        String query = "SELECT * FROM OnlineCourse WHERE concat(CourseId) LIKE ?";
//        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
//        p.setString(1, "%" + title + "%");
//        ResultSet rs = p.executeQuery();
//        List list = new ArrayList();
//        if (rs != null) {
//            while (rs.next()) {
//                Course c = new Course();
//                c.setCourseId(rs.getInt("CourseID"));
//                c.setTitle(rs.getString("Title"));
//                c.setCredits(rs.getInt("Credits"));
//                c.setDepartmentId(rs.getInt("DepartmentID"));
//                list.add(c);
//            }
//        }
//        return list;
//    }

    public int deleteCourse(int courseID) throws SQLException {
        String query = "DELETE FROM OnlineCourse WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        return result;
    }
}
