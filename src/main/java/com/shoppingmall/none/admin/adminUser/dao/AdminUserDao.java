package com.shoppingmall.none.admin.adminUser.dao;

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.admin.adminUser.vo.AdminPageVo;
import com.shoppingmall.none.admin.adminUser.vo.AdminUserVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminUserDao {

	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	// 회원 전체 수 조회
	public int adminUserCount() {
		System.out.println("회원 전체 수 조회  : ");
		return sql.selectOne("AdminLoginDao.adminUserCount");
	}

	// 회원 정보 조회
	public List<AdminUserVo> adminUserInfo(AdminUserVo adminUserVo, AdminPageVo adminPageVo) {
		System.out.println("회원정보조회 dao의 adminUserVo = " + adminUserVo);

		// Map<String, Object> params = new HashMap<>();
		// params.put("adminPageVo", adminPageVo);
		System.out.println("dao adminUserVo : " + adminUserVo);
		System.out.println("dao adminPageVo : " + adminPageVo);
		// System.out.println("params : " + params);

		return sql.selectList("AdminLoginDao.adminUserInfo", adminPageVo);
	}

	// 회원 삭제
	public int userDelete(List<String> selUserIds) {
		System.out.println("회원삭제 selUserIds : " + selUserIds);
		return sql.delete("AdminLoginDao.userDelete", selUserIds);
	}
}