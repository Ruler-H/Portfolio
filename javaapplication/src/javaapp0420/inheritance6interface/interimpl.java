package javaapp0420.inheritance6interface;

public class interimpl implements Inter1, Inter2{

	@Override
	public void method1() {
		System.out.println("첫번째 인터페이스의 메소드 구현");
		
	}

	@Override
	public void method2() {
		System.out.println("두번째 인터페이스의 메소드 구현");
		
	}



}
