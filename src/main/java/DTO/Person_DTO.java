/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Person_DTO {
    private int id;
    private String lastName;
    private String firstName;
    private Date HireDate;
    private Date EnrollmentDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }

    public void setEnrollmentDate(Date EnrollmentDate) {
        this.EnrollmentDate = EnrollmentDate;
    }
   

    public Person_DTO() {
    }

    public Person_DTO(int id, String lastName, String firstName, Date HireDate, Date EnrollmentDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.HireDate = HireDate;
        this.EnrollmentDate = EnrollmentDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getName() {
        return lastName +" "+ firstName;
    }

    

    public int getId() {
        return id;
    }

   

   

    public Date getHireDate() {
        return HireDate;
    }

    public Date getEnrollmentDate() {
        return EnrollmentDate;
    }
    
}
