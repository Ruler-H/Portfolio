package chapter7.inter;

public class InterImpl implements Inter{
	public void method1() {
		System.out.println("abstrat가 있으면 당연히 추상메소드");
	}
	
	public void method2() {
		System.out.println("abstract가 없어도 추상메소드");
	}

}
