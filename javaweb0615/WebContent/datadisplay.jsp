<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "domain.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료 구조</title>
</head>
<body>
	<%
		List<DataStructure> list = new ArrayList<>();
		list.add(new DataStructure("list", "데이터의 연속적인 모임"));
		DataStructure set = new DataStructure("set", "데이터들 순서와 상관없이 중복되지 않게 저장하기");
		list.add(set);
		DataStructure map = new DataStructure();
		map.setName("map");
		map.setDescription("Key와 Value 쌍으로 저장하는 자료구조");
		list.add(map);
		
		for(DataStructure ds : list){
	%>
	<h3><%=ds %></h3>
	<%
		}
	%>
</body>
</html>