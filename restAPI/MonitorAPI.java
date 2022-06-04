package com.restapidemo.demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.PrintWriter;
import java.util.*;

import com.google.gson.Gson;
import java.io.*;
import java.util.*;
@Path("/hiworld")
@Provider
public class MonitorAPI implements ContainerResponseFilter{
	@Override
	   public void filter(final ContainerRequestContext requestContext,
	                      final ContainerResponseContext cres) throws IOException {
	      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
	      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
	      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
	  }
	@GET
	@Path("/getSystemUsage")
	@Produces("application/json")
	public String getSystemUse() {
		
		String feed=null;
		try {
			List<Monitor> listMonitor=null;
			MonitorService monitorService=new MonitorService();
			listMonitor=monitorService.getRecords();
			Gson gson=new Gson();
			System.out.println(gson.toJson(listMonitor));
			feed=gson.toJson(listMonitor);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return feed;
		
	}
}


