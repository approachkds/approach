package com.simple.approach.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

	// Mybatis를 사용하는 경우에는 
	// SqlSession 클래스를 이용합니다.
	
	// field
	
	@Autowired
	private SqlSession sqlSession;
	
	// method
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
}
