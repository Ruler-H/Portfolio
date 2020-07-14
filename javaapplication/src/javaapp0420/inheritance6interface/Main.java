package javaapp0420.inheritance6interface;

public class Main {

	public static void main(String[] args) {
		//인터페이스도 변수 선언 가능
		Inter1 obj = new interimpl();
		obj.method1();
		Inter2 obj1 = new interimpl();
		obj1.method2();

	}

}
