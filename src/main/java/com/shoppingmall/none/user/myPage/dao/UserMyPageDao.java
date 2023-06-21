package com.shoppingmall.none.user.myPage.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.user.myPage.vo.UserMyPageVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor // 의존성 주입 받는다. sqlSessionTemplate
public class UserMyPageDao {
	// UserJoinDao 는 DB와 연관된 클래스다. 중간의 프레임워크는 mybatis를 사용
	// mybatis의 쿼리들을 호출해주고 매개변수가 있다면 넘겨주고, 리턴값이 있다면 리턴해주는 게 userJoinDao의 역할이다.
	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	public int updateInfo(UserMyPageVo userMyPageVo) {
		System.out.println("정보전달 dao의 userMyPageVo : " + userMyPageVo);
		return sql.update("UserJoinDao.updateInfo", userMyPageVo);
	}
}