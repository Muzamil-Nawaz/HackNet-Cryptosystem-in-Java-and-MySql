/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rashda Khanzada
 */
public class Connection_DB {
    static Connection con;
    public static Connection makeConnection(){
    if (con == null) {
    try {
        Class.forName("com.mysql.jdbc.Driver");				
    }
    catch(ClassNotFoundException ex) {
        System.out.println(ex.getMessage());
        System.out.println("Driver Not Loading");
    }

      try {
        String url = "jdbc:mysql://localhost:3306/isproject";
        String uname = "root";
        String pwd = "";
        con = DriverManager.getConnection(url, uname, pwd);
        System.out.println("connection created");				
      }
      catch(SQLException e) {
        System.out.println(e.getMessage());       
      }
    }
    return con;
  } 
    public static void close(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Connection_DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
