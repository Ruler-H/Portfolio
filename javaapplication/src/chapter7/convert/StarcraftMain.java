package chapter7.convert;

public class StarcraftMain {

	public static void main(String[] args) {
		Terran marine = new Terran();
		marine.attack();
		Protoss dragoon = new Protoss();
		dragoon.attack();
		Zerg hydralisk = new Zerg();
		hydralisk.attack();
		System.out.println("===객체 형변환과 오버라이딩을 이용===");
		Starcraft obj = new Terran();
		//상위 클래스의 참조형 변수에 하위 클래스의 객체를 대입
		obj.attack();	//shot() 메소드 호출
		obj = new Protoss();
		obj.attack();	//shot() 메소드 호출
		obj = new Zerg();
		obj.attack();	//shot() 메소드 호출
		//error 추상 클래스는 자신의 생성자를 이용해서 객체를 생성할 수 없음 - obj = new Starcraft(); obj.shot();

	}

}
