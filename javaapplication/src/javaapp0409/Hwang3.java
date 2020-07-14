package javaapp0409;

public class Hwang3 {

	public static void main(String[] args) {
		//키보드 입력 객체 만들기
		java.util.Scanner sc =
				new java. util.Scanner(System.in);
		//정수 입력받기
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.println(name + "의 점수는 " + score + "점 입니다.");
		
		//사용종료 - 연결해제
		sc.close();

	}

}
