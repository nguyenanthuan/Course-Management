/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DTO.Student;
import DAL.StudentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class StudentBLL {
    StudentDAL stdDal;

    public StudentBLL() {
        stdDal = new StudentDAL();
    }

    public List LoadStudents(int page) throws SQLException {
        int numofrecords = 30;
        ArrayList list = stdDal.readStudent();
        int size = list.size();
        int from, to;
        from = (page - 1) * numofrecords;
        to = page * numofrecords;

        return list.subList(from, Math.min(to, size));
    }

    public List findStudent(String fullname) throws SQLException {
        List list = new ArrayList();

        list = stdDal.findStudents(fullname);

        return list;

    }
    public Student getStudent(int personID) throws SQLException
    {
        Student s = stdDal.getStudent(personID);
        return s;
    }

    public int addStudent(Student s) throws SQLException {
        int result = stdDal.insertStudent(s);
        return result;
    }

    public static void main(String[] args) {
        try {
            StudentBLL stdBll = new StudentBLL();
            List data = stdBll.LoadStudents(1);
            Student s = (Student) data.get(0);
            System.out.println(s.getFirstName());
            System.out.println("Nothing");

        } catch (SQLException ex) {
            Logger.getLogger(StudentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
