package com.shoppingmall.none.user.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoppingmall.none.user.login.dao.UserLoginDao;
import com.shoppingmall.none.user.login.service.UserLoginService;
import com.shoppingmall.none.user.login.vo.UserFindIdVo;
import com.shoppingmall.none.user.login.vo.UserLoginVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserLoginController {

	private final UserLoginDao userLoginDao;
	private final UserLoginService userLoginService;

	// 로그인 버튼 눌렀을 때
	@GetMapping("/login")
	public String login() {
		System.out.println("login 들어옴");
		return "login/login.user";
	}

	// 로그인 정보 전달하는 메소드
	@PostMapping("/loginInfo")
	@ResponseBody
	public boolean loginInfo(@ModelAttribute UserLoginVo userLoginVo, HttpSession session) {
		boolean loginResult = userLoginService.loginInfo(userLoginVo);
		System.out.println("controller userLoginService.loginInfo(userLoginVo)" + userLoginService.loginInfo(userLoginVo));
		System.out.println("loginResult : " + loginResult);

		if (loginResult) {
			session.setAttribute("loggedIn", true);
			System.out.println("controller의 true 타고 있음");
			return true;
		} else {
			session.setAttribute("loggedIn", false);
			System.out.println("controller의 else를 타고 있음");
			return false;
		}
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/logout.user";
	}

	// 아이디 찾기
	@GetMapping("/findId")
	public String findId() {
		return "login/findId.user";
	}

	// 아이디 찾기에 필요한 이름, 비밀번호, 생년월일 정보 전달
	@PostMapping("/findIdConfirm")
	@ResponseBody
	public String findIdConfirm(@ModelAttribute UserFindIdVo userFindIdVo, HttpServletRequest request, Model model) {

		String findIdResult = userLoginDao.findIdConfirm(userFindIdVo);
		System.out
				.println("controller userLoginService.loginInfo(userLoginVo)" + userLoginService.findIdConfirm(userFindIdVo));
		System.out.println("findIdResult : " + findIdResult);
		model.addAttribute("findIdResult", findIdResult);

		return findIdResult;
	}

//	@ResponseBody
//	@RequestMapping("/loginIn")
//	public Object loginIn(HttpServletRequest request) {
//		String name = "aa";
//
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("aa", name);
//
//		return map;
//	}

	@GetMapping("/findIdConfirm")
	public String findIdConfirm() {
		return "login/findIdConfirm.user";
	}

	@GetMapping("/findPw")
	public String findPw() {
		return "login/findPw.user";
	}

	@GetMapping("/findPwConfirm")
	public String findPwConfirm() {
		return "login/findPwConfirm.user";
	}

}
