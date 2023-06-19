package com.shoppingmall.none.user.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMainController {
	// 메인 페이지
	@GetMapping("/")
	public String mainPage() {
		return "main/main.user";
	}
}
