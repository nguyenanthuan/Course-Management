/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class OfficeAssignment_DTO extends Person_DTO {
    private String location;
    private Timestamp timeStamp;

    public OfficeAssignment_DTO(String location, Timestamp timeStamp, int id, String lastName, String firstName, Date HireDate, Date EnrollmentDate) {
        super(id, lastName, firstName, HireDate, EnrollmentDate);
        this.location = location;
        this.timeStamp = timeStamp;
    }
    public OfficeAssignment_DTO(int id, String lastName, String firstName, Date HireDate, Date EnrollmentDate) {
        super(id, lastName, firstName, HireDate, EnrollmentDate);
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public OfficeAssignment_DTO() {
        
    }

    public String getLocation() {
        return location;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
    
    
}
