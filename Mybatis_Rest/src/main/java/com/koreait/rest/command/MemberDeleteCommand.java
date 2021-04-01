package com.koreait.rest.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.rest.dao.MemberDao;

public class MemberDeleteCommand implements MemberCommand {

	@Override
	public Map<String, Object> execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		int no = (int)map.get("no");
		
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("result", memberDao.memberDelete(no));
		
		return resultMap;
	}

}
