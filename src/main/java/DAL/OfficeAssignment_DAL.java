/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.ConnectDB;
import DTO.OfficeAssignment_DTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class OfficeAssignment_DAL {
    ConnectDB connectDB=new ConnectDB();
    public Vector<OfficeAssignment_DTO> readOfficeAssignment()
    {
       Vector<OfficeAssignment_DTO> listOffice =new Vector<OfficeAssignment_DTO>();
       connectDB.connect();
        if(connectDB.connect!=null){
            System.out.println("Connected !");
            try{
                Statement s= ConnectDB.connect.createStatement();
                ResultSet rs = s.executeQuery("SELECT person.*,officeassignment.* from person,officeassignment WHERE person.PersonID=officeassignment.InstructorID");
                while(rs.next())
                {
                OfficeAssignment_DTO officeAsign = new OfficeAssignment_DTO();
                officeAsign.setId(rs.getInt("PersonID"));
                officeAsign.setLastName(rs.getString("Lastname"));
                officeAsign.setFirstName(rs.getString("Firstname"));
                officeAsign.setHireDate(rs.getDate("HireDate"));
                officeAsign.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                officeAsign.setLocation(rs.getString("Location"));
                officeAsign.setTimeStamp(rs.getTimestamp("Timestamp"));
  
                listOffice.add(officeAsign);
                }    
            }catch(SQLException ex){
                System.out.println(ex);
            }finally{
                connectDB.closeConnect();
            }
        }else{
            System.out.println("Connection Failed!");
            
    }
        return listOffice;
    
}
    public Vector<OfficeAssignment_DTO> All_Search(String condition) throws SQLException{
        Vector<OfficeAssignment_DTO> list = new Vector<OfficeAssignment_DTO>();
        connectDB.connect();
        if(connectDB.connect!=null){
            try{
                String sql="SELECT person.*,officeassignment.* FROM person,officeassignment WHERE person.PersonID=officeassignment.InstructorID AND "+condition;
                PreparedStatement stmt = ConnectDB.connect.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    OfficeAssignment_DTO officeAsign = new OfficeAssignment_DTO();
                officeAsign.setId(rs.getInt("PersonID"));
                officeAsign.setLastName(rs.getString("Lastname"));
                officeAsign.setFirstName(rs.getString("Firstname"));
                officeAsign.setHireDate(rs.getDate("HireDate"));
                officeAsign.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                officeAsign.setLocation(rs.getString("Location"));
                officeAsign.setTimeStamp(rs.getTimestamp("Timestamp"));
 
                list.add(officeAsign);
                }
            }catch(SQLException e){
                System.out.println("DAL"+e);
            }finally{
                connectDB.closeConnect();
            }
        }
        return list;
    }
}
