package javaapp0423;

import java.util.Scanner;

public class StringTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int big = 0, small = 0, su = 0, etc = 0;
		int len = 0;
		while (true) {
			try {
				System.out.print("비밀번호 입력 : ");
				String str = sc.nextLine();
				len = str.length();

				for (int i = 0; i < len; i = i + 1) {
					char ch = str.charAt(i);
					// System.out.print(ch);
					// 대문자 확인
					if (ch >= 'A' && ch <= 'Z') {
						big = big + 1;
					} else if (ch >= 'a' && ch <= 'z') {
						small = small + 1;
					} else if (ch >= '0' && ch <= '9') {
						su = su + 1;
					} else {
						etc = etc + 1;
					}
				}
				if (big * small * su * etc != 0) {
					System.out.println("사용 가능한 비밀번호");
					break;
				}
				int num = Integer.parseInt(str);
			} catch (Exception e) {
				System.out.println("사용 불가능한 비밀번호");
			}
		}
		sc.close();

	}

}
