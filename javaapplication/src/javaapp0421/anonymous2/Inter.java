package javaapp0421.anonymous2;

//인터페이스는 final 상수와 추상 메소드를 소유한 개체
//변수는 만들면 상수가 되고 메소드는 모양만 만들어야 한다.
//앞에 default를 붙이면 내용이 있는 메소드를 만들 수 있고 이 메소드는 필요에 따라 재정의를 한다.
//하나의 클래스에 여러 개의 인터페이스를 implements할 수 있음
//사용하는 이유는 템플릿 메소드 패턴이나 다형성 구현
//템플릿 메소드 패턴은 모양을 만들고 내용을 구현하는 것이고
//Starcraft -> StarcraftImpl

//다형성은 동일한 코드가 대입된 인스턴스에 따라 다르게 반응하는 것
//Starcraft -> Zerg
//Starcraft -> Terran
//Starcraft -> Protoss
public interface Inter {
	public void method();

}
