package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//servlet response related
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
public class TestController1 {
  
  @GetMapping("/hellome")
  String hellome() {
    return "Hello You!";
  }
  
  @GetMapping("/getme/{thing}")
  String getme(@PathVariable String thing) {
    return "Got " + thing;
  }
  
  @GetMapping("/googleitnow/{thing}")
   void googleit(@PathVariable String thing, HttpServletResponse response) throws IOException {
    response.sendRedirect("https://www.google.com/search?q=" + thing);
  }
  
  @GetMapping("/mycookie/{cookiename}")
   void mycookie(@PathVariable String cookiename, HttpServletResponse response) throws IOException {
    
	// create cookies
    Cookie aCookie = new Cookie("aCookieName",cookiename);
    
    //http://www.java2s.com/Code/Java/Servlets/Usecookietosavesessiondata.htm
    Cookie sessionIdCookie = new Cookie("sessionId", generateSessionId());
    
    
    // content type
    response.setContentType("text/html");
    
    // add cookies
    response.addCookie(aCookie);
    response.addCookie(sessionIdCookie);
    
    // headers
    response.setHeader("thisMyHeader1", "hey hey");
    response.setHeader("thisMyHeader2", "hey hey hey");
    
    // body
    //response.getWriter().write("A cookie is - " + cookiename);
    response.getWriter().write("A cookie name is - " + aCookie.getName() + ", value is - " + aCookie.getValue() + "<br>" + 
    							"Session Id Cookie name is - " + 
    							sessionIdCookie.getName() + ", value is - " + sessionIdCookie.getValue());	
    								
    response.getWriter().flush();
    response.getWriter().close();
    
  }
  
  // http://www.java2s.com/Code/Java/Servlets/Usecookietosavesessiondata.htm
  private static String generateSessionId() throws UnsupportedEncodingException {
	    String uid = new java.rmi.server.UID().toString(); // guaranteed unique
	    return URLEncoder.encode(uid,"UTF-8"); // encode any special chars
	  }
  
}