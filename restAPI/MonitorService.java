package com.restapidemo.demorest;
import java.util.*;
import java.sql.*;


public class MonitorService {
	public List<Monitor> getRecords(){
		List<Monitor> list=new ArrayList<>();
		Monitor obj2=new Monitor();
		obj2.setCpuUsage(0.333323233);
		obj2.setMemoryUsage(484838838);
		obj2.setCurrentTimeMillis(839393939);
		list.add(obj2);
		try {
			
	        Connection conn=ConnectDB.connect();
			
			Statement stmt=conn.createStatement();
	        String query="select * from cpu_memory_usage";
	        
	        ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Monitor obj=new Monitor();
				obj.setCpuUsage(rs.getDouble("cpu_usage"));
				obj.setMemoryUsage(rs.getLong("memory_usage"));
				obj.setCurrentTimeMillis(rs.getLong("cur_time_millis"));
				list.add(obj);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
