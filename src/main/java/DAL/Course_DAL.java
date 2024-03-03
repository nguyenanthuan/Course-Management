/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.ConnectDB;
import DTO.Course_DTO;
import DTO.Department_DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Course_DAL {
    ConnectDB connectDB=new ConnectDB();
    public Vector<Course_DTO> readCourse()
    {
       Vector<Course_DTO> listCourse =new Vector<Course_DTO>();
       connectDB.connect();
        if(connectDB.connect!=null){
            System.out.println("Connected !");
            try{
                Statement s= ConnectDB.connect.createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM course,department where course.DepartmentID=department.DepartmentID");
                while(rs.next())
                {
                Course_DTO course = new Course_DTO();
                course.setId(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                Department_DTO department = new Department_DTO();
                department.setId(rs.getInt("DepartmentID"));
                department.setName(rs.getString("Name"));
                course.setDepartment(department);
                listCourse.add(course);
                }    
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                connectDB.closeConnect();
            }
        }else{
            System.out.println("Connection Failed!");
            
    }
        return listCourse;
    
}
}
