package com.example.demo.t.controller;

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

	@PostMapping("/submit")
	public String handleSubmit(@ModelAttribute DetailUser detailUser) {
//DB接続メソッド指定
		CustomerService cs = new CustomerService();
		cs.jdbcConect(detailUser);
		
//		System.out.println("名前：" + detailUser.getUserName());
//		System.out.println("年齢：" + detailUser.getAge());
//		System.out.println("性別：" + detailUser.getSex());
//		System.out.println("住所：" + detailUser.getAddress());
//		System.out.println("電話番号：" + detailUser.getTel());
//		System.out.println("メールアドレス：" + detailUser.getMailAddress());
		return "result";
	}
}
