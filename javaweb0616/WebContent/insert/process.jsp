<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Date" %>
<%@ page import = "java.io.*" %>
<%
	//파라미터 인코딩 방식 설정		post 방식으로 전송할 경우 필수
	request.setCharacterEncoding("utf-8");
	//1. 파라미터 읽기
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String nickname = request.getParameter("nickname");
	//콘솔에 출력		null이 출력되면 파라미터 이름이 잘못되었거나 선택을 하지 않은 것
	System.out.println("email : " + email);
	System.out.println("password : " + password);
	System.out.println("nickname : " + nickname);
	
	//2. Business Logic 처리
	boolean result = true;
	//오늘 날짜를 문자열로 만들기
	Calendar calendar = new GregorianCalendar();
	Date today = new Date(calendar.getTimeInMillis());
	String filename = today.toString();
	
	//insert의 절대 경로 가져오기
	String filepath = application.getRealPath("/insert");
	String logfile = filepath + "/" + filename + ".txt";
	
	//현재 프로젝트의 insert 디렉토리에 오늘 날짜.txt		파일에 email, password, nickname을 기록
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logfile, true)));
	
	//파일에 기록
	pw.println(email + " : " + password + " : " + nickname + " : " + request.getRemoteAddr() + "\n");
	
	//버퍼를 비우고 스트림 닫기
	pw.flush();
	pw.close();
	
	/*
	//3. 결과를 저장하고 결과 페이지로 이동
	request.setAttribute("result", result);
	*/
	//3. 세션에 결과를 저장
	session.setAttribute("result", result);
	
	/*
	//포워딩 하기
	RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
	dispatcher.forward(request, response);
	*/
	
	//리다이렉트 하기
	response.sendRedirect("output.jsp");
%>