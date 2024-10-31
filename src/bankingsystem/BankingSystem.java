/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingsystem;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author Nikhil
 */
public class BankingSystem {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        // TODO code application logic here
        
        // call dashboard here
        Connection con;
        HomePage obj= new HomePage();
        obj.show(); //for displaying DashBoard 
        try {
            Class.forName("com.myql.cj.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank2","root","Bank@#123");
            System.out.println(con);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BankingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
}
