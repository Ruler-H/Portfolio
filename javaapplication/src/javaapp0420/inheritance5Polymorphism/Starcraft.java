package javaapp0420.inheritance5Polymorphism;

//Zerg, Protoss, Terran과 상속관계를 만들기 위해서 생성한 클래스
//추상 클래스 - 자신의 인스턴스를 생성하지 못하고 상속을 통해서만 사용하는 클래스
public abstract class Starcraft {
	//3개 클래스에 존재하는 attack과 오버라이딩을 위해서 생성한 메소드
	//추상 메소드 - 내용이 없는 메소드
	//추상 메소드는 상속받은 곳에서 반드시 재정의 해야 한다.
	public abstract void attack();

}
