/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Course_DAL;
import DTO.Course_DTO;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class Course_BLL {
     private static Course_DAL courseDAL = new Course_DAL();
     Vector<Course_DTO> courseList=null;

    public Course_BLL() {
        courseList=courseDAL.readCourse();
    }
    
   public Vector<Course_DTO> readCourse()
    {
        return courseList;
    }
   public Course_DTO getCourseById(int id)
   {
       for (Course_DTO i:courseList)
       {
           if (i.getId()==id)
           {
               return i;
           }
       }
       return null;
   }
}
