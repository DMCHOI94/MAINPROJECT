package com.shoppingmall.none.admin.adminBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminBoardController {
	// 게시판관리
	@GetMapping("adminBoard")
	public String adminBoard() {
		System.out.println("adminBoard 들어옴");
		return "admin/adminBoard";
	}
}
