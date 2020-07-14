package javaapp0423;

import java.math.BigDecimal;
import java.util.Scanner;

public class WrapperMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("정수 입력 : ");
				String input = sc.nextLine();
				int num = Integer.parseInt(input);

				System.out.println("num : " + num);
				break;
			} catch (Exception e) {
				System.out.println("숫자로 입력하세요!!!");
			}
		}

		sc.close();
		
		//숫자로 된 문자열을 생성자에 대입해서 BigDecimal
		//인스턴스 2개 만들기
		BigDecimal b1 = new BigDecimal("999");
		BigDecimal b2 = new BigDecimal("444");
		//더하기
		BigDecimal result = b1.add(b2);
		//정수로 저장하기
		int n = result.intValue();
		System.out.println("b1 + b2 = " + n);
	}

}
