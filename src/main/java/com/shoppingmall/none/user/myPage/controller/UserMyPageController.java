package com.shoppingmall.none.user.myPage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingmall.none.user.myPage.service.UserMyPageService;
import com.shoppingmall.none.user.myPage.vo.UserUpdateVo;
import com.shoppingmall.none.user.myPage.vo.UserWithdrawalVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserMyPageController {

	private final UserMyPageService userMyPageService;

	// 마이페이지
	@GetMapping("/myPage")
	public String myPage(UserUpdateVo userUpdateVo) {
		System.out.println(" 여기는 mypage 입니다");

		return "myPage/myPage.user";
	}

	// 정보수정
	@GetMapping("/update")
	public ModelAndView update(HttpSession session) {
		System.out.println("----------------update-----------------");
		System.out.println("----update페이지로이동한다----");
		// update에서 db의 정보를 조회해서 jsp로 보내줘여 한다
		String userId = (String) session.getAttribute("userId");
		System.out.println("session id : " + userId);
		UserUpdateVo userUpdateVo = new UserUpdateVo();
		userUpdateVo = userMyPageService.updateComplete(userId);
		System.out.println("id : " + userUpdateVo.getUserId());
		System.out.println("name : " + userUpdateVo.getUserName());

		ModelAndView update = new ModelAndView();
		update.setViewName("myPage/update.user"); // 뷰의 이름
		update.addObject("userUpdateVo", userUpdateVo); // 뷰로 보낼 데이터 값

		return update;
	}

	// 정보수정 정보 전달
	@PostMapping("/updateInfo")
	@ResponseBody
	public Map<String, Object> updateInfo(@ModelAttribute UserUpdateVo userUpdateVo) {
		System.out.println("userMyPageVo / userPw : " + userUpdateVo.getUserPw() + "userName : "
				+ userUpdateVo.getUserName() + "userAddrPostal : " + userUpdateVo.getUserAddrPostal() + "userAddr : "
				+ userUpdateVo.getUserAddr() + "userAddrDetail : " + userUpdateVo.getUserAddrDetail());
		System.out.println("updateInfo 들어왔당");
		userUpdateVo = userMyPageService.updateInfo(userUpdateVo);
		System.out.println("--거의다왔다 updateResult : " + userUpdateVo);
		System.out.println("updateVo name : " + userUpdateVo.getUserName());
		System.out.println("updateVo id : " + userUpdateVo.getUserId());

		Map<String, Object> result = new HashMap<>();
		result.put("userUpdateVo", userUpdateVo);
		System.out.println("controller result : " + result);
		return result;
	}

	// 회원탈퇴
	@GetMapping("/withdrawal")
	public String withdrawal() {
		System.out.println("회원탈퇴ㅎㅇ");
		return "myPage/withdrawal.user";
	}

	// 회원탈퇴 정보 전달
	@PostMapping("/withdrawalInfo")
	@ResponseBody
	public int withdrawalInfo(@ModelAttribute UserWithdrawalVo userWithdrawalVo, HttpSession session) {
		System.out.println("widthdrawalInfo controller 에 들어왔다");
		int result = userMyPageService.withdrawalInfo(userWithdrawalVo);
		if (result == 1) {
			session.invalidate();
		} else {

		}
		return result;
	}
}
