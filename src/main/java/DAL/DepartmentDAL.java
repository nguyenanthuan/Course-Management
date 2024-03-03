/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Department;
import DTO.OnlineCourse;
import DTO.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ResultSet rs = DepartmentDAL.doReadQuery(querry);
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

    public int deleteCousre(int courseID) throws SQLException {
        String query = "DELETE FROM OnlineCourse WHERE CourseID = ?";
        PreparedStatement p = CourseDAL.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        return result;
    }
    
    public int updateDepartment(Department d) throws SQLException {
        String query = "UPDATE Department SET Name = ?, Budget = ?, StartDate = ? WHERE DepartmentID = ?";
        PreparedStatement ps = DepartmentDAL.getConnection().prepareStatement(query);
        ps.setString(1, d.getName());
        ps.setDouble(2, d.getBudget());
        ps.setDate(3, new java.sql.Date(d.getStartDate().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
        ps.setInt(4, d.getDepartmentID());
        int result = ps.executeUpdate();
        return result;
    }
    
    public int insertDepartment(Department d) throws SQLException {
        String query = "INSERT INTO Department (Name, Budget, StartDate) VALUES (?, ?, ?)";
        PreparedStatement ps = MyDatabaseManager.getConnection().prepareStatement(query);
        ps.setString(1, d.getName());
        ps.setDouble(2, d.getBudget());
        // Chuyển đổi từ java.util.Date sang java.sql.Date
        ps.setDate(3, new java.sql.Date(d.getStartDate().getTime())); 

        int result = ps.executeUpdate();
        return result;
    }


   public int deleteDepartment(Department d) throws SQLException {
        String query = "DELETE FROM Department WHERE DepartmentID = ?";
        PreparedStatement ps = DepartmentDAL.getConnection().prepareStatement(query);
        ps.setInt(1, d.getDepartmentID());
        int result = ps.executeUpdate();
        return result;
    }
   
   public ArrayList<Department> readDepartments() throws SQLException {
        String query = "SELECT * FROM Department ";
        ResultSet rs = DepartmentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        
        if(rs != null) {
            while (rs.next()) {
                Department d = new Department();
                d.setDepartmentID(rs.getInt("DepartmentID"));
                d.setName(rs.getString("Name"));
                d.setBudget(rs.getDouble("Budget"));
                d.setStartDate(rs.getDate("StartDate"));
                d.setAdministrator(rs.getInt("Administrator"));
                list.add(d);
            }
        }
        return list;   
    }
   
   public List readAdministor() throws SQLException{
       String query = "SELECT * FROM Person ";
        ResultSet rs = DepartmentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        
        if(rs != null) {
            while (rs.next()) {
                Person p = new Person();
                p.setPersonID(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("Firstname"));
                p.setLastName(rs.getString("Lastname"));
                list.add(p);
            }
        }
        return list;
   }
   
   public Person getAdministorByDepartment(Department dpm) {
        List lstp = new ArrayList();
        Person tp = new Person(); 
        try {
           lstp = readAdministor();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Object p: lstp) {
            Person temp = (Person)p;
            if(temp.getPersonID() == dpm.getAdministrator()){
                tp = temp;
            }
        }
        return tp;
   }
}
