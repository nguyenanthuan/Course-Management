/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.ListCourseInstructor_DAL;
import DTO.CourseInstructor_DTO;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class ListCourseInstructor_BLL {
    private static ListCourseInstructor_DAL listCIns = new ListCourseInstructor_DAL() ;
 Vector<CourseInstructor_DTO> courseListInstructor=null;
    public ListCourseInstructor_BLL() {
        courseListInstructor=listCIns.readCourseInstructor();
    }
    
     public Vector<CourseInstructor_DTO> readCourseInstructor()
    {
        courseListInstructor=listCIns.readCourseInstructor();
        return courseListInstructor;
    }
     public Vector<CourseInstructor_DTO> All_Search(String condition) throws SQLException{
         courseListInstructor=listCIns.All_Search(condition);
         return courseListInstructor;
     }
      public CourseInstructor_DTO getCourseInstructorById(int idPerson,int idCourse)
   {
       for (CourseInstructor_DTO i:courseListInstructor)
       {
           
           if ((i.getCourse().getId()==idCourse)&&(i.getPerson().getId()==idPerson))
           {
               return i;
           }
       }
       return null;
   }

    public Vector<CourseInstructor_DTO> getCourseListInstructor() {
        return courseListInstructor;
    }
      
      public Vector<CourseInstructor_DTO> CourseNInstructor()
      {
          Vector<CourseInstructor_DTO> listcInDTO=new Vector<CourseInstructor_DTO>() ;
          for (CourseInstructor_DTO i:courseListInstructor)
          {
              if (i.getPerson().getId()==-1)
              {
                  listcInDTO.add(i);
              }
          }
         
          return listcInDTO ;
      }
       public Vector<CourseInstructor_DTO> CourseInstructor()
      {
          Vector<CourseInstructor_DTO> listcInDTO=new Vector<CourseInstructor_DTO>() ;
          for (CourseInstructor_DTO i:courseListInstructor)
          {
              if (i.getPerson().getId()!=-1)
              {
                  listcInDTO.add(i);
              }
          }
          
          return listcInDTO ;
      }
       public CourseInstructor_DTO getCourseById(int idCourse)
   {
       for (CourseInstructor_DTO i:courseListInstructor)
       {
          
           if (i.getCourse().getId()==idCourse)
           {
               return i;
           }
       }
       return null;
   }
        public CourseInstructor_DTO getPersonById(int idPerson)
   {
       for (CourseInstructor_DTO i:courseListInstructor)
       {
          
           if (i.getPerson().getId()==idPerson)
           {
               return i;
           }
       }
       return null;
   }
      public String deleteCourseInstructor(int personID,int courseID)
      {
          return listCIns.deleteCourseInstructor(personID, courseID);
      }
        public String addCourseInstructor(int personID,int courseID)
        {
            return  listCIns.addCourseInstructor(personID,courseID);
        }
       public String updateCourseInstructor(int personID1,int personID2,int courseID)
       {
           return listCIns.updateCourseInstructor(personID1,personID2,courseID);
       }
}
