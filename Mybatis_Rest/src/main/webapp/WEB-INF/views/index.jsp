<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript">

	// 페이지 로드 이벤트
	$(document).ready(function(){
		$('#btn1').click( fn_getText);	// btn1을 클릭하면 fn_getText 함수가 실행됩니다.
		$('#btn2').clcik( fn_getJSON);
		$('#btn3').click( fn_getJSONByMap );
		$('#btn4').click( fn_getXML );
		$('#btn5').click( fn_getJSONList);
		$('#btn6').click( fn_getXMLList);
		$('#btn7').click( fn_sendJSON );
		$('#btn8').click( fn_sendPath );		
	});
	
	// 함수
	function fn_getText() {
		$.ajax({
			url: 'getText',	// @RequestMapping(value="getText")
			type: 'get',	// @RequestMapping(method=RequestMethod.GET)
			dataType: 'text',	//@RequestMapping(produces="text/plain") + 메소드에 @ResponseBody
			success: function(responseText) {
				// responseText는 응답 받은 결과입니다.
				$('#content1').text(responseText.trim());
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
	function fn_getJSON() {
		$.ajax({
			url:'getJSON',
			type: 'get',
			dataType: 'json',
			success: function(responseObj) {
				// JSON 데이터는 Javascript의 객체입니다.
				$('#content2').text('이름:' + responseObj.name + ', 나이:' + responseObj.age + '살');
				// $('#content2').text('이름: ' + responseObj['name'] + ', 나이: ' + responseObj['age'] + '살');
			},
			error: function() {
				alert('실패');
			}
 		});
	}
	
	function fn_getJSONByMap() {
		$.ajax({
			url: 'getJSONByMap',
			type: 'get',
			dataType: 'json',
			success: function(responseObj) {
				$('#content3').text('이름: ' + responseObj.name + ', 나이:' + responseObj.age + '살');
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
	function fn_getXML() {
		$.ajax({
			url:'getXML',
			type: 'get',
			dataType: 'xml',
			success: function(responseXML) {
				// responseXML                          <PersonDto><name>앨리스</name><age>30</age></PersonDto>
				// $(responseXML).find('name')          <name>앨리스</name>
				// $(responseXML).find('age'))          <age>30</age>
				// $(responseXML).find('name').text()   앨리스
				// $(responseXML).find('age').text()    30
				$('#content4').text('이름: '+ $(responseXML).find('name').text() + ', 나이: ' + $(responseXML).find('age').text() + '살');
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
	function fn_getJSONLIst() {
		$.ajax({
			url: 'getJSONList',
			type: 'get',
			dataType: 'json',
			success: function(responseList) {
				// 자바의 ArrayList는 jackson에 의해서 
				// 자바스크립트의 배열로 반환합니다.
				/*
					responseList = [
						{"name": "사용자1", "age": 20 },
						{"name": "사용자2", "age": 21 },
						{"name": "사용자3", "age": 22 },
						...
					]
				*/
				$('#content5').empty();
				$.each(responseList, function(idx, person) {
					$('<tr>')
					.append($('<td>').html(idx + 1) )
					.append($('<td>').html(person.name))
					.append($('<td>').html(person.age))
					.append('#content5')
				});
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
	function fn_getXMLLIST() {
		$.ajax({
			url: 'getXMLList',
			type: 'get',
			dataType: 'xml',
			success: function(responseList) {
				/*
					responseList는 아래와 같습니다.
					
					확인하려면 "http://localhost:9090/rest/getXMLList" 실행 후 주소를 입력합니다.
						<item>
							<name>사용자1</name>
							<age>20</age>
						</item>
						<item>
							<name>사용자2</name>
							<age>21</age>
						</item>
						...
				*/
				$('#content6').empty();
				$(responseList).find('item').each(function(idx){
					// $(responseList).find('item') == $(this)
					$('<tr>')
					.append($('<td>').html(idx + 1))
					.append($('<td>').html($(this).find('name').text()))
					,append($('<td>').html($(this).find('age').text()))
					,appendTo('#content6')
				});
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
	function fn_sendJSON() {
		var name = $('#name').val();
		var age = $('#age').val();
		var sendObj = {
			'name': name,
			'age': age
			};	// 아직은 자바스크립트의 객체입니다. JSON이 아닙니다.
		$.ajax({
			url: 'sendJSON',
			type:'post',	// @PostMapping
			data: JSON.stringify(sendObj),	// 컨트롤러로 보내는 데이터 (JSON문자열로 바꿔서 보냅니다.)
			cotentType: 'application/json',	// 컨트롤러로 보내는 데이터으 타입입니다.
			dataType: 'json',	// 컨트롤러에서 받아오는 데이터의 타입입니다.
			success: function(responseObj) {
				$('#content7').text('이름: ' + responseObj.name + ', 나이: ' + responseObj.age + '살');
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
	function fn_sendPath() {
		var name = $('#name2').val();
		var age = $('#age2').val();
		$.ajax({
			url: 'name/' + name +'/age/' + age, 	// GetMapping(value="name/{name}/age/{age}") 
			type: 'get',
			dataType: 'json',
			success: function(responseObj) {
				$('#content8').text('이름: ' + responseObj.name + ', 나이: ' + responseObj.age + '살');
			},
			error: function() {
				alert('실패');
			}
		});
	}
	
</script>
<title>Insert title here</title>
</head>
<body>

	<a href="memberManagePage.do">테이블 예제로 이동하기</a><br/><br/>
	
	<input type=button value="텍스트가져오기" id="btn1" /><br/>
	<div id="content1"></div>
	
	<br/>
	
	<input type="button" value="JSON가져오기" id="btn2"><br/>
	<div id="content2"></div>

	<br/>
	
	<input type="button" value="Map을 JSON으로 가져오기" id="btn3" /><br/>
	<div id="content3"></div>
	
	<br/>
	
	<input type="button" value="XML가져오기" id="btn4" /><br/>
	<div id="content4"></div>
	
	<br/>
	
	<input type="button" value="JSON List 가져오기" id="btn5" /><br/>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>성명</td>
				<td>나이</td>
			</tr>
		</thead>
		<tbody id="content5"></tbody>
	</table>

	<br/>
	
	<input type="button" value="XML List 가져오기" id="btn6" /><br/>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>성명</td>
				<td>나이</td>
			</tr>
		</thead>
		<tbody id="content6"></tbody>
	</table>
	
	<br/>
	
	<form>
		<input type="text" id="name" placeholder="이름" /><br/>
		<input type="text" id="age" placeholder="나이" /><br/>
		<input type="button" value="정보보내기" id="btn7" /><br/>
	</form>
	<div id="content7"></div>
	
	<br/>
	
	<form>
		<input type="text" id="name2" placeholder="이름" /><br/>
		<input type="text" id="age2" placeholder="나이" /><br/>
		<input type="button" value="정보보내기" id="btn8" /><br/>
	</form>
	<div id="content8"></div>
</body>
</html>