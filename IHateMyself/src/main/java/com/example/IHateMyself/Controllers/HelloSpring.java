package com.example.IHateMyself.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpring {
	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
