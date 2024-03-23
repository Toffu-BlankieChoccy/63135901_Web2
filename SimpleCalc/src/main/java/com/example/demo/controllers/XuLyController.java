package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class XuLyController {
	// Add
	@GetMapping("/add")
	public String traVeFormTinh()
	{
		return "tinhtong";
	}
	
	@GetMapping("/addCal")
	public String tinhTong(@RequestParam("a") int soA, 
							@RequestParam("b") int soB,
							Model m) {
		//Đưa dữ liệu vào model
		m.addAttribute("aaa", soA);
		m.addAttribute("bbb", soB);
		m.addAttribute("sum", soA + soB);
		
		return "tinhTong";
	}
}
