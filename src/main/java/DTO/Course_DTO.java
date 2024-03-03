/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ADMIN
 */
public class Course_DTO {
    private int id;
    private String title;
    private int credits ;
    private Department_DTO department;

    public Course_DTO(int id, String title, int credits, Department_DTO department) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.department = department;
    }

    public Course_DTO() {
       
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setDepartment(Department_DTO department) {
        this.department = department;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    public Department_DTO getDepartment() {
        return department;
    }

   
}
