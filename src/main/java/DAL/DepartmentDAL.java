/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Department;
import DTO.OnlineCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DepartmentDAL extends MyDatabaseManager{
    public DepartmentDAL() {
        DepartmentDAL.connectDB();
    }
    public ArrayList readDepartment() throws SQLException {
        String querry = "SELECT * FROM Department";
        ResultSet rs = OnlineCourseDAL.doReadQuery(querry);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                Department dpm = new Department();
                dpm.setDepartmentID(rs.getInt("DepartmentID"));
                dpm.setName(rs.getString("Name"));
                dpm.setBudget(rs.getDouble("Budget"));
                dpm.setStartDate(rs.getDate("StartDate"));
                dpm.setAdministrator(rs.getInt("Administrator"));
                list.add(dpm);
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
    
    public Department getDepartment(int DepartmentId) throws SQLException {
        String query = "SELECT * FROM Department WHERE DepartmentID = ? ";
        PreparedStatement p = DepartmentDAL.getConnection().prepareStatement(query);
        p.setInt(1, DepartmentId);
        ResultSet rs = p.executeQuery();
        Department dpm = null;
        if (rs != null) {
            while (rs.next()) {
                dpm = new Department();
                dpm.setDepartmentID(rs.getInt("DepartmentID"));
                dpm.setName(rs.getString("Name"));
                dpm.setBudget(rs.getDouble("Budget"));
                dpm.setStartDate(rs.getDate("StartDate"));
                dpm.setAdministrator(rs.getInt("Administrator"));
            }
        }
        return dpm;
    }

//    public int updateOnlineCourse(OnlineCourse c) throws SQLException {
//        String query = "Update Course SET Title = ?, DepartmentID = ? "
//                + " WHERE CourseID = ?";
//        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
//        p.setString(1, c.getTitle());
//        p.setInt(3, c.getCourseId());
//        p.setInt(3, c.getDepartmentId());
//        int result = p.executeUpdate();
//        return result;
//    }
    
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

    public int deleteCousre(int courseID) throws SQLException {
        String query = "DELETE FROM OnlineCourse WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        return result;
    }
}
