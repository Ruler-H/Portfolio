package chapter7.inter;

public interface MyInterface {
	//추상 메소드이므로 하위 클래스에서 재정의해야 한다.
	public void method1();
	//추상 메소드가 아니므로 하위 클래스에서 재정의하지 않아도 된다.
	public default void method2() {
		System.out.println("default method");
	}

}
