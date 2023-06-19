package com.shoppingmall.none.user.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProductController {
	@GetMapping("/product")
	public String product() {
		return "product/product.user";
	}

	@GetMapping("/breadList")
	public String breadList() {
		return "product/breadList.user";
	}

	@GetMapping("/dessertList")
	public String dessertList() {
		return "product/dessertList.user";
	}

	@GetMapping("/jamList")
	public String jamList() {
		return "product/jamList.user";
	}

	@GetMapping("/snackList")
	public String snackList() {
		return "product/snackList.user";
	}

	@GetMapping("/bread1")
	public String bread1() {
		return "product/bread1.user";
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
