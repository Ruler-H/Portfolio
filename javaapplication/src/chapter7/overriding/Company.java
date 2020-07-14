package chapter7.overriding;

import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		String result = "";	//결과 문자열
		Employee emp = null;	//Employee객체의 레퍼런스 변수
		
		String empNo = null;	//사원번호를 입력받는 변수
		String name = null;	//이름을 입력받는 변수
		String part = null;	//부서를 입력받는 변수
		String position = null;	//직책을 입력받는 변수
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사번 입력(예)A1010 : ");
		empNo = sc.nextLine();
		System.out.print("이름 입력(예)황병헌 : ");
		name = sc.nextLine();
		System.out.print("부서 입력(예)기획 : ");
		part = sc.nextLine();
		System.out.print("직책 입력(예)사원-1, 대리-2, 과장-3 : ");
		position = sc.nextLine();
		
		//position의 값이 "1"이면 사원, 그외이면 관리자
		if(position.equals("1")) {
			//사원
			//Employee클래스의 객체 emp를 생성
			emp = new Employee(empNo, name, part);
		}else {
			//관리자
			//position의 값이 "2"이면 대리로, 그외이면 과장으로 대치
			position = (position.equals("2")) ? "대리" : "과장";
			//Manager클래스의 객체 mng를 생성
			emp = new Manager(empNo, name, part, position);
		}
		result += emp.resultStr();
		//결과 문자열을 콘솔에 출력
		System.out.println(result);
		sc.close();

	}

}
