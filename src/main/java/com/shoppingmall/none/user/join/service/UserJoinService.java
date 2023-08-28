package com.shoppingmall.none.user.join.service;

import org.springframework.stereotype.Service;

import com.shoppingmall.none.user.join.dao.UserJoinDao;
import com.shoppingmall.none.user.join.vo.UserJoinVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class UserJoinService {
	private final UserJoinDao userJoinDao;

	// 회원가입 정보 전달
	public int userInfo(UserJoinVo userJoinVo) {
		System.out.println("회원가입 service의 userJoinVo = " + userJoinVo);
		return userJoinDao.userInfo(userJoinVo);
	}

	public String userIdCheck(String userId) {
		System.out.println("service 들어옴 : " + userId);
		String userIdChecking = userJoinDao.userIdCheck(userId);
		System.out.println("dao 안의 userIdChecking = " + userIdChecking);
		return userJoinDao.userIdCheck(userId);
	}

	// 순서가 CONTROLLER 제외하고 SERVICE -> DAO -> MAPPER -> DAO -> SERVICE
	// SERVICE에서 DAO에서 만든 메소드를 가져다가 쓰니까 이 순서가 맞을듯 아하 ㄳㄳ
}
