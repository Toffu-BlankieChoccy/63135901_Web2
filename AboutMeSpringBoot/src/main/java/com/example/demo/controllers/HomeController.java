package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//Build action
	//Mapping URL
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	
	@GetMapping("/feedback")
	public String feedbackPage() {
		return "feedback";
	}
	
	@GetMapping("/faq")
	public String faqPage() {
		return "faq";
	}
}
