package javaapp0420.inheritance5Polymorphism;

public class Main {

	public static void main(String[] args) {
		//참조형 변수의 멤버 호출
		//호출할 수 있는 것의 판단은 클래스를 가지고 판단
		//오버라이딩 된 메소드는 생성자를 가지고 판단
		Starcraft star = new Zerg();
		star.attack();
		
		star = new Protoss();
		star.attack();
		
		star = new Terran();
		star.attack();
		

	}

}
