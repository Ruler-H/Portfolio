package chapter7.inter;

public class InterfaceMain1 {

	public static void main(String[] args) {
		InterImpl obj = new InterImpl();
		//obj.a = 200;
		obj.method1();
		System.out.println("인터페이스에서는 final을 사용하지 않아도 변수는 final");
		System.out.println("인터페이스에서는 abstract을 사용하지 않아도 메소드는 abstract");

	}

}
