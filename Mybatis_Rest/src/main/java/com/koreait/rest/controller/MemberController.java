package com.koreait.rest.controller;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.rest.command.MemberCommand;
import com.koreait.rest.command.MemberDeleteCommand;
import com.koreait.rest.command.MemberInsertCommand;
import com.koreait.rest.command.MemberListCommand;
import com.koreait.rest.command.MemberUpdateCommand;
import com.koreait.rest.command.MemberViewCommand;
import com.koreait.rest.dto.MemberDto;

@Controller
public class MemberController {

	// field
	private MemberCommand memberComnmand;
	
	@Autowired
	private SqlSession sqlSession;
	
	// method
	@RequestMapping(value="member",
					method=RequestMethod.GET,
					produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> memberList(Model model) {
		memberComnmand = new MemberListCommand();
		return memberComnmand.execute(sqlSession, model);
	}
		
	@RequestMapping(value="member",
					method=RequestMethod.POST,
					produces="application/json; charset=utf-8")	
	
	@ResponseBody
	public Map<String, Object> memberInsert(@RequestBody MemberDto memberDto,
											Model model){
		if(memberDto != null) {
			model.addAttribute("memberDto", memberDto);
		}
		memberComnmand = new MemberInsertCommand();
		// memberCommand.execute(sqlSession, model); 결과가 resultMap이므로 곧바로 반환됩니다.
		return memberComnmand.execute(sqlSession, model);
	}
	
	@RequestMapping(value="member/{no}",
					method=RequestMethod.GET,
					produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> memberView(@PathVariable("no") int no,
										  Model model) {
		model.addAttribute("no", no);
		memberComnmand = new MemberViewCommand();
		return memberComnmand.execute(sqlSession, model);
	}
	
	@RequestMapping(value="member",
					method=RequestMethod.PUT,
					produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> memberUpdate(@RequestBody MemberDto memberDto,
											Model model) {
		if(memberDto != null) {
			model.addAttribute("memberDto", memberDto);
		}
		memberComnmand = new MemberUpdateCommand();
		return memberComnmand.execute(sqlSession, model);
	}
	
	@RequestMapping(value="member/{no}",
					method= RequestMethod.DELETE,
					produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> memberDelete(@PathVariable("no") int no,
											Model model) {
		model.addAttribute("no", no);
		memberComnmand = new MemberDeleteCommand();
		return memberComnmand.execute(sqlSession, model);
	}
}
