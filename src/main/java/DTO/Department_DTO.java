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
public class Department_DTO {
    private int id;
    private String name;
    private double budget;
    private Date dateTime;
    private int Administrator ;

    public Department_DTO(int id, String name, double budget, Date dateTime, int Administrator) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.dateTime = dateTime;
        this.Administrator = Administrator;
    }

    public Department_DTO() {
       
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getAdministrator() {
        return Administrator;
    }
    
    
}
