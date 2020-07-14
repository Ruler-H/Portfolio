package chapter7.inter;

public class MultiImpl implements Inter1, Inter2 {

	@Override
	public void method2() {
		System.out.println("Inter2의 메소드");

	}

	@Override
	public void method1() {
		System.out.println("Inter1의 메소드");

	}

}
