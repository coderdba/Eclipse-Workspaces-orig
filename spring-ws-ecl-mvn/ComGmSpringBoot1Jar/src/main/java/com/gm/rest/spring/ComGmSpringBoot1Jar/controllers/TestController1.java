package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//servlet response related
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import java.net.URLEncoder;

//exceptions
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
   void mycookie(@PathVariable String cookiename, HttpServletRequest request, HttpServletResponse response) throws IOException {
    
	// http session - https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
	HttpSession session = request.getSession();
	session.setAttribute("user", "myselfTheUser");
	//setting session to expiry in N sec
	session.setMaxInactiveInterval(10); // or (30*60) for 30 min
	
	// more code from - https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
	//Cookie userName = new Cookie("user", user);
	//userName.setMaxAge(30*60);
	//response.addCookie(userName);
	//response.sendRedirect("LoginSuccess.jsp");
	  
	// create cookies
    Cookie aCookie = new Cookie("aCookieName",cookiename);
    
    //http://www.java2s.com/Code/Java/Servlets/Usecookietosavesessiondata.htm
    //Cookie sessionIdCookie = new Cookie("sessionId", generateSessionId());
    
    Cookie sessionIdCookie = new Cookie("sessionId", request.getSession().getId());
    sessionIdCookie.setMaxAge(10); //seconds
    
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
    							sessionIdCookie.getName() + ", value is - " + sessionIdCookie.getValue()
	+ "Session Id Cookie expiry seconds is - " + 
	 sessionIdCookie.getMaxAge());	   			
    								
    response.getWriter().flush();
    response.getWriter().close();
    
  }
  
  // http://www.java2s.com/Code/Java/Servlets/Usecookietosavesessiondata.htm
  private static String generateSessionId() throws UnsupportedEncodingException {
	    String uid = new java.rmi.server.UID().toString(); // guaranteed unique
	    return URLEncoder.encode(uid,"UTF-8"); // encode any special chars
	  }
  
}