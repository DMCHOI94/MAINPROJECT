package com.shoppingmall.none.admin.adminUser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminUserController {
	// 로그인
	@GetMapping("adminUser")
	public String adminUser() {
		System.out.println("관리자 회원관리 들어옴");
		return "admin/adminUser";
	}
}
