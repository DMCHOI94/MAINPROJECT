package com.shoppingmall.none.admin.adminMain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminMainController {

	// 메인 페이지
	@GetMapping("adminMain")
	public String adminMain() {
		System.out.println("관리자 메인페이지 들어옴");
		return "admin/adminMain";
	}

}
