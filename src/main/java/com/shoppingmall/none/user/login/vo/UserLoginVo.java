package com.shoppingmall.none.user.login.vo;

import lombok.Data;

@Data
public class UserLoginVo {
	private int userSeq;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddrPostal;
	private String userAddr;
	private String userAddrDetail;
	private String userGender;
	private String userBirth;
	private String useYN;
}
