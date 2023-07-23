package com.shoppingmall.none.admin.adminProduct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingmall.none.admin.adminProduct.dao.AdminProductDao;
import com.shoppingmall.none.admin.adminProduct.vo.AdminProductVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class AdminProductService {
	@Autowired
	private final AdminProductDao adminProductDao;

	// 관리자 상품 등록
	public int adminProductInfo(AdminProductVo adminProductVo) {
		System.out.println("관리자 service 상품 등록");
		System.out.println("adminProductVo name : " + adminProductVo.getProductName());
		int result = adminProductDao.adminProductInfo(adminProductVo);
		return 1;
	}

}
