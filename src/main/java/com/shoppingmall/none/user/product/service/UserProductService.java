package com.shoppingmall.none.user.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shoppingmall.none.user.product.dao.UserProductDao;
import com.shoppingmall.none.user.product.vo.UserProductVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 의존성 주입 받는 걸 "생성자주입" 이라고 표현한다
public class UserProductService {
	private final UserProductDao userProductDao;

	// 상세페이지 bread1
	public List<UserProductVo> bread1(String bread) {
		System.out.println("service bread1 불러옴");
		List<UserProductVo> result = userProductDao.bread1(bread);
		System.out.println("service result : " + result);
		return result;
	}
}
