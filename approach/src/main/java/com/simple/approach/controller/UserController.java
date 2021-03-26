package com.simple.approach.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.approach.dao.UsersDao;

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
	
	@RequestMapping(value="userInsertPage.do", method=RequestMethod.GET)
	public String usersInsertPage() {
		return "users/usersInsertPage";
	}
	
	/* 
		UserDao와 users.xml이 연결되어 있습니다.
		UserDao의 특정 메소드를 호출하면 연결된 users.xml의 쿼리가 실행됩니다.
	*/
	@RequestMapping(value="userListPage.do", method=RequestMethod.GET)
	public String userListPage(Model model) {
		UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
		model.addAttribute("list", usersDao.usersList());
		return "users/usersListPage";
	}
	
}
