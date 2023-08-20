package com.shoppingmall.none.admin.adminProduct.vo;

import lombok.Data;

@Data
public class AdminProductVo {
	private int productSeq;
	private String productName;
	private int productPrice;
	private int productQuantity;
	private String productContent;
	private String productClassification;
}
