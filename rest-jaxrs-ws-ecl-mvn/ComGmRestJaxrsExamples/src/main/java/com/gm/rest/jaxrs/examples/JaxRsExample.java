package com.gm.rest.jaxrs.examples;

import java.io.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import javax.servlet.http.HttpServletResponse;

@Path("/jaxrsexample")
public class JaxRsExample {
	
	//@Context 
	//private HttpServletResponse response;
	
	@GET
	@Path("/get1")
	@Produces(MediaType.TEXT_PLAIN)
	public String get1() {
		return ("In Get1 - this ignores all input, produces really no output except this message");
	}
	
	@GET
	@Path("/get2/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String get2(@PathParam("id") int id) {
		return ("In Get2 - input PathParam is " + id);
	}

	@GET
	@Path("/get3")
	@Produces(MediaType.TEXT_PLAIN)
	// Usage /get3?id=10&name=somename
	public String get3(@QueryParam("id") int id, @QueryParam("name") String name) {
		return ("In Get3 - input QueryParam is " + id + "-" + name);
	}
	
	
	@GET
	@Path("/get4")
	@Produces(MediaType.TEXT_HTML)
	// Usage /get4?id=10&name=somename
	public String get4(@Context HttpServletResponse response, @QueryParam("id") int id, @QueryParam("name") String name) {
			
		response.setContentType("text/html");
		response.setHeader("Refresh", "300");
	
        return ("<b>In Get4 - Http response with header " + id + " - " + name);
	}
	
	@GET
	@Path("/get5")
	@Produces(MediaType.TEXT_HTML)
	// Usage /get4?id=10&name=somename
	public void get5(@Context HttpServletResponse response, @QueryParam("id") int id, @QueryParam("name") String name) 
	throws Exception {
			
		response.setContentType("text/html");
		response.setHeader("Refresh", "300");
		
		PrintWriter responseBody = response.getWriter();
		responseBody.print ("<b>In Get5 - Http response with header and body " + id + " - " + name);
		responseBody.close();
	
        //return ("<b>In Get5 - Http response with header and body " + id + " - " + name);
	}	
}
