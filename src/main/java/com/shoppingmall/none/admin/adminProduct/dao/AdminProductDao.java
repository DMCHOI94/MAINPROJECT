package com.shoppingmall.none.admin.adminProduct.dao;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.admin.adminProduct.vo.AdminProductVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminProductDao {

	@Autowired
	private DataSource dataSource;

	private final SqlSessionTemplate sql;

	// 관리자 상품등록
	public int adminProductInfo(AdminProductVo adminProductVo) {
		System.out.println("관리자 상품등록 dao 들어옴");
		System.out.println("adminProductVo price : " + adminProductVo.getProductPrice());
		return sql.selectOne("AdminLoginDao.adminUserCount");
	}

}