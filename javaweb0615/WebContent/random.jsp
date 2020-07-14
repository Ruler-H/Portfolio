<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 빈 줄을 없애주는 옵션 -->
    <%@ page trimDirectiveWhitespaces="true" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랜덤한 숫자 생성</title>
</head>
<body>
	<%
		//랜덤 객체 생성
		Random random = new Random();
		//1~45 사이의 랜덤한 숫자 6개를 정령해서 저장하기, 숫자는 중복되면 안됨
		TreeSet<Integer> lotto = new TreeSet<>();
		while(lotto.size() < 6){
			//Set은 중복된 데이터를 저장하지 않기 대문에 6개가 될 때까지 수행
			//nextInt 숫자로 나눈 나머지를 랜덤하게 리턴
			lotto.add(random.nextInt(45)+1);
		}
	%>
	
	<!--  java 데이터 출력하기 -->
	<h3><%= lotto %></h3>
</body>
</html>