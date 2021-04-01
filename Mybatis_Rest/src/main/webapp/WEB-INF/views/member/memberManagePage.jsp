<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript">

	/*
		REST : URI + HTTP Method
					URI
		목록		member 			GET
		보기 		member/{no}		GET
		삽입 		member			POST
		수정 		member			PUT
		삭제 		member/{no}		DELETE
		
	*/
	
	// 페이지 로드 이벤트
	$(document).ready(function(){
		memberList();
		memberView();
		memberInsert();
		memberUpdate();
		memberDelete();
		init();
	});
	
	/*****1. 회원 목록 *****/
	function memberList() {
		// URI: member, Method: GET
		$.ajax({
			url:'member',
			type:'get',
			dataType: 'json',
			success: function(responseList) {
				/*
					responseList = {
						"list": [
							{
								"no":1,
								"id":"user1",
								"name":"제임스"
								"gender": "남"
								"address": "서울"
							},
							...
						],
						"result":true
				}
				*/
				if(responseList.result == true) {
					memberListTable(responseList.list)	// 서브 함수
				}
			},
			error: function () {
				alert('실패');
			}
		});
	}
	// 서브 함수: 회원 목록을 테이블로 만들어 주는 함수
	function memberListTable(list) {
		$('#memberList').empty();	// 기존 목록을 제거합니다.
		$.each(list, function(idx, member){
			$('<tr>')
			.append($('<td>').html(member.no))
			.append($('<td>').html(member.id))
			.append($('<td>').html(member.name))
			.append($('<td>').html(member.gender))
			.append($('<td>').html(member.address))
			.append($('<input type="hidden" name="no"/>').val(member.no))
			.append($('<input type="hidden" name="id /">').val(member.id))	// 회원 삭제에서 사용할 id를 새로 추가했습니다.
			.append($('<td>').html('<input type="button" value="조회" id="btnView">'))
			.append($('<td>').html('<input type="button" value="삭제" id="btnDelete"> '))
			appendTo('#memberList');
		});
	}
	
	
	
	/*****2. 회원 정보 *****/
	function memberView() {
		
		// URI : member/{no}, method = GET
		
		// jquery의 append() 등의 메소드를 이용해서 생성한 버튼은 
		// $('#btnView').click(function(){}) 와 같은 click 이벤트 처리가 불가능합니다.
		
		// 동적요소 : append()나 html() 메소드로 만든 요소
		// 동적 요소의 이벤트 연결(바인딩)은 on() 메소드를 사용해야 합니다.
		
		$('body').on('click', '#btnView', function(){
			
			// <input type="hidden" name="no" /> 태그의 value를 알아내야 합니다.
			
			// 이벤트 객체는 누구인가요? #btnView입니다.
			// 이벤트 객체는 $(this)라고 부를 수 있습니다.
	        // $(this)와 같은 위치(수준: <tr>)에 있는 hidden 찾기
	        // 1. $(this)의 부모 요소 중에서(td -> tr -> tbody) <tr> 태그를 찾는다.
	        //     1) $(this).parents('tr') : 부모 요소 중 tr
	        //     2) $(this).closest('tr') : 가장 가까운 tr(같은 id가 많은 경우에 유용)
	        // 2. 거기서(<tr>) find() 메소드로 <input type="hidden" name="no />를 찾는다.
	        //     1) $(this).parents('tr').find('input:hidden[name="no"]')
	        //     2) $(this).closest('tr').find('input:hidden[name="no"]')
	        // 3. 거기서(<input type="hidden">) 값을 가져온다.
	        //     1) $(this).parents('tr').find('input:hidden[name="no"]').val()
	        //     2) $(this).closest('tr').find('input:hidden[name="no"]').val()
	        
	    	var no = $(this).parent("tr").find('input:hidden[name="no"]').val();
	        
	        $.ajax({
	        	url: 'member/' + no,	// RequestMapping(value="member/{no}")
	        	type:'get',
	        	dataType: 'json',
	        	success: function(responseObj) {
	        		/*
					responseObj = {
						"memberDto": {
								"no": 1,
								"id": "user1",
								"name": "제임스",
								"gender": "남",
								"address": "서울"
						},
						"result": true
					}
					*/
					if(responseObj.result == true) {
						$('input:text[name="id"]').val(responseObj.memberDto.id);
						$('input:text[name="name"]').val(responseObj.memberDto.name);
						$('input:radio[name="gender"][value=]"' + responseObj.memberDto.gender + '"]').prop('checked', true);
						$('select[name="address"]').val(responseObj.memberDto.address);
						// 회원정보를 보여주지 않기 때문에,
						// hidden으로 <div class="left"></div>에 회원번호(no)를 추가합니다.
						// 계속 추가하면 여러 개의 hidden이 생성되므로 우선 먼저 추가된 hidden을 제거하고 나서 추가합니다.
						$('.left input:hidden[name="no"]').remove();	// 먼저 있던 hidden 제거
						$('.left').append($('<input type="hidden" name="no" />').val(no));	// 새로운 hidden 추가
					}
	        	},
	        	error: function() {
	        		alert('실패');
	        	}
	        });
		});
		
	}
	
	
	/*****3. 회원 삽입 *****/
	function memberInsert() {
		
		// URI : member, Method: POST
		// 입력 데이터 -> JSON 데이터로 만듭니디.
		// 만들어진 JSON 데이터를 컨트롤러로 넘겨줍니다.
		// POST 방식은 파라미터를 본문(body)에 실어 줍니다. (JSON 데이터를 BODY에 실어 줍니다.)
		// 그래서 컨트롤러는 요청 파라미터 (request)를 본문에서 꺼내야 합니다. -> @ReqeustBody 에너테이션이 필요합니다.
		
		
		$('#btnInsert').click(function(){
			
			var id = $('input:text[name="id"]').val();
			var name = $('input:text[name="name"]').val();
			var gender = $('input:radio[name="gneder"]:checked').val();
			var address = $('select[name="address"]').val();
			
			var sendObj = {
					"id":id,
					"name": name,
					"gender":gender,
					"address":address
			};
			
			
			$.ajax({
				url:'member',
				type:'post',
				data: JSON.stringify(sendObj),	// 컨트롤러로 보내는 JSON 데이터(신규회원정보)
				contentType:'application/json',	// 컨트롤러로 보내는 데이터 타입
				dataType: 'json',
				success:function(responseObj) {
					/*
					responseObj = {
						"result": 1 (성공)
						또는
						"result": 0 (실패)
						또는
						"result": -1 (중복 회원 존재)
					}
				*/
				if(responseObj.result == 1) {
					alert('신규회원이 등록 되었습니다. ');
					memberList();	// 새로운 회원 목록을 풀력합니다.
				} else if(responseObj.result == 0){
					alert('신규 회원 등록에 실패했습니다.');
				} else if(responseObj.result == -1) {
					alert('미이 사용 중인 아이디입니다.');
				}
			},
			error:function() {
				alert('실패');
			}
		});
	});
}
	
	
	/*****4. 회원 수정 *****/
	
	function memberUpdate() {
		
		$('#btnUpdate').click(function() {
			
			// 수정할 회원의 no를 알아야 수정이 가능하므로,
			// "조회" 버튼을 누르면 <div class="left"></div>에 <input type="hidden" name="no" value="회원번호" />를 넣는 코드가 추가되어 있습니다. (memberView() 함수)
			
			var no = $(this).parent('div.left').find('input:hidden[name="no"]').val(); 	// 수정할 회원의 회원번호 
			
			var id = $('input:text[name="id"]').val();
			var name = $('input:text[name="name"]').val();
			var gender = $('input:radio[name="gender"]:checked').val();
			var address = $('select[name="address"]').val();
			
			var sendObj = {
					"no":no,
					"id":id,
					"name":name,
					"gender":gender,
					"address":address
			};
			
			$.ajax({
				url:'member',
				type:'put',
				data: JSON.stringify(sendObj),
				contentType: 'application/json',
				dataType: 'json',
				success: function(responseObj) {
					if(responseObj.result == 1) {
						alert('회원 정보가 수정되었습니다.,');
						memberList();
					} else {
						alert('회원 정보 수정이 실패하였습니다.');
					}
				},
				error: function() {
					alert('실패');
				}
			});
		});
	}
	/***** 5. 회원 삭제 *****/
	function memberDelete() {
		
		$('body').on('click', '#btnDelete', function(){
	        
	        var no = $(this).parents('tr').find('input:hidden[name="no"]').val();
	        
	        // 삭제할 회원의 id를 먼저 보여주기 위해서 회원 목록을 표시할 때 회원 아이디를 추가해 주었습니다. (memberList() 함수)
	        var id = $(this).parents('tr').find('input:hidden[name="id"]').val();
	        
	        var check = confirm(id + '님 정보를 삭제할까요?');
	        if (check) {
		        $.ajax({
		        	url: 'member/' + no,
		        	type: 'delete',
		        	dataType: 'json',
		        	success: function(responseObj) {
		        		if (responseObj.result == 1) {
							alert('회원 정보가 삭제되었습니다.');
							memberList();
						} else {
							alert('회원 정보 삭제가 실패했습니다.');
						}
		        	},
		        	error: function(){
						alert('실패');
					}
		        });
	        }
	        
		});
		
	}
	
	/*****6. 초기화 *****/
	function init() {
		$('#btnInit').click(function() {
			$('input:text[name="id"]').val();
			$('input:text[name="name"]').val();
			$('input:radio[name="gender"]').prop('checked', false);
			$('select[name="adrress"]').val();
			memberList();
		});
	}
	


