package com.shoppingmall.none.user.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMyPageController {

	// 마이페이지
	@GetMapping("/myPage")
	public String myPage() {
		return "myPage/myPage.user";
	}

	// 정보수정
	@GetMapping("/update")
	public String update() {
		return "myPage/update.user";
	}

	// 정보수정 정보 전달
	@PostMapping("/updateInfo")
	public String updateInfo() {

	}
}
