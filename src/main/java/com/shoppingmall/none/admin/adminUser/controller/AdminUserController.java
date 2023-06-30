package com.shoppingmall.none.admin.adminUser.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingmall.none.admin.adminLogin.vo.AdminLoginVo;
import com.shoppingmall.none.admin.adminUser.service.AdminUserService;
import com.shoppingmall.none.admin.adminUser.vo.AdminUserVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;
	private AdminUserVo adminUserVo;

	// 회원관리 페이지 들어옴
	@GetMapping("/adminUser")
	public String adminUser(HttpSession session) {
		System.out.println("회원관리 페이지 들어옴");
		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {
			return "admin/adminUser";
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return "redirect:/adminLogin";
		}
	}

	// 회원관리 페이지
	@PostMapping("/adminUserInfo")
	@ResponseBody
	public ModelAndView adminUserInfo(@ModelAttribute AdminLoginVo adminLoginVo, HttpSession session) {
		System.out.println("관리자 회원관리 들어옴");
		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {
			ModelAndView mav = new ModelAndView("admin/adminUser");
			mav.addObject("userList", adminUserService.adminUserInfo(adminUserVo));
			System.out.println("mav : " + mav);
			return mav;
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return new ModelAndView("redirect:/adminLogin");
		}
	}

}
