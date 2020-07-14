package javaapp0424;

public class ArrayMain1 {

	public static void main(String[] args) {
		String [] data = {"3000", "4000", "-", "4500"};
		
		//위의 4개를 정수로 변환해서 합계를 구하기
		//합계를 저장할 변수 초기화
		int sum = 0;
		for(String temp : data) {
			System.out.println(temp);
			try {
			//문자열을 정수로 변환해서 sum에 더하기
			sum = sum + Integer.parseInt(temp);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//출력할 메시지를 만들어서 출력
		String msg = String.format("합계 : %d", sum);
		System.out.println(msg);

	}

}
