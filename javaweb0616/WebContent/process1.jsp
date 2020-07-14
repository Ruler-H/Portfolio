<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 읽기</title>
</head>
<body>
	<%
		//boardnum이라는 파라미터 읽기
		String boardnum = request.getParameter("boardnum");
		//nickname이라는 파라미터 읽기
		String nickname = request.getParameter("nickname");
		//없는 파라미터 읽기
		String readcnt = request.getParameter("readcnt");
	%>
	<h3>boardnum : <%=boardnum %></h3>
	<h3>nickname : <%=nickname %></h3>
	<h3>readcnt : <%=readcnt %></h3>
</body>
</html>