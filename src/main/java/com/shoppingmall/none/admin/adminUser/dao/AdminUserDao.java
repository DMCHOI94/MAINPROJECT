package com.shoppingmall.none.admin.adminUser.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.admin.adminUser.vo.AdminUserVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminUserDao {

	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	// 회원가입 정보 전달
	public List<AdminUserVo> adminUserInfo(AdminUserVo adminUserVo) {
		System.out.println("회원정보조회 dao의 adminUserVo = " + adminUserVo);

		Map<String, Object> params = new HashMap<>();
		params.put("adminUserVo", adminUserVo);

		return sql.selectList("AdminLoginDao.adminUserInfo", params);
	}

}