package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.UserVO;

public interface UserDAO {

	int updateMailKey(UserVO uvo) throws Exception;
	int updateMailAuth(UserVO uvo) throws Exception;
	int emailAuthFail(String id) throws Exception;
	void insertMember(UserVO uvo);
	
}
