package com.shoppingmall.none.admin.adminProduct.dao;

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoppingmall.none.admin.adminProduct.vo.AdminFileVo;
import com.shoppingmall.none.admin.adminProduct.vo.AdminProductListVo;
import com.shoppingmall.none.admin.adminProduct.vo.AdminProductVo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AdminProductDao {

	@Autowired
	private DataSource dataSource;
	private final SqlSessionTemplate sql;

	// 관리자 상품등록
	public int adminProductInfo(AdminProductVo adminProductVo, Integer productSeq) {
		System.out.println("관리자 상품등록 dao 들어옴");
		System.out.println("adminProductVo price : " + adminProductVo.getProductPrice());
		int result = sql.insert("AdminLoginDao.adminProductInfo", adminProductVo);
		productSeq = sql.selectOne("AdminLoginDao.getProductSeq");
		adminProductVo.setProductSeq(productSeq);
		System.out.println("adminProductVo productSeq : " + adminProductVo.getProductSeq());
		return result;
	}

	// 관리자 파일등록
	public int adminFileInfo(AdminFileVo adminFileVo) {
		System.out.println("관리자 파일등록 dao 들어옴");
		System.out.println("adminFileVo path : " + adminFileVo.getFilePath());
		System.out.println("adminFileVo name : " + adminFileVo.getFileName());
		System.out.println("dao에서 get productseq : " + adminFileVo.getProductSeq());
		return sql.insert("AdminLoginDao.adminFileInfo", adminFileVo);
	}

	// 상품 이름 중복체크
	public String adminProductNameCheck(AdminProductVo adminProductVo) {
		System.out.println("상품이름 중복체크 dao 들어옴");
		return sql.selectOne("AdminLoginDao.adminProductNameCheck", adminProductVo);
	}

	// 상품 전체 수 조회하는 dao
	public int adminProductCount() {
		System.out.println("상품 전체 수 조회");
		return sql.selectOne("AdminLoginDao.adminProductCount");
	}

	// 상품 목록 조회
	public List<AdminProductListVo> adminProductList(AdminProductVo adminProductVo) {
		System.out.println("상품 정보 조회 dao의 adminProductVo : " + adminProductVo);

		return sql.selectList("AdminLoginDao.adminProductList", adminProductVo);
	}

}