package com.shoppingmall.none.admin.adminUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.none.admin.adminUser.dao.AdminUserDao;
import com.shoppingmall.none.admin.adminUser.vo.AdminUserVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class AdminUserService {
	@Autowired
	private final AdminUserDao adminUserDao;

	// 회원정보 조회
	public List<AdminUserVo> adminUserInfo(AdminUserVo adminUserVo) {
		System.out.println("회원정보조회 service의 adminUserVo = " + adminUserVo);
		List<AdminUserVo> userList = adminUserDao.adminUserInfo(adminUserVo);
		System.out.println("service에서의 userList : " + userList);
		return userList;
	}

}
