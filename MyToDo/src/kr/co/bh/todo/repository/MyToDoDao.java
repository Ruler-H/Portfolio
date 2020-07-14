package kr.co.bh.todo.repository;

public class MyToDoDao {
	//싱글톤 패턴으로 만들기 위한 코드
	private MyToDoDao() {
		
	}
	private static MyToDoDao myToDoDao;
	public static MyToDoDao shredInstance() {
		if(myToDoDao == null) {
			myToDoDao = new MyToDoDao();
		}
		return myToDoDao;
	}
	
	public void create() {
		System.out.println("DAO 에서 데이터 저장");
	}
	
	public void read() {
		System.out.println("DAO 에서 데이터 가져오기");
	}
	
	public void update() {
		System.out.println("DAO 에서 데이터 수정");
	}
	
	public void delete() {
		System.out.println("DAO 에서 데이터 삭제");
	}
}
