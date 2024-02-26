/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Course;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CourseDAL extends MyDatabaseManager{
    public CourseDAL() {
        CourseDAL.connectDB();
    }
    public ArrayList readCourse() throws SQLException {
        String query = "SELECT * FROM Course";
        ResultSet rs = CourseDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Course c = new Course();
                c.setCourseId(rs.getInt("CourseID"));
                c.setTitle(rs.getString("Title"));
                c.setCredits(rs.getInt("Credits"));
                c.setDepartmentId(rs.getInt("DepartmentID"));
                list.add(c);
            }
        }
        return list;
    }
    public int insertCourse(Course c) throws SQLException {
        String query = "Insert Course (CourseId, Title, Credits, DepartmentID) VALUES (?, ?, ?, ?)";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, c.getCourseId());
        p.setString(2, c.getTitle());
        p.setInt(3, c.getCredits());
        p.setInt(4, c.getDepartmentId());
        int result = p.executeUpdate();
        return result;
    }
}
