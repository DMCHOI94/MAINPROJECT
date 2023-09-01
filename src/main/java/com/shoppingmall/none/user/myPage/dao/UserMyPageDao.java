package com.shoppingmall.none.user.myPage.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.user.myPage.vo.UserUpdateVo;
import com.shoppingmall.none.user.myPage.vo.UserWithdrawalVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor // 의존성 주입 받는다. sqlSessionTemplate
public class UserMyPageDao {
	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	// 회원정보 수정 전달
	public UserUpdateVo updateInfo(UserUpdateVo userUpdateVo) {
		System.out.println("정보전달 dao의 userUpdateVo : " + userUpdateVo);
		System.out.println("------updateDAo 중간점검 --------");
		sql.update("UserJoinDao.updateInfo", userUpdateVo);
		return userUpdateVo;
	}

	// 수정된 회원정보 조회
	public UserUpdateVo updateComplete(String userId) {
		System.out.println("dao 에서 updateComplete");
		System.out.println("user id : " + userId);
		return sql.selectOne("UserJoinDao.updateComplete", userId);
	}

	// 회원탈퇴
	public int withdrawalInfo(UserWithdrawalVo userWithdrawalVo) {
		System.out.println("회원탈퇴의 dao에 들어옴");
		return sql.delete("UserJoinDao.withdrawalInfo", userWithdrawalVo);
	}
}