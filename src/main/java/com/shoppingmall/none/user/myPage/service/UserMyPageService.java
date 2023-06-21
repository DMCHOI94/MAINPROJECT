package com.shoppingmall.none.user.myPage.service;

import org.springframework.stereotype.Service;

import com.shoppingmall.none.user.myPage.dao.UserMyPageDao;
import com.shoppingmall.none.user.myPage.vo.UserMyPageVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class UserMyPageService {
	private final UserMyPageDao userMyPageDao;

	public int updateInfo(UserMyPageVo userMyPageVo) {
		System.out.println("정보수정 service의 userMyPageVo : " + userMyPageVo);
		return userMyPageDao.updateInfo(userMyPageVo);
	}
}
