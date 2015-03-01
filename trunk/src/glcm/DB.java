/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glcm;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mangadul
 */
public class DB {
    
    public Connection conn = null;        
    public Statement stmt = null;
    public ResultSet rs = null;

    public DB()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try {
                conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/disertasi?user=root&password=toor");
                stmt = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } 
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }        
    }
    
    public static void main(String[] args) {                    
    }
    
}
