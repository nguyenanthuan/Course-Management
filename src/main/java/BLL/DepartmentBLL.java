/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DepartmentDAL;
import DTO.Department;
import DTO.OnlineCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DepartmentBLL {
    DepartmentDAL dpmdal;
    public DepartmentBLL() {
        dpmdal = new DepartmentDAL();
    }
    public List LoadDepartment(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = dpmdal.readDepartment();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;
        return list.subList(from, Math.min(to, size));
    }
    public Department getDepartment(int departmentId) throws SQLException {
        Department dpm = dpmdal.getDepartment(departmentId);
        return dpm;
    }
}
