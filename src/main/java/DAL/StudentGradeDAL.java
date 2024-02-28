/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.StudentGrade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class StudentGradeDAL extends MyDatabaseManager{
    public StudentGradeDAL(){
        StudentDAL.connectDB();
    }
    public void readStudentGrades() throws SQLException {
        String query = "SELECT * FROM StudentGrade";
        ResultSet rs = StudentGradeDAL.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            System.out.println("EnrollmentID \t CourseID \t StudentID \t Grade");
            while (rs.next()) {
                System.out.print(rs.getInt("EnrollmentID"));
                System.out.println("\t\t" + rs.getInt("CourseID")
                        + "\t\t\t" + rs.getInt("StudentID")
                        + "\t\t\t\t" + rs.getFloat("Grade"));
                i++;
            }
        }
    }
    public ArrayList readStudentGrade() throws SQLException {
        String query = "SELECT * FROM StudentGrade";
        ResultSet rs = StudentGradeDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                StudentGrade sg = new StudentGrade();
                sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                sg.setCourseID(rs.getInt("CourseID"));
                sg.setStudentID(rs.getInt("StudentID"));
                sg.setGrade(rs.getFloat("Grade"));
                list.add(sg);
            }
        }
        return list;
    }
    public StudentGrade getStudentGrade(int enrollmentID) throws SQLException {

        String query = "SELECT * FROM StudentGrade WHERE EnrollmentID = ? ";

        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, enrollmentID);
        ResultSet rs = p.executeQuery();
        
        StudentGrade sg = new StudentGrade();
        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                //sg.getCourseID(rs.getInt("CourseID"));
                sg.setCourseID(rs.getInt("CourseID"));
                sg.setStudentID(rs.getInt("StudentID"));
                sg.setGrade(rs.getFloat("Grade"));
            }
        }
        return sg;
    }
    public boolean updateStudentGrade(StudentGrade sg) throws SQLException {
        String query = "Update StudentGrade SET CourseID = ? , StudentID = ? , Grade = ?"
                + " WHERE EnrollmentID = ?";
        try(PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);){
        p.setInt(1, sg.getCourseID());
        p.setInt(2, sg.getStudentID());
        p.setFloat(3, sg.getGrade());
        p.setInt(4, sg.getEnrollmentID());
        int result = p.executeUpdate();
        return result>0;
        }
    }
     public int insertStudentGrade(StudentGrade sg) throws SQLException {
        String query = "Insert StudentGrade (CourseID, StudentID, Grade) VALUES (?, ?, ?)";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, sg.getCourseID());
        p.setInt(2, sg.getStudentID());
        p.setFloat(3, sg.getGrade());
        int result = p.executeUpdate();
        return result;
    }
     public void findStudentGrade(int studentID) throws SQLException {
        String query = "SELECT * FROM StudentGrade WHERE StudentID = ?";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, studentID);
        ResultSet rs = p.executeQuery();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                System.out.print(rs.getInt("EnrollmentID"));
                System.out.println("\t\t" + rs.getInt("CourseID")
                        + "\t\t\t" + rs.getInt("StudentID")
                        + "\t\t\t\t" + rs.getFloat("Grade"));
                i++;
            }
        } else {
            System.out.println("Not found");
        }
    }
     public List findStudentGrades(int studentID) throws SQLException {
        String query = "SELECT * FROM StudentGrade WHERE StudentID = ?";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, studentID);
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                StudentGrade sg = new StudentGrade();
                sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                sg.setCourseID(rs.getInt("CourseID"));
                sg.setStudentID(rs.getInt("StudentID"));
                sg.setGrade(rs.getFloat("Grade"));
                list.add(sg);
            }
        }
        return list;
    }
    public boolean deleteStudentGrade(int enrollmentID) throws SQLException {
        String query = "DELETE FROM StudentGrade WHERE EnrollmentID = ?";
        try(PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);){
            p.setInt(1, enrollmentID);
            int result = p.executeUpdate();
            return result>0;
        }
    }
}
