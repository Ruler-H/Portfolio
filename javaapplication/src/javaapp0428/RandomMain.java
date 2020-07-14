package javaapp0428;

import java.util.Random;

public class RandomMain {

	public static void main(String[] args) {
		// Random 인스턴스 만들기 - seed를 동적으로 설정
		Random r = new Random();
		String [] champion =
			{"카직스", "조이", "뽀삐", "그레이브즈", "직스", "말파이트", "자르반 4세", "피오라", "레오나", "트위스티드 페이트"};
		System.out.println(champion[r.nextInt(champion.length)]);

	}

}
