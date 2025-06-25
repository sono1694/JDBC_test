package com.example.demo.t.dto;

import lombok.Data;

/*
 * 継承：Userクラス
 */
@Data
public class DetailUser extends User{

	// 住所
	private String address;
	
	// TEL
	private String tel;
	
	//メールアドレス
	private String mailAddress;
	
}
