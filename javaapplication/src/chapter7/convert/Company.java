package chapter7.convert;

import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		String result = ""; // 결과 문자열
		Employee emp = null; // Employee객체의 레퍼런스 변수
		Manager mng = null; // Manager객체의 레퍼런스 변수
		String empNo = null; // 사원번호를 입력받는 변수
		String name = null; // 이름을 입력받는 변수
		String part = null; // 부서를 입력받는 변수
		String position = null; // 직책을 입력받는 변수
		Scanner sc = new Scanner(System.in);

		System.out.print("사번 입력(예)A1010 : ");
		empNo = sc.nextLine();
		System.out.print("이름 입력(예)황병헌 : ");
		name = sc.nextLine();
		System.out.print("부서 입력(예)기획 : ");
		part = sc.nextLine();
		System.out.print("직책 입력(예)사원-1, 대리-2, 과장-3 : ");
		position = sc.nextLine();

		// position 값이 1이면 사원, 그 외이면 관리자
		if (position.equals("1")) {
			emp = new Employee(empNo, name, part);
			result += emp.resultStr();
		} else {
			position = (position.equals("2")) ? "대리" : "과장";
			mng = new Manager(empNo, name, part, position);
			result += mng.resultStr();
		}

		System.out.println(result);
		sc.close();

	}

}
