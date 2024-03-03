/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ConnectDB {
     private static String URL = "jdbc:mySQL://localhost:3306/school";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    public static Connection connect;

    public  Connection getConnect() {
        return connect;
    }

    public ConnectDB() {
    }
    
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
     
    } 
    public void closeConnect() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
        }
    }
//    public static void main(String[] args) throws SQLException {
//        if(connect()!=null){
//            System.out.println("Connected !");
////            try{
////                Statement s= connect().createStatement();
////                ResultSet rs = s.executeQuery("SELECT * FROM person");
////                while(rs.next()){
////                    System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
////                }
////            }catch(SQLException ex){
////                System.out.println(ex);
////            }finally{
////                closeConnect(connect());
////            }
//        }else{
//            System.out.println("Connection Failed!");
//            closeConnect(connect());
//        }
//    }
}
