<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var afterInsert = '${afterInsert}';
	if(afterInsert == 'true') { // if (afterInsert != '') {
		var insertResult = '${insertResult}';
		if (insertResult > 0 && '${param.a}' > 0) {  //  && '${param.a}' > 0 : addAttribute("a", InsertResult) 테스트용 코드입니다. 
			alert('삽입되었습니다.');
		} else {
			alert('실패하였습니다.');
		}
	}
	var afterDelete = '${afterDelete}';
	if(afterDelete == 'true') { // if (afterDelete != '') {
		var deleteResult = '${deleteResult}';
		if(deleteResult > 0) {
			alert('삭제되었습니다.');
		} else {
			alert('삭제되지 않았습니다.');
		}
	}
</script>
</head>
<body>

	<h3>게시글 목록</h3>
	
	<input type="button" value="새글작성하러가기" onclick="location.href='simpleInsertPage.do'" /><br/><br/>
	
	전체: ${totalRecord}개 게시글<br/>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="simpleDto" items="${list}" varStatus="k">
					<tr>
						<td>${totalRecord -((page - 1) * recordPerPage + k.index)}</td>
						<td>${simpleDto.writer}</td>
						<td><a href="simpleViewPage.do?no=${simpleDto.no}&page=${page}">${simpleDto.title}</a></td>
						<td>${simpleDto.regDate}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					${paging}
				</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>