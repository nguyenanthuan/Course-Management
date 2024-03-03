/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DepartmentDAL;
import DTO.Department;
import DTO.OnlineCourse;
import DTO.Person;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DepartmentBLL {
    DepartmentDAL depDal;
    public DepartmentBLL() {
        depDal = new DepartmentDAL();
    }
    public List LoadDepartment(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = depDal.readDepartment();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }
    public Department getDepartment(int departmentId) throws SQLException {
        Department dpm = depDal.getDepartment(departmentId);
        return dpm;
    }
     public List LoadDepartments(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = depDal.readDepartments();
        int size = list.size();
        int from, to;
        from = (page -1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
   
    }
    public ArrayList<Department> getAllDepartments() {
        try {
            return depDal.readDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Trả về danh sách rỗng nếu có lỗi
        }
    }
    public int insertDepartment(Department d) throws SQLException {
        return depDal.insertDepartment(d);
    }
    public int deleteDepartment(Department d) throws SQLException {
        return depDal.deleteDepartment(d);
    }
    public int updateDepartment(Department d) throws SQLException {
        return depDal.updateDepartment(d);
    }
    public Person getAdminByDepartmentID(Department dpm) throws SQLException {
        Person p = depDal.getAdministorByDepartment(dpm);
        return p;
    }
    
}
