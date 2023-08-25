package com.myweb.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserVO {
	
	
	private int userNum;
	private String userEmail;
	private String userPw;
	private String userRegdate;
	private String mailAuth;
	private String mailKey;
	
}
