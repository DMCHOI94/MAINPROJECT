package com.shoppingmall.none.user.login.service;

import org.springframework.stereotype.Service;

import com.shoppingmall.none.user.login.dao.UserLoginDao;
import com.shoppingmall.none.user.login.vo.UserFindIdVo;
import com.shoppingmall.none.user.login.vo.UserFindPwVo;
import com.shoppingmall.none.user.login.vo.UserLoginVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class UserLoginService {
	private final UserLoginDao userLoginDao;

	// 로그인 service
	public boolean loginInfo(UserLoginVo userLoginVo) {
		System.out.println("로그인 service의 userloginVo = " + userLoginVo);
		String loginData = userLoginDao.loginInfo(userLoginVo);
		System.out.println("loginData : " + loginData);
		if (loginData != null) {
			return true;
		} else {
			return false;
		}
	}

	// 아이디 찾기 service
	public boolean findIdConfirm(UserFindIdVo userFindIdVo) {
		System.out.println("아이디찾기 service 의 userFindIdVo = " + userFindIdVo);
		String findIdData = userLoginDao.findIdConfirm(userFindIdVo);
		System.out.println("findIdData : " + findIdData);
		if (findIdData != null) {
			return true;
		} else {
			return false;
		}
	}

	// 비밀번호 찾기 service
	public boolean findPwConfirm(UserFindPwVo userFindPwVo) {
		System.out.println("비밀번호찾기 service 의 userFindPwVo = " + userFindPwVo);
		String findPwData = userLoginDao.findPwConfirm(userFindPwVo);
		System.out.println("findPwData : " + findPwData);
		if (findPwData != null) {
			return true;
		} else {
			return false;
		}
	}

	// 순서가 CONTROLLER 제외하고 SERVICE -> DAO -> MAPPER -> DAO -> SERVICE
	// SERVICE에서 DAO에서 만든 메소드를 가져다가 쓰니까 이 순서가 맞을듯 아하 ㄳㄳ
}
