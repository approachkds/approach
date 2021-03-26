package com.simple.approach.dao;

import java.util.List;

import com.simple.approach.dto.UsersDto;

public interface UsersDao {

	/*
		Dao의 mapper와 직접 연결됩니다.
		Dao의 메소드명 == mapper의 id
	*/
	
	public List<UsersDto> usersList();
	
}
