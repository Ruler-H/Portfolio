package javaapp0522;

import org.junit.Test;

public class TestApp {
	
	//JUnit을 이용해서 테스트할 수 있도록 해주는 어노테이션
	@Test
	public void DAOTest() {
		TestDAO dao = new TestDAO();
		dao.insert();
	}
}
