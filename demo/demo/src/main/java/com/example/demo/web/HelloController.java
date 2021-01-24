package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody 

public class HelloController {

	@RequestMapping("*")
	public String hello() {
		return "Hello Spring";
	}

	@RequestMapping("/index")
	public String index() {
		return "This is the main page.";
	}	

	@RequestMapping("/contact")
	public String contact() {
		return "This is the contact page";	
	}

	@RequestMapping("/hello")
	public String hello(@RequestParam String name, String location) {
		return "Hello to the " + location + ", " + name + "!";
	}
}

