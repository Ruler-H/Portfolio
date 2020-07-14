package javaapp0408;

public class DataType6 {

	public static void main(String[] args) {
		// && : and, || : or
		int score = 78;
		// 위의 점수가 60에서 100사이인지 확인
		System.out.println(score >= 60 && score <= 100);
		//score가 0보다 작거나 100보다 큰 지 확인
		System.out.println(score < 0 || score > 100);
		
		//&&는 앞의 결과가 false이면 뒤의 결과확인 안함
		//||는 앞의 결과가 true이면 뒤의 결과확인 안함
		int idx = 0;
		boolean result = 10 > 5 && (idx++) > 0;
		//false -> idx = 1
		System.out.println("result : " + result); 
		System.out.println("idx : " + idx);
		
		idx = 0;
		//true -> idx = 0
		result = 10 > 5 || (idx++) > 0;
		System.out.println("result : " + result);
		System.out.println("idx : " + idx);
		
		//윤년 체크
		//윤년의 조건
		//1. 4의 배수이고 100의 배수는 아닌 경우
		//2. 400의 배수인 경우
		//1번 또는 2번의 조건을 만족하면 윤년
		//배수인지 확인하는 방법은 그 숫자로 나눈 나머지가 0
		int year = 2020;
		//year가 윤년인지 판별
		if(((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0) {
			System.out.println(year + "는 윤년");
		}else {
			System.out.println(year + "는 윤년이 아님");
		}

	}

}
