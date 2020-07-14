<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="login.do" method="post" id="loginform">
		아이디<input type="text" size="30" name="id" id="id"/><br/>
		비밀번호<input type="password" size="30" name="pw" id="pw"/><br/>
		<input type="submit" value="로그인"/>
		<p id="loginbtn">로그인</p>
	</form>
	<script>
		document.getElementById("loginbtn").addEventListener("click",function(event){
			document.getElemnetById("loginform").submit();
		});
	</script>
</body>
</html>