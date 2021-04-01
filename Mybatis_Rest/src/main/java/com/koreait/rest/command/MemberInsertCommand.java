package com.koreait.rest.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.rest.dao.MemberDao;
import com.koreait.rest.dto.MemberDto;

public class MemberInsertCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		MemberDto memberDto = (MemberDto)map.get("memberDto");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		if(memberDao.idCheck(memberDto.getId()) == null) {
			resultMap.put("result", memberDao.memberInsert(memberDto)); // 성공하면 1, 실패화면 0
			
		} else {
			resultMap.put("result", -1);	// 중복된 아이디를 가진 회원이 있는 경우 : -1
		}
		
		return resultMap;
	}

}
