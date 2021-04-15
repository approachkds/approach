<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<script type="text/javascript">
	var users = [
		{ id: 1, name: 'ID', age: 36},
		{ id: 2, name: 'BJ', age: 32},
		{ id: 3, name: 'JM', age: 32},
		{ id: 4, name: 'PJ', age: 27},
		{ id: 5, name: 'HA', age: 25},
		{ id: 6, name: 'JE', age: 26},
		{ id: 7, name: 'JI', age: 31},
		{ id: 8, name: 'MP', age: 23},
	];
	
	<!-- 1. 30세 이상의 users를  거른다.-->
	var temp_users = [];
	for (var i = 0; i < users.length; i++) {
		if(users[i].age >= 30) {
			temp_users.push(users[i]);
		}
	}
	
	console.log(temp_users);
	
	<!-- 2. 30세 이상의 users names를 수집한다. -->
	var names = [];
	for( var i = 0; i < temp_users.length; i++) {
		names.push(temp_users[i].name);
	}
	
	console.log(names);
	
	<!-- filter 함수 --> 
	function _filter(users, predi) {
		var new_list = [];
		for(var i = 0; i < users.length; i++) {
			if(predi(users[i])) {
				new_list.push(users[i]);
			}
		}
		return new_list;
	}
	
	console.log(
		_filter(users, function(user) { return user.age >= 30; })	
	);
	
	<!-- map 함수 -->
	function _map(list, mapper) {
		var new_list = [];
		for(var i = 0; i < list.length; i++) {
			new_list.push(mapper(list[i]));
		}
		return new_list;
	}
	
	var over_30 = _filter(users, function(user) { return user.age >= 30; });
	console.log(over_30);
	
	var names = _map(over_30, function(user) { return user.name });
	
	console.log(names);
	
	console.log(
		_map(
			_filter(users, function(user) { return user.age >= 30; }),
			function(user) {return user.name; }));
	
	<!-- map / filter의 중복 제거 each 문  -->
	function _each(list, iter) {
		for(var i = 0; i < list.length; i++) {
			iter(list[i]);
		}
		return list;
	}
	
	<!-- map 함수 -->
	function _map(list, mapper) {
		var new_list =[];
		_each(list, function(val) {
			new_list.push(mapper(val));
		});
		return new_list;
	}
	
	<!-- filter 함수 -->
	function _filter(list, predi) {
		var new_list = [];
		_each(list, function(val) {
			if(predi(val)) new_list.push(val);
		});
		return new_list;
	}
	
	console.log(
		_map(
			_filter(users, function(user) { return user.age >= 30; }),
			function(user) {return user.name; }));
	
	<!-- curry / curryr -->
	function _curryr(fn) {
		return function(a, b) {
			return arguments.length == 2 ? fn(a, b) : function(b) { return fn(b, a) ;};
		}
	}
	
	<!-- get -->
	var _get = _curryr(function(obj, key) {
		return obj == null ? undefined : obj[key];
	});
	
	var user1 = users[0];
	console.log(_get(user1, 'name'));
	console.log(_get('name')(user1));
	
	var get_name = _get('name');
	
	console.log(get_name(user1));
	
	console.log(
		_map(
			_filter(users, function(user) { return user.age >= 30 ;}),
			_get('name')));
	
	<!-- reduce 함수 -->
	var slice = Array.prototype.slice;
	
	function _rest(list, num) {
		return slice.call(list, num || 1);	// num에 들어온 값이 없으면 기본값을 1로 준다.
	}
	
	function _reduce(list, iter, memo) {
		if(arguments.length == 2) {
			memo = list[0];
			list = _rest(list);
		}
		_each(list, function(val) {
			memo = iter(memo, val);
		});
		return memo;
	}
	
	<!-- pipe 함수 -->
	function _pipe() {
		var fns = arguments;
		return function(arg) {
			return _reduce(fns, function(arg, fn) {
				return fn(arg);
			}, arg);
		}
	}
	
	var f1 = _pipe(
					function(a) { return a + 1; },
					function(a) { return a + 2; },
					function(a) { return a * a; }); 
	
	console.log(f1(1));
	
	<!-- go 함수 -->
	function _go(arg) {
		var fns = _rest(arguments);
		return _pipe.apply(null, fns)(arg);
	}
	
	_go(1,
		function(a) { return a + 1; },
		function(a) { return a + 2; },
		function(a) { return a * a; },
		console.log);
	
	console.log(
		_map(
			_filter(users, function(user) { return user.age >= 30; }),
			_get('name')));
	
	_go(users,
		function(users) {
			return _filter(users, function(user) { return user.age >= 30; });
		},
		function(users) {
			return _map(users, _get('name'));
		},
		console.log);
	
	var _map = _curryr(_map);
	var _filter = _curryr(_filter);
	
	_go(users,
		_filter(function(user) { return user.age >= 30; }),
		_map(_get('name')),
		console.log);
	
	<!--  keys 함수 -->
	function _keys(obj) {
		return _is_object(obj) ? Object.keys(obj) : [];
	}
	
	function _is_object(obj) {
		return typeof obj == 'object' && !! obj
	}
	
	<!-- each 문의 변경 -->
	
	
	function _each(list, iter) {
		var keys = _keys(list);
		for(var i = 0, len = keys.length; i < len; i++) {
			iter(list[keys[i]], keys[i]);
		}
		return list;
	}
	
</script>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
