<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyToDo</title>
</head>
<body>
	<a href = "create.do">삽입</a><br/>
	<a href = "read.do">조회</a><br/>
	<a href = "update.do">갱신</a><br/>
	<a href = "delete.do">삭제</a><br/>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:if test="${id == null}">
		<a href="login.do">로그인</a><br/>
	</c:if>
	<c:if test="${id != null}">
		<a href="logout.do">로그아웃</a><br/>
	</c:if>
	<a href="write.do">글쓰기</a><br/>
</body>
</html>