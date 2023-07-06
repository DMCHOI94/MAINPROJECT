package com.shoppingmall.none.admin.adminUser.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	private ObjectMapper objectMapper = new ObjectMapper();

	// 회원관리 페이지 들어옴
	@GetMapping("/adminUser")
	public String adminUser(HttpSession session) {
		System.out.println("회원관리 페이지 들어옴");
		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {
			return "admin/user/adminUser";
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return "redirect:/adminLogin";
		}
	}

	// 회원관리 페이지
	@PostMapping(value = "/adminUserInfo", produces = "application/text; charset=utf8")
	@ResponseBody
	public String adminUserInfo(@ModelAttribute AdminLoginVo adminLoginVo, HttpSession session)
			throws JsonProcessingException {
		System.out.println("관리자 회원관리 들어옴");

		String userId = (String) session.getAttribute("userId");
		if (userId != null && userId.equals("admin")) {

			List<AdminUserVo> userList = adminUserService.adminUserInfo(adminUserVo);
			System.out.println("controller에서의 userList : " + userList);

			// Java 객체를 JSON 문자열로 변환
			String json = objectMapper.writeValueAsString(userList);
			return json;
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return null;
		}
	}

}
