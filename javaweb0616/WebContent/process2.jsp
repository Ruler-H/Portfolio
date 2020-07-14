<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼의 파라미터 읽기</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		//name, gender, hobby의 값 읽어보기
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String [] hobby = request.getParameterValues("hobby");
		String disp = "";
		if(hobby == null){
			//선택하지 않았을 경우 처리
			disp = "선택하지 않음";
		}else{
			//선택했을 경우 처리
			for(String temp : hobby){
				disp += temp + "\t";
			}
		}
	%>
	<h3>이름 : <%=name %></h3>
	<h3>성별 : <%=gender %></h3>
	<h3>취미 : <%=disp %></h3>

</body>
</html>