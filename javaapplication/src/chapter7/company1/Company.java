package chapter7.company1;

import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		// 출력할 때 사용할 임시변수
		String result = "";

		// Employee와 Manager 객체의 참조를 저장할 변수
		Employee emp = null;
		Manager man = null;

		// 3가지 정보를 입력받아서 저장할 임시 변수
		String name = "";
		String part = "";
		String position = "";

		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		name = sc.nextLine();
		System.out.print("부서를 입력하세요 : ");
		part = sc.nextLine();
		System.out.print("직책을 입력하세요(1. 사원 2. 관리자) : ");
		position = sc.nextLine();

		// position 1이면 Employee 객체를 만들어서 출력
		// position 2이면 Manager 객체를 만들어서 출력
		if (position.equals("1")) {
			emp = new Employee(name, part);
			result = emp.resultStr();
		} else {
			man = new Manager(name, part, "관리자");
			result += man.addStr();
		}
		System.out.println(result);
		sc.close();

	}

}
