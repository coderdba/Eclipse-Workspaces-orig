package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//servlet response related
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

//exceptions
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class CookieController1 {

	@GetMapping("/setcookie/{myCookieName}")
	void setCookie(@PathVariable String myCookieName, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie cookie1 = new Cookie("myCookieName", request.getParameter(myCookieName));
		cookie1.setMaxAge(10);
		
		response.addCookie(cookie1);
		
	      PrintWriter out = response.getWriter();
	      String title = "Setting Cookies Example";
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
	}
}
