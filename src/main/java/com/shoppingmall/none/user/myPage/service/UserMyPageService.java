package com.shoppingmall.none.user.myPage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.none.user.myPage.dao.UserMyPageDao;
import com.shoppingmall.none.user.myPage.vo.UserUpdateVo;
import com.shoppingmall.none.user.myPage.vo.UserWithdrawalVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class UserMyPageService {
	@Autowired
	private final UserMyPageDao userMyPageDao;

	// 회원정보 수정 전달
	public UserUpdateVo updateInfo(UserUpdateVo userUpdateVo) {
		System.out.println("정보수정 service의 userUpdateVo : " + userUpdateVo);
		userUpdateVo = userMyPageDao.updateInfo(userUpdateVo);
		System.out.println("데이터있냐? userUpdateVo : " + userUpdateVo);
		System.out.println("------updateService 중간점검 --------");
		return userMyPageDao.updateInfo(userUpdateVo);
	}

	// 수정된 회원정보 조회
	public UserUpdateVo updateComplete(String userId) {
		System.out.println("service updateComplete");
		UserUpdateVo userUpdateVo = new UserUpdateVo();
		return userMyPageDao.updateComplete(userId);
	}

	// 회원탈퇴
	public int withdrawalInfo(UserWithdrawalVo userWithdrawalVo) {
		System.out.println("service의 회원탈퇴");
		int withdrawalInfo = userMyPageDao.withdrawalInfo(userWithdrawalVo);
		System.out.println("withdrawalInfo : " + withdrawalInfo);
		return userMyPageDao.withdrawalInfo(userWithdrawalVo);
	}
}
