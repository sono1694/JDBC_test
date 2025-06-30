package com.example.demo.t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.t.dto.DetailUser;
import com.example.demo.t.service.CustomerService;

@Controller
public class indexController {
	
	private final CustomerService customerService;
	
	public indexController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/dataInputForm")
	public String dataInputForm() {
		return "dataInputForm";
	}

	@Autowired
	private CustomerService cs;
	
	@PostMapping("/submit")
	public String handleSubmit(@ModelAttribute DetailUser detailUser) {
		// DB接続メソッド指定
		cs.jdbcConect(detailUser);

		return "result";
	}
}
