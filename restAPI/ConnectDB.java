package com.restapidemo.demorest;
import java.sql.*;




public class ConnectDB {
	public static Connection connect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/SystemMonitor";
        String userName="java";
        String password="password";
        Connection connection=DriverManager.getConnection(url,userName,password);
        
        return connection;
	}
	
		
	
}
