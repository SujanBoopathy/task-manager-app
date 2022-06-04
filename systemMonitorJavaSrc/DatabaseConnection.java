/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systemmanager;
import java.sql.*;


/**
 *
 * @author Saubali
 */
public class DatabaseConnection {
    public void connectDB(double CpuUsage,long MemoryUsage,long currentTimeMillis) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/systemmonitor";
        Connection connection=DriverManager.getConnection(url,"java","password");
        
        
        Statement stmt=connection.createStatement();
        
        String query="insert into cpu_memory_usage values ( "+ CpuUsage + " , " + MemoryUsage +" , " + currentTimeMillis +" ) " ;
        
        stmt.executeUpdate(query);
        
        
    }
}
