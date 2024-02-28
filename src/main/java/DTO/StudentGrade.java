/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ACER
 */
public class StudentGrade {
    int enrollmentID;
    int courseID;
    int studentID;
    float grade;
    
    public StudentGrade(){
        
    }
     public StudentGrade(int enrollmentID, int courseID, int studentID, float grade){
         this.enrollmentID=enrollmentID;
         this.courseID=courseID;
         this.studentID=studentID;
         this.grade=grade;
     }

    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    
    
}
