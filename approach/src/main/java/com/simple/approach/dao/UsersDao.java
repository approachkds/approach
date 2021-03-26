package com.simple.approach.dao;

import java.util.List;

import com.simple.approach.dto.UsersDto;

public interface UsersDao {

	/*
		Dao의 mapper와 직접 연결됩니다.
		Dao의 메소드명 == mapper의 id
	*/
	
	public List<UsersDto> usersList();
	
	public void usersInsert1(String name, String phone);
	
	public void usersInsert2(UsersDto usersDto);
	
	public UsersDto usersView(int no);
	
	public void usersUpdate(UsersDto usersDto);
	
	public void usersDelete(int no);
}
