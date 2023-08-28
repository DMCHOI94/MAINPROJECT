package com.shoppingmall.none.user.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoppingmall.none.user.product.service.UserProductService;
import com.shoppingmall.none.user.product.vo.UserProductVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserProductController {

	private final UserProductService userProductService;

	@GetMapping("/product")
	public String product() {
		return "product/product.user";
	}

	@GetMapping("/bread1")
	public UserProductVo bread1(String bread) {
		System.out.println("bread1에 들어옴");
		bread = "bread";
		List<UserProductVo> result = userProductService.bread1(bread);
		UserProductVo userProductVo = result.get(0);
		System.out.println("controller result : " + result);

		if (!result.isEmpty()) {

			System.out.println("controller result : " + result);
			System.out.println("seq : " + userProductVo.getProductSeq());
			System.out.println("name : " + userProductVo.getProductName());
			System.out.println("classfi : " + userProductVo.getProductClassification());

			if (userProductVo.getProductClassification() != "bread") {
				System.out.println("성공");
				return userProductVo;
			} else {
				System.out.println("실패");
				return userProductVo;
			}
		}
		System.out.println("result 비어있음");
		return userProductVo;
	}

	@GetMapping("/bread2")
	public String bread2() {
		return "product/bread2.user";
	}

	@GetMapping("/bread3")
	public String bread3() {
		return "product/bread3.user";
	}

	@GetMapping("/bread4")
	public String bread4() {
		return "product/bread4.user";
	}

	@GetMapping("/bread5")
	public String bread5() {
		return "product/bread5.user";
	}

	@GetMapping("/bread6")
	public String bread6() {
		return "product/bread6.user";
	}
}
