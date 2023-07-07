package com.shoppingmall.none.admin.adminUser.controller;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.shoppingmall.none.admin.adminUser.dao.AdminUserDao;
import com.shoppingmall.none.admin.adminUser.service.AdminUserService;
import com.shoppingmall.none.admin.adminUser.vo.AdminPageVo;
import com.shoppingmall.none.admin.adminUser.vo.AdminUserVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;
	private AdminUserVo adminUserVo;
	private AdminUserDao adminUserDao;
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
	@PostMapping(value = "/adminUserInfo", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public HashMap<String, Object> adminUserInfo(@ModelAttribute AdminUserVo adminUserVo, HttpSession session)
			throws JsonProcessingException {
		System.out.println("관리자 회원관리 들어옴");

		String userId = (String) session.getAttribute("userId");
		if (userId != null && userId.equals("admin")) {

			List<AdminUserVo> userList = adminUserService.adminUserInfo(adminUserVo);

			// 회원 총 인원
			int userCount = userList.size();
			// 화면에 보여지는 회원 수
			int userSize = 10;
			// 화면에 보여지는 페이지 개수
			int pageSize = 5;
			// 페이지 총 개수
			int pageCount = (userCount / userSize) + (userCount % userSize == 0 ? 0 : 1);

			// 현재 페이지 구하기
			int curPageStr = 2;
			if (curPageStr == 0) {
				curPageStr = 1;
			}
			int curPage = curPageStr;

			// 시작 페이지 구하기
			int startPage = 1;
			if (curPage % pageSize == 0) {
				startPage = ((curPage / pageSize) - 1) * pageSize + 1;
			} else {
				startPage = (curPage / pageSize) * pageSize + 1;
			}

			// 끝 페이지 구하기
			int endPage = startPage + pageSize - 1;

			// 시작 인덱스 구하기
			int startIndex = (curPage - 1) * userSize;

			// 마지막 인덱스 구하기
			int endIndex = curPage * userSize - 1;

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			if (endIndex > userCount) {
				endIndex = userCount;
			}

			AdminPageVo adminPageVo = new AdminPageVo();
			adminPageVo.setUserCount(userCount);
			adminPageVo.setUserSize(userSize);
			adminPageVo.setPageSize(pageSize);
			adminPageVo.setPageCount(pageCount);
			adminPageVo.setCurPage(curPage);
			adminPageVo.setStartPage(startPage);
			adminPageVo.setEndPage(endPage);
			adminPageVo.setStartIndex(startIndex);
			adminPageVo.setEndIndex(endIndex);

			List<AdminPageVo> userPage = new ArrayList<>();
			userPage.add(adminPageVo);

			System.out.println("이전의 userPage : " + userPage);
			System.out.println("이전의 userList : " + userList);
			System.out.println("userList의 데이터 타입: " + userList.getClass().getName());
			System.out.println("userPage의 데이터 타입: " + userPage.getClass().getName());

			HashMap<String, Object> map = new HashMap<>();
			map.put("userList", userList);
			map.put("userPage", userPage);

			System.out.println("controller에서의 userList : " + userList);
			System.out.println("controller에서의 userPage : " + userPage);
			System.out.println("controller에서의 map : " + map);
			System.out.println("userCount : " + userCount);
			System.out.println("userSize : " + userSize);
			System.out.println("pageSize : " + pageSize);
			System.out.println("pageCount : " + pageCount);
			System.out.println("curPageStr : " + curPageStr);
			System.out.println("curPage : " + curPage);
			System.out.println("startPage : " + startPage);
			System.out.println("endPage : " + endPage);
			System.out.println("startIndex : " + startIndex);
			System.out.println("endIndex : " + endIndex);

			return map;
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return null;
		}
	}

}
