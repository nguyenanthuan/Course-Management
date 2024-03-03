/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class CourseInstructor_DTO {
    private Course_DTO course;
    private Person_DTO person;

    public CourseInstructor_DTO() {
    }

    public CourseInstructor_DTO(Course_DTO course, Person_DTO person) {
        this.course = course;
        this.person = person;
    }
    

    public Course_DTO getCourse() {
        return course;
    }

    public Person_DTO getPerson() {
        return person;
    }
    
    
}
