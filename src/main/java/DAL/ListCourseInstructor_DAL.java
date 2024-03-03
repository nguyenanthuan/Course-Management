/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import DAL.ConnectDB;
import DTO.CourseInstructor_DTO;
import DTO.Course_DTO;
import DTO.Department_DTO;
import DTO.Person_DTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class ListCourseInstructor_DAL {
    ConnectDB connectDB=new ConnectDB();

    public ListCourseInstructor_DAL() {
    }
    
        public String addCourseInstructor(int personID,int courseID)
        {
            connectDB.connect();
        if(connectDB.connect!=null){
            System.out.println("Connected !");
            try{
                Statement s= ConnectDB.connect.createStatement();
                s.executeUpdate("INSERT into courseinstructor(PersonID,CourseID) VALUES("+personID+","+courseID+")");
                
                }   
            catch(SQLException ex){
                System.out.println(ex);
            }finally{
                connectDB.closeConnect();
            }
        }
        else{
            System.out.println("Connection Failed!");
            
    }
        return "Thêm phân công thành công !";
        }           
    
    public String deleteCourseInstructor(int personID,int courseID)
    {
        connectDB.connect();
        if(connectDB.connect!=null){
            System.out.println("Connected !");
            try{
                Statement s= ConnectDB.connect.createStatement();
                s.executeUpdate("DELETE FROM `courseinstructor` WHERE CourseID="+courseID+" and PersonID="+personID);
                
                }   
            catch(SQLException ex){
                System.out.println(ex);
            }finally{
                connectDB.closeConnect();
            }
        }
        else{
            System.out.println("Connection Failed!");
            
    }
        return "Xóa phân công thành công !";

    }
    public String updateCourseInstructor(int personID1,int personID2,int courseID)
    {
        connectDB.connect();
        if(connectDB.connect!=null){
            System.out.println("Connected !");
            try{
                Statement s= ConnectDB.connect.createStatement();
                s.executeUpdate("update `courseinstructor` set PersonID="+personID2+" where CourseID="+courseID+" and PersonID="+personID1);
                
                }   
            catch(SQLException ex){
                System.out.println(ex);
            }finally{
                connectDB.closeConnect();
            }
        }
        else{
            System.out.println("Connection Failed!");
            
    }
        return "Sửa phân công cho khóa học thành công ";

    }

    public Vector<CourseInstructor_DTO> readCourseInstructor()
    {
       Vector<CourseInstructor_DTO> cInts =new Vector<CourseInstructor_DTO>();
       connectDB.connect();
        if(connectDB.connect!=null){
            System.out.println("Connected !");
            try{
                Statement s= ConnectDB.connect.createStatement();
                ResultSet rs = s.executeQuery("SELECT course.*,courseinstructor.*,person.*,department.* FROM course left join courseinstructor on courseinstructor.CourseID = course.CourseID left JOIN person on courseinstructor.PersonID=person.PersonID left JOIN department on department.DepartmentID=course.DepartmentID");
                while(rs.next())
                {
                Person_DTO person =new Person_DTO();
                if (rs.getString("Lastname")==null)
                {
                person.setId(-1);
                person.setLastName("");
                person.setFirstName("");
                person.setHireDate(null);
                person.setEnrollmentDate(null);
                }
               else
                {
                person.setId(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getDate("HireDate"));
                person.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                }
                
                Department_DTO department = new Department_DTO();
                department.setId(rs.getInt("DepartmentID"));
                department.setName(rs.getString("Name"));
                Course_DTO course = new Course_DTO();
                course.setId(rs.getInt("CourseID"));
                course.setTitle(rs.getString("Title"));
                course.setCredits(rs.getInt("Credits"));
                course.setDepartment(department);
                cInts.add(new CourseInstructor_DTO(course,person));
                }    
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                connectDB.closeConnect();
            }
        }else{
            System.out.println("Connection Failed!");
            
    }
        return cInts;
}
    public Vector<CourseInstructor_DTO> All_Search(String condition) throws SQLException{
        Vector<CourseInstructor_DTO> list = new Vector<CourseInstructor_DTO>();
        connectDB.connect();
        if(connectDB.connect!=null){
            try{
                String sql="SELECT course.*,courseinstructor.*,person.*,department.* FROM course left join courseinstructor on courseinstructor.CourseID = course.CourseID left JOIN person on courseinstructor.PersonID=person.PersonID left JOIN department on department.DepartmentID=course.DepartmentID"
                        +" where "
                        + condition;
                PreparedStatement stmt = ConnectDB.connect.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Person_DTO person =new Person_DTO();
                    
                   if (rs.getString("Lastname")==null)
                {
                person.setId(-1);
                person.setLastName("");
                person.setFirstName("");
                person.setHireDate(null);
                person.setEnrollmentDate(null);
                }
               else
                {
                person.setId(rs.getInt("PersonID"));
                person.setLastName(rs.getString("Lastname"));
                person.setFirstName(rs.getString("Firstname"));
                person.setHireDate(rs.getDate("HireDate"));
                person.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                }
                    Department_DTO department = new Department_DTO();
                    department.setId(rs.getInt("DepartmentID"));
                    department.setName(rs.getNString("Name"));
                    Course_DTO course = new Course_DTO();
                    course.setId(rs.getInt("CourseID"));
                    course.setTitle(rs.getNString("Title"));
                    course.setCredits(rs.getInt("Credits"));
                    course.setDepartment(department);
                    list.add(new CourseInstructor_DTO(course, person));
                }
            }catch(SQLException e){
                System.out.println("DAL"+e);
            }finally{
                connectDB.closeConnect();
            }
        }
        return list;
    }
}

