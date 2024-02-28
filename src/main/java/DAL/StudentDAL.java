/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class StudentDAL extends MyDatabaseManager{
    public StudentDAL() {

        StudentDAL.connectDB();
    }

    //1 layer
    public void readStudents() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
        ResultSet rs = StudentDAL.doReadQuery(query);
        if (rs != null) {
            int i = 1;
            System.out.println("TT \t PersonID \t FirstName \t\t LastName");
            while (rs.next()) {

                System.out.print(i + "\t" + rs.getInt("PersonID"));
                System.out.println("\t\t" + rs.getString("FirstName")
                        + "\t\t\t" + rs.getString("LastName"));
                i++;
            }
        }
    }

    //2 layer
    public ArrayList readStudent() throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate >0";
        ResultSet rs = StudentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                list.add(s);
            }
        }
        return list;
    }

    public Student getStudent(int personID) throws SQLException {

        String query = "SELECT * FROM Person WHERE EnrollmentDate >0 AND PersonID = ? ";

        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        ResultSet rs = p.executeQuery();
        
        Student s = new Student();
        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(Date.valueOf(rs.getString("EnrollmentDate")));
            }
        }
        return s;

    }

    public int updateStudent(Student s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? "
                + " WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonId());
        int result = p.executeUpdate();
        return result;
    }

    public int insertStudent(Student s) throws SQLException {
        String query = "Insert Person (FirstName, LastName, EnrollmentDate) VALUES (?, ?, ?)";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setString(3, s.getEnrollmentDate().toString());
        int result = p.executeUpdate();
        return result;
    }

    //1 
    public void findStudent(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();

        if (rs != null) {
            int i = 1;
            while (rs.next()) {
                System.out.print(rs.getInt("PersonID") + " - ");
                System.out.println(rs.getString("Lastname") + " "
                        + rs.getString("Firstname"));
                i++;
            }
        } else {
            System.out.println("Not found");
        }

    }

    //3 layer
    public List findStudents(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        List list = new ArrayList();

        if (rs != null) {
            int i = 1;

            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                list.add(s);
            }
        }
        return list;
    }

    public int deleteStudent(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();

        return result;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int choice = 1;
        System.out.println("Quan ly thong tin sinh vien:");
        System.out.println("----------------------------");
        //System.out.print("Enter 0: Exits; \t    1: List ; \t 2: Insert ; \t 3: Update  \t 4: Delete \t5. Find: ");
        try {

            StudentDAL s = new StudentDAL();

            Student st = new Student();
            while (choice > 0) {
                System.out.println("Enter 0: Exits; \t1: List ; \t 2: Insert ; \t 3: Update\t 4: Delete \t5. Find: ");
                choice = Integer.parseInt(in.nextLine());
                switch (choice) {
                    case 1 ->
                        s.readStudents();
                    case 2 -> {
                        System.out.println("Firstname: ");
                        String firstName = in.nextLine();
                        System.out.println("Lastname: ");
                        String lastName = in.nextLine();
                        st.setLastName(lastName);
                        st.setFirstName(firstName);
                        long millis = System.currentTimeMillis();
                        java.sql.Date date = new java.sql.Date(millis);
                        st.setEnrollmentDate(date);
                        if (s.insertStudent(st) != 0) {
                            System.out.println("Complete insert ");
                        } else {
                            System.out.println("Nothing insert ");
                        }
                    }
                    case 3 -> {
                        System.out.println("Enter PersonID to Update: ");
                        int personID = Integer.parseInt(in.nextLine());
                        st.setPersonId(personID);
                        System.out.println("Firstname: ");
                        String firstName2 = in.nextLine();
                        System.out.println("Lastname: ");
                        String lastName2 = in.nextLine();
                        st.setLastName(lastName2);
                        st.setFirstName(firstName2);
                        if (s.updateStudent(st) != 0) {
                            System.out.println("Complete update");
                        } else {
                            System.out.println("Complete update");
                        }
                    }
                    case 4 -> {
                        System.out.println("Enter PersonID to delete: ");
                        int personID = Integer.parseInt(in.nextLine());
                        if (s.deleteStudent(personID) != 0) {
                            System.out.println("Complete delete");
                        } else {
                            System.out.println("Nothing delete");

                        }
                    }
                    case 5 -> {
                        System.out.println("Enter fullname to search: ");

                        String fullName = in.nextLine();
                        s.findStudent(fullName);
                    }
                    default ->
                        System.out.println("Enter number not match");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
