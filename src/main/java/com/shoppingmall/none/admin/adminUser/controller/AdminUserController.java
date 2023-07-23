package com.shoppingmall.none.admin.adminUser.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping(value = "/adminUserInfo", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<Object> adminUserInfo(@ModelAttribute AdminUserVo adminUserVo, AdminPageVo adminPageVo,
			HttpSession session,
			@RequestParam(value = "currentPage", required = false, defaultValue = "1") String currentPage)
			throws JsonProcessingException {
		System.out.println("currentPage : " + currentPage);
		System.out.println("관리자 회원관리 들어옴1");
		System.out.println("관리자 회원관리 들어옴2");
		System.out.println("관리자 회원관리 들어옴3");
		System.out.println("관리자 회원관리 들어옴4");

		String userId = (String) session.getAttribute("userId");
		if (userId != null && userId.equals("admin")) {

			// 그래서 요놈은 계산한 파라미터를 넣은 뒤에 나와야함 순서가 잘못된거지
			// 이 부분은 해결됐습니다 ;; 쓰다보니 해결되네
			// 뭐든 자동은 없음 어디선가 쓴거지 ㅇㅎ.
			// 그러면 LIST 저놈을 밑으로 내려야겟네
			// 밑으로 내린다고 생각하지말고 순서를 맞춰야한다고 생각해야지
			// 계산부터 하고 그 계산된 변수를 파라미터로 넣어야 하니까
			// 1. 페이징에 필요한 변수를 계산한다.
			// 2. 그 계산된 변수를 SERVICE 파라미터로 넣는다
			// 3. 그 파라미터를 이용하여 SQL문을 작성한다.ㅇㅋ?ㅇㅋㅇㅋ

			System.out.println("관리자 회원관리 들어옴5");
			System.out.println("관리자 회원관리 들어옴6");
			// 회원 총 인원
			int userCount = adminUserService.adminUserCount();
			System.out.println("------------ userCount : " + userCount);
			// 화면에 보여지는 회원 수
			int userSize = 10;
			// 화면에 보여지는 페이지 개수
			int pageSize = 5;
			// 페이지 총 개수
			int pageCount = (userCount / userSize) + (userCount % userSize == 0 ? 0 : 1);
			// 현재 페이지 구하기
			System.out.println(" test : " + currentPage);
			String curPageStr = currentPage;
			if (curPageStr == null) {
				System.out.println("들어옴");
				curPageStr = "1";
			}
			int curPage = Integer.parseInt(curPageStr);

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

			if (startIndex == 0) {
				startIndex = 1;
			}
			if (endIndex == 9) {
				endIndex = 10;
			}

			if (endPage > pageCount) {
				endPage = pageCount;
			}
			if (endIndex > userCount) {
				endIndex = userCount;
			}

			adminPageVo.setUserCount(userCount);
			adminPageVo.setUserSize(userSize);
			adminPageVo.setPageSize(pageSize);
			adminPageVo.setPageCount(pageCount);
			adminPageVo.setCurPage(curPage);
			adminPageVo.setStartPage(startPage);
			adminPageVo.setEndPage(endPage);
			adminPageVo.setStartIndex(startIndex);
			adminPageVo.setEndIndex(endIndex);

			List<AdminUserVo> userList = adminUserService.adminUserInfo(adminUserVo, adminPageVo);
			// DB에 뽑히는 리스트 만큼의 정수
			System.out.println("test userList : " + userList);
			int userRow = userList.size();
			adminPageVo.setUserRow(userRow);
			List<AdminPageVo> userPage = new ArrayList<>();
			List<Object> resultList = new ArrayList<>();
			userPage.add(adminPageVo);
			resultList.add(userPage);
			resultList.add(userList);

			System.out.println("userCount : " + userCount);
			System.out.println("userSize : " + userSize);
			System.out.println("userRow : " + userRow);
			System.out.println("pageSize : " + pageSize);
			System.out.println("pageCount : " + pageCount);
			System.out.println("curPageStr : " + curPageStr);
			System.out.println("curPage : " + curPage);
			System.out.println("startPage : " + startPage);
			System.out.println("endPage : " + endPage);
			System.out.println("startIndex : " + startIndex);
			System.out.println("endIndex : " + endIndex);
			System.out.println("return resultList : " + resultList);
			return resultList;
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return null;
		}
	}

	// 회원관리 페이지 들어옴
	@GetMapping(value = "/userDelete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public int userDelete(HttpSession session, @RequestParam("selUserId") String selUserId) {
		System.out.println("회원삭제 들어옴");
		String userId = (String) session.getAttribute("userId");

		if (userId != null && userId.equals("admin")) {
			System.out.println("selUserId : " + selUserId);
			List<String> selUserIds = Arrays.asList(selUserId.split(","));
			System.out.println("--selUserIds : " + selUserIds);
			int userDel = adminUserService.userDelete(selUserIds);
			return userDel;
		} else {
			System.out.println("로그인 후 이용이 가능합니다.");
			return 0;
		}
	}
}
