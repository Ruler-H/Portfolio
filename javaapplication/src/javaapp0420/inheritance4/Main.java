package javaapp0420.inheritance4;

public class Main {

	public static void main(String[] args) {
		Employee emp1 = new Employee();
		Manager mgr1 = new Manager();
		
		//상위 클래스 타입으로 만들어진 변수에 하위 클래스 타입의 인스턴스를 형 변환없이 대입 가능
		//Manager 클래스가 Employee 클래스의 하위 클래스라서 가능
		Employee emp2 = new Manager();
		
		//하위 클래스 타입의 변수에는 상위 클래스 타입의 인스턴스를 바로 대입할 수 없고 강제 형 변환을 해서 대입해야 한다.
		//원래 자료형이 하위 클래스 타입이 아니면 예외가 발생
		//Manager mgr2 = new Employee();
		
		//emp2는 Manager()를 호출해서 만들었는데
		//Employee 변수에 저장한 것이라서 형변환해서 대입하면 아무런 문제가 없다.
		Manager mgr3 = (Manager)emp2;
		
		//에러는 아니지만 실행 시 예외가 발생
		//ClassCastException이 발생, 생성할 때 Employee로 생성해서 Manager로 변경이 안됩니다.
		Manager mgr4 = (Manager)(new Employee());
		
		

	}

}
