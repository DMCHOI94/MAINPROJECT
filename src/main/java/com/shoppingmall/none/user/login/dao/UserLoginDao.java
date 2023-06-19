package com.shoppingmall.none.user.login.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.user.login.vo.UserFindIdVo;
import com.shoppingmall.none.user.login.vo.UserLoginVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserLoginDao {

	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	// 회원가입 정보 전달
	public String loginInfo(UserLoginVo userLoginVo) {
		System.out.println("로그인 dao의 userLoginVo = " + userLoginVo);
		return sql.selectOne("UserJoinDao.login", userLoginVo);
	}

	// 아이디 찾기 정보 전달
	public String findIdConfirm(UserFindIdVo userFindIdVo) {
		System.out.println("아이디 찾기 dao 의 userFindIdVo = " + userFindIdVo);
		return sql.selectOne("UserJoinDao.findIdConfirm", userFindIdVo);
	}

}