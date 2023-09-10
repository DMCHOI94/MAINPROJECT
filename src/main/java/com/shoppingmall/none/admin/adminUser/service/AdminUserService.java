package com.shoppingmall.none.admin.adminUser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.none.admin.adminUser.dao.AdminUserDao;
import com.shoppingmall.none.admin.adminUser.vo.AdminPageVo;
import com.shoppingmall.none.admin.adminUser.vo.AdminUserVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class AdminUserService {
	@Autowired
	private final AdminUserDao adminUserDao;

	// 회원 전체 수 조회
	public int adminUserCount() {
		System.out.println("회원 전체 수 조회하는 service");
		int userCount = adminUserDao.adminUserCount();
		System.out.println("회원 전체 수 조회하는 service userCount : " + userCount);
		return userCount;
	}

	// 회원정보 조회
	public List<AdminUserVo> adminUserInfo(AdminUserVo adminUserVo, AdminPageVo adminPageVo) {
		System.out.println("회원정보조회 service의 adminUserVo = " + adminUserVo);
		List<AdminUserVo> userList = adminUserDao.adminUserInfo(adminUserVo, adminPageVo);
		System.out.println("service에서의 userList : " + userList);
		return userList;
	}

	// 관리자가 회원 삭제
	public int userDelete(List<String> selUserIds) {
		System.out.println("회원삭제 service의 selUserIds : " + selUserIds);
		int result = adminUserDao.userDelete(selUserIds);
		return result;
	}

	// 회원정보 수정
	public List<AdminUserVo> adminProductRegi() {
		System.out.println("회원정보 수정 service");
		return null;
	}

}
