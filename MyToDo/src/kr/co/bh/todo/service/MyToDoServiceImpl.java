package kr.co.bh.todo.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.bh.todo.repository.MyToDoDao;

public class MyToDoServiceImpl implements MyToDoService {
	//Dao를 사용
	private MyToDoDao myToDoDao;
	private MyToDoServiceImpl() {
		//DAO 인스턴스를 생성
		myToDoDao = MyToDoDao.shredInstance();
	}
	//인터페이스를 implements한 경우에는 변수는 인터페이스 자료형으로 선언한다.
	private static MyToDoService myToDoService;
	public static MyToDoService sharedInstance() {
		if(myToDoService == null) {
			myToDoService = new MyToDoServiceImpl();
		}
		return myToDoService;
	}
	@Override
	public void create() {
		System.out.println("데이터 저장");
		myToDoDao.create();
	}

	@Override
	public void read() {
		System.out.println("데이터 읽기");
		myToDoDao.read();
	}

	@Override
	public void update() {
		System.out.println("데이터 갱신");
		myToDoDao.update();
	}

	@Override
	public void delete() {
		System.out.println("데이터 삭제");
		myToDoDao.delete();
	}
	
	@Override
	public void login(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//1. 파라미터 읽어오기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//2. 필요한 작업이 있으면 수행
		
		//3. Dao 메소드를 호출해야 하는 경우 Dao 메소드의 파라미터를 만들고 Dao 메소드를 호출한다. - 결과를 받기
		
		//4. 결과를 사용 - 로그인 같은 경우 성공했을 때 세션에 User 정보를 저장
		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("nickname", "관리자");
	}

}
