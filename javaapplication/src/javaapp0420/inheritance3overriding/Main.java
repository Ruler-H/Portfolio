package javaapp0420.inheritance3overriding;

public class Main {

	public static void main(String[] args) {
		//Employee 인스턴스 생성
		//어떤 클래스의 인스턴스를 1개만 만드는 경우 인스턴스의 참조를 저장할 변수를 클래스의 이름과 동일하게 하고 첫글자만 소문자로 하는 경우가 많음
		Employee employee = new Employee();
		employee.setEmpName("아이린");
		employee.setEmpPart("가수");
		System.out.println(employee.resultStr());
		
		//Manager 클래스의 인스턴스를 생성하고 값을 대입
		Manager manager = new Manager();
		manager.setEmpName("이수만");
		manager.setEmpPart("SM");
		manager.setRank("대표이사");
		System.out.println(manager.resultStr());
		
		
		//Employee 인스턴스를 1개 더 생성하고 값을 대입, 첫번째와 다른 생성자를 이용
		Employee emp1 = new Employee("조이", "가수");
		System.out.println(emp1.resultStr());
		

	}

}
