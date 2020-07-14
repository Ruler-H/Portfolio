package javaapp0409;

public class Hwang2 {

	public static void main(String[] args) {
		String w1 = "콜라";
		String w2 = "사이다";
		//2개의 내용물을 swap
		//빈 컵을 만들고 콜라를 대입
		String w3 = w1;
		//콜라가 들어있던 컵에 사이다를 대입
		w1 = w2;
		//사이다가 들어있던 컵에 콜라를 대입
		w2 = w3;
		
		System.out.println("w1 : " + w1);
		System.out.println("w2 : " + w2);

	}

}
