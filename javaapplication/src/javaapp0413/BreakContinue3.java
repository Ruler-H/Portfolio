package javaapp0413;

import java.util.Scanner;

public class BreakContinue3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int idx = 0; idx < 6; idx = idx + 1) {
			System.out.print("숫자 입력(1 ~ 45) : ");
			int su = sc.nextInt();
			if(su < 1 || su > 45) {
				System.out.println("잘못된 숫자를 입력하셨습니다.");
				idx = idx - 1;
				continue;
			}
				System.out.println(idx + 1 + "번째 숫자 : " + su);
		}
		
		System.out.println("종료");

	}

}
