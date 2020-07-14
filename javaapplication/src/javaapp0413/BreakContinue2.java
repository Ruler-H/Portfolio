package javaapp0413;

import java.util.Scanner;

public class BreakContinue2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//무한반복
		while(true) {
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			if(id.equals("root") != true) {
				break;
			}
			System.out.println("존재하는 아이디");
		}
		
		System.out.println("사용 가능한 아이디");
		
		//스캐너 사용 종료
		sc.close();
	}

}
