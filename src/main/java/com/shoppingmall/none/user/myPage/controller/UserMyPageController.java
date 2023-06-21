package com.shoppingmall.none.user.myPage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shoppingmall.none.user.myPage.service.UserMyPageService;
import com.shoppingmall.none.user.myPage.vo.UserMyPageVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserMyPageController {

	private final UserMyPageService userMyPageService;

	// 마이페이지
	@GetMapping("/myPage")
	public String myPage() {
		return "myPage/myPage.user";
	}

	// 정보수정
	@GetMapping("/update")
	public String update(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		System.out.println("userId : " + userId);
		return "myPage/update.user";
	}

	// 정보수정 정보 전달
	@PostMapping("/updateInfo")
	public Map<String, Object> updateInfo(@ModelAttribute UserMyPageVo userMyPageVo) {
		System.out.println("userMyPageVo / userPw : " + userMyPageVo.getUserPw() + "userName : "
				+ userMyPageVo.getUserName() + "userAddrPostal : " + userMyPageVo.getUserAddrPostal() + "userAddr : "
				+ userMyPageVo.getUserAddr() + "userAddrDetail : " + userMyPageVo.getUserAddrDetail());

		int updateResult = userMyPageService.updateInfo(userMyPageVo);

		Map<String, Object> result = new HashMap<>();
		result.put("updateResult", updateResult);
		System.out.println("controller result : " + result);
		return result;
	}
}
