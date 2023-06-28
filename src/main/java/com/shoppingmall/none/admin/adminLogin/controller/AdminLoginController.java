package com.shoppingmall.none.admin.adminLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminLoginController {
	// 로그인
	@GetMapping("adminLogin")
	public String adminLogin() {
		System.out.println("관리자 로그인 들어옴");
		return "admin/adminLogin";
	}
}