</script>
<title>Insert title here</title>
<style type="text/css">
	.wrap {
		display: flex;
	}
	.left {
		width: 500px;
	}
	.right {
		width: 1000px;
	}
	table {
		border-collapse: collapse;
	}
	td, th {
		border-top: 1px solid black;
		border-bottom: 1px solid black;
		padding: 5px 20px;
		text-align: center;
	}
	th {
		background:silver;
	}
</style>
</head>
<body>

	<div class="wrap">
		
		<div class="left">
			<!-- 등록/수정/보기 페이지 -->
			<h3>회원 등록/수정/보기</h3>
			아이디<br/>
			<input type="text" name="id" /><br/><br/>
			이름<br/>
			<input type="text" name="name" /><br/><br/>
			성별<br/>
			<input type="radio" name="gender" value="남" />남
			<input type="radio" name="gender" value="여">여<br/><br/>
			주소<br/>
			<select name="address">
				<option value="">지역 선택</option>
				<option value="서울">서울</option>
				<option value="인천">인천</option>
				<option value="부산">부산</option>
				<option value="제주">제주</option>
				<option value="강원">강원</option>
			</select><br/><br/>
			<input type="button" value="등록" id="btnInsert" />
			<input type="button" value="수정" id="btnUpdate" />
			<input type="button" value="초기화" id="btnInit" />
		</div>
		
		<div class="right">
			<!-- 목록/삭제 페이지 -->
			<h3>회원 목록</h3>
			<table>
				<thead>
					<tr>
						<td>회원번호</td>
						<td>아이디</td>
						<td>이름</td>
						<td>성별</td>
						<td>주소</td>
						<td colspan="2">비고</td>
					</tr>
				</thead>
				<tbody id="memberList"></tbody>
			</table>
		</div>
		
	</div>

</body>
</html>