package com.shoppingmall.none.user.join.vo;

import lombok.Data;

@Data
public class UserJoinVo {
	private int userSeq;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddr;
	private String userAddrDetail;
	private String userAddrPostal;
	private String userGender;
	private String userBirth;
	private String useYN;
}
