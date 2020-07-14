package javaapp0428;

import java.util.Scanner;
import java.util.TreeSet;

public class LottoSet {

	public static void main(String[] args) {
		// TreeSet : 중복된 데이터 없이 정렬해서 데이터를 저장하는 구조
		TreeSet<Integer> lotto = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		while (lotto.size() < 6) {
			try {
				System.out.print("정수 입력(1~45) : ");
				String input = sc.nextLine();
				int su = Integer.parseInt(input);
				// 1부터 45 사이의 숫자가 아니면 입력 다시
				if (su < 1 || su > 45) {
					System.out.println("1부터 45사이의 정수를 입력하세요!!!");
					continue;
				}
				// Set에 데이터 삽입
				boolean result = lotto.add(su);
				// 삽입에 실패한 경우는 중복된 데이터를 삽입한 경우
				if (result == false) {
					System.out.println("중복된 데이터입니다!!");
				}
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요!!!");
			}
		}

		// 데이터 출력
		for (int temp : lotto) {
			System.out.printf(temp + "\t");
		}
		sc.close();

	}

}
