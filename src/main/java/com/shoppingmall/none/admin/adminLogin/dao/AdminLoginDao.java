package com.shoppingmall.none.admin.adminLogin.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.admin.adminLogin.vo.AdminLoginVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminLoginDao {

	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	// 회원가입 정보 전달
	public AdminLoginVo loginInfo(AdminLoginVo adminLoginVo) {
		System.out.println("로그인 dao의 userLoginVo = " + adminLoginVo);
		return sql.selectOne("AdminLoginDao.adminLogin", adminLoginVo);
	}
}