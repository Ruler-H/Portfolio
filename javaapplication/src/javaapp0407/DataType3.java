package javaapp0407;

public class DataType3 {

	public static void main(String[] args) {
		// byte 변수 2개 생성
		byte b1 = 10;
		byte b2 = 13;
		
		//이 문장은 에러 -> int보다 작은 데이터는 int로 변환해서 연산
		//b1과 b2를 int로 변환해서 연산했기 때문에 결과도 int가 된다.
		//int는 byte에 저장 못한다.
		//byte result = b1 + b2;
		
		int result = b1 + b2;
		//int / int = int
		result = 10 / 3;
		System.out.println("result : " + result);
		//double / int 는 int를 double로 변경해서 실행 -> 결과가 3.33333...
		//자동으로 double형으로 바꾼 것이 자동 형 변환
		System.out.println("result : " + (10.0/3));
		
		int x = (int)20.7;
		System.out.println("x : " + x);
		
		byte b5 = 10;
		byte b6 = 13;
		//덧셈한 결과를 byte에 저장
		//강제 형 변환을 이용해서 해결
		//연산 중에는 int로 형 변환되기 때문에 연산이 끝난 후 byte 형으로 강제 형 변환을 시킴
		byte b7 = (byte)(b5 + b6);
		System.out.println("b5 + b6 = " + b7);
		
		double d = (double)10/3;
		System.out.println("d : " + d);
	}

}
