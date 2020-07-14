<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 출력</title>
</head>
<body>
	<%
		//앞에서 넘겨준 데이터를 가져오기
		//Boolean result = (Boolean)request.getAttribute("result");
		Boolean result = (Boolean)session.getAttribute("result");
		if(result == true){
			out.println("회원 가입 성공");
		}else{
			out.println("회원 가입 실패");
		}
	%>
</body>
</html>