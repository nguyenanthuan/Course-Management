/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentGradeDAL;
import DTO.StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class StudentGradeBLL {
    StudentGradeDAL sgDal;
    public StudentGradeBLL() {
        sgDal = new StudentGradeDAL();
    }
    public List LoadStudentGrade(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = sgDal.readStudentGrade();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }
    public List findStudentGrade(int studentID) throws SQLException {
        List list = new ArrayList();

        list = sgDal.findStudentGrades(studentID);

        return list;

    }
    public StudentGrade getStudentGrade(int enrollmentID) throws SQLException
    {
        StudentGrade sg = sgDal.getStudentGrade(enrollmentID);
        return sg;
    }
    public int addStudentGrade(StudentGrade sg) throws SQLException {
        int result = sgDal.insertStudentGrade(sg);
        return result;
    }

    public boolean deleteStudentGrade(int enrollmentID) throws SQLException {
        return sgDal.deleteStudentGrade(enrollmentID);
    }

   public boolean updateStudentGrade(StudentGrade sg) throws SQLException {
        return sgDal.updateStudentGrade(sg);
    }
    
}
