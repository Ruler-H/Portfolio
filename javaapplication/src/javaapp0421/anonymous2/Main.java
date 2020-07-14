package javaapp0421.anonymous2;

public class Main {

	public static void main(String[] args) {
		//인터페이스를 구현한 인스턴스를 바로 만들어서 사용
		Inter interImpl = new Inter() {
			@Override
			public void method() {
				System.out.println("메소드");
				
			}
			
		};
		interImpl.method();

	}

}
