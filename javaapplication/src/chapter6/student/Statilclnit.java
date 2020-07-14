package chapter6.student;

public class Statilclnit {

	public static void main(String[] args) {
		Student3 obj1;
		System.out.println("static 초기화는 클래스의 생성자를 처음 호출하면 수행됩니다.");
		obj1 = new Student3();
		Student3 obj2 = new Student3();

	}

}
