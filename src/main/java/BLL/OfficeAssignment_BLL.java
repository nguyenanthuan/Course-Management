/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OfficeAssignment_DAL;
import DTO.OfficeAssignment_DTO;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class OfficeAssignment_BLL {
    private static OfficeAssignment_DAL officeAsDAL = new OfficeAssignment_DAL();
    Vector<OfficeAssignment_DTO> officeList=null;

    public OfficeAssignment_BLL() {
        officeList=officeAsDAL.readOfficeAssignment();
    }

    public Vector<OfficeAssignment_DTO> getOfficeList() {
        return officeList;
    }
    
    
    public Vector<OfficeAssignment_DTO> readOfficeAssignment()
    {
        officeList=officeAsDAL.readOfficeAssignment();
        return officeList;
    }
     public OfficeAssignment_DTO getOfficeAssignmentById(int id)
   {
       for (OfficeAssignment_DTO i:officeList)
       {
           if (i.getId()==id)
           {
               return i;
           }
       }
       return null;
   }
     public Vector<OfficeAssignment_DTO> All_Search(String condition) throws SQLException{
         officeList=officeAsDAL.All_Search(condition);
         return officeList;
     }
}
