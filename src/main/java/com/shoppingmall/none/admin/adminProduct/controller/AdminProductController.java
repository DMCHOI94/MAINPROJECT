package com.shoppingmall.none.admin.adminProduct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminProductController {
	// 상품관리
	@GetMapping("adminProduct")
	public String adminProduct() {
		System.out.println("adminProduct 들어옴");
		return "admin/product/adminProduct";
	}
}
