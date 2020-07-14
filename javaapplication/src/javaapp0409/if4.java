package javaapp0409;

public class if4 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("점수를 입력 하십시오(0~100) : ");
		int score = sc.nextInt();
		//80~100이면 우수
		if(80 <= score && 100 >= score) {
			System.out.print("우수");
		//60~79이면 보통
		}else if(60 <= score && 79 >= score) {
			System.out.print("보통");
		//0~59이면 노력
		}else if(0 <= score && 59 >= score) {
			System.out.print("노력");
		//그 이외의 경우는 잘못된 점수
		}else {
			System.out.print("잘못된 점수 입력");
		}
		sc.close();

	}

}
