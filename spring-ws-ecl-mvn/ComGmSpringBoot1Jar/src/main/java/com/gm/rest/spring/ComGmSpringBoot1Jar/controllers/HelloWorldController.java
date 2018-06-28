package com.gm.rest.spring.ComGmSpringBoot1Jar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping
  String hello() {
    return "Hello World! Spring Boot1";
  }
}