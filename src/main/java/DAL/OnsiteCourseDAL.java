/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.OnlineCourse;
import DTO.OnsiteCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class OnsiteCourseDAL extends MyDatabaseManager{
    public OnsiteCourseDAL() {
        OnsiteCourseDAL.connectDB();
    }
    
    public ArrayList readOnsiteCourse() throws SQLException {
        String querry = "SELECT * FROM OnsiteCourse";
        ResultSet rs = OnlineCourseDAL.doReadQuery(querry);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                OnsiteCourse osc = new OnsiteCourse();
                osc.setCourseID(rs.getInt("CourseID"));
                osc.setLocation(rs.getString("Location"));
                osc.setDays(rs.getString("Days"));
                osc.setTime(rs.getTime("Time"));
                list.add(osc);
            }
        }
        return list;
    }
    
    public int insertOnsiteCourse(OnsiteCourse osc) throws SQLException {
        String query = "Insert OnsiteCourse (CourseId, Location, Days, Time) VALUES (?, ?, ?, ?)";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, osc.getCourseID());
        p.setString(2, osc.getLocation());
        p.setString(3, osc.getDays());
        p.setTime(4, osc.getTime());
        int result = p.executeUpdate();
        return result;
    }
    
    public OnsiteCourse getOnsiteCourse(int courseId) throws SQLException {
        String query = "SELECT * FROM OnsiteCourse WHERE CourseID = ? ";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseId);
        ResultSet rs = p.executeQuery();
        OnsiteCourse osc = null;
        if (rs != null) {
            while (rs.next()) {
                osc = new OnsiteCourse();
                osc.setCourseID(rs.getInt("CourseID"));
                osc.setLocation(rs.getString("Location"));
                osc.setDays(rs.getString("Days"));
                osc.setTime(rs.getTime("Time"));
            }
        }
        return osc;
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
        String query = "DELETE FROM OnsiteCourse WHERE CourseID = ?";
        PreparedStatement p = OnsiteCourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        return result;
    }
}
