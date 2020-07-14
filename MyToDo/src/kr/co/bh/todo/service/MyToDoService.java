package kr.co.bh.todo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyToDoService {
	//데이터 저장
	public void create();
	//데이터 읽기
	public void read();
	//데이터 갱신
	public void update();
	//데이터 삭제
	public void delete();
	
	//로그인 처리
	public void login(HttpServletRequest request, HttpServletResponse response);
}
