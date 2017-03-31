package com.gm.rest.jaxrs.examples;


import javax.ws.rs.PathParam;

public class ParamBean {
	
	//@PathParam ("pathparam1")
	@PathParam (value="pathparam1")
	private String pathParam;
	
	public String getPathParam() {
		//System.out.println("In ParamBean - getPathParam() - pathParam is - " + pathParam + 
								//" THIS IS NOT WORKING YET - STILL SHOWING PATHPARAM AS NULL");
		return pathParam;
	}
}