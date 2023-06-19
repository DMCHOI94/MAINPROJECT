package com.shoppingmall.none.user.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserMyPageController {
	@GetMapping("/myPage")
	public String myPage() {
		return "myPage/myPage.user";
	}

	@GetMapping("/update")
	public String update() {
		return "myPage/update.user";
	}
}
