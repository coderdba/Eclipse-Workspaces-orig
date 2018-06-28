package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//servlet response related
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

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
    
    Cookie cookie = new Cookie("cookiename",cookiename);
    
    response.setContentType("text/html");
    response.addCookie(cookie);
    response.setHeader("thisMyHeader1", "hey hey");
    response.setHeader("thisMyHeader2", "hey hey hey");
    response.getWriter().write("This cookie is - " + cookiename);
    response.getWriter().flush();
    response.getWriter().close();
    
  }
  
}