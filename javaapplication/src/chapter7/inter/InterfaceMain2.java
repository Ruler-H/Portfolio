package chapter7.inter;
public class InterfaceMain2 {
	public static void main(String[] args) {
		MultiImpl obj = new MultiImpl();
		System.out.println("Inter1의 a = " + MultiImpl.a);
		System.out.println("Inter2의 b = " + MultiImpl.b);
		obj.method1();
		obj.method2();
	}
}