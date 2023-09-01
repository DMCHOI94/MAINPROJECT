package com.shoppingmall.none.user.product.vo;

import lombok.Data;

@Data
public class UserProductVo {
	private int productSeq;
	private String productName;
	private int productPrice;
	private int productQuantity;
	private String productContent;
	private String productClassification;
}
