package javaapp0420.inheritance5Polymorphism;

public class Zerg extends Starcraft{
	//상위 클래스의 메소드를 오버라이딩 했다고 명시적으로 알려주는 어노테이션
	//annotation : 컴파일할 때나 실행할 때 프로그래밍언어의 코드로 변경되서 특별한 기능을 수행해 주는 명령러
	@Override
	public void attack() {
		System.out.println("저그의 공격");

	}

}
