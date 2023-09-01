package com.shoppingmall.none.user.join.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.none.user.join.service.UserJoinService;
import com.shoppingmall.none.user.join.vo.UserJoinVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor // 의존성을 주입받는다
public class UserJoinController {
	private final UserJoinService userJoinService;
	private final Logger logger = LoggerFactory.getLogger(UserJoinController.class);

	// 회원 가입 페이지
	@GetMapping("/join")
	public String joinForm() {
		System.out.println("joinform들어옴");
		return "join/join.user";
	}

	// 회원가입 정보 전달
	@PostMapping("/joinInfo")
	@ResponseBody
	public Map<String, Object> userInfo(@ModelAttribute UserJoinVo userJoinVo) {

		System.out.println("회원가입정보 userId: " + userJoinVo.getUserId() + " / userPw: " + userJoinVo.getUserPw()
				+ " / userName: " + userJoinVo.getUserName() + " / userAddrPostal: " + userJoinVo.getUserAddrPostal()
				+ " / userAddr: " + userJoinVo.getUserAddr() + " / userAddrDetail: " + userJoinVo.getUserAddrDetail()
				+ " / userGender: " + userJoinVo.getUserGender() + " / userBirth: " + userJoinVo.getUserBirth() + " / useYN: "
				+ userJoinVo.getUseYN());

		int joinResult = userJoinService.userInfo(userJoinVo);
		System.out.println("controller joinResult : " + joinResult);

		Map<String, Object> result = new HashMap<>();
		result.put("joinResult", joinResult);
		System.out.println("controller result : " + result);
		return result;
	};

	// 회원가입 전 아이디 중복체크
	@PostMapping("/userIdCheck")
	@ResponseBody
	public String userIdCheck(@RequestParam("userId") String userId) {
		System.out.println("controller userId : " + userId);
		String userIdChecking = userJoinService.userIdCheck(userId);
		System.out.println("controller의 userIdChecking = " + userIdChecking);
		return userIdChecking;
	}
}