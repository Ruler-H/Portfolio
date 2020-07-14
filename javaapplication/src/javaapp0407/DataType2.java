package javaapp0407;

public class DataType2 {

	public static void main(String[] args) {
		// 22억 이상의 정수는 long 형으로 표현
		long n = 2200000000L;
		
		//final이 붙은 변수는 데이터를 수정할 수 없습니다.
		//이름을 모두 대문자로 만드는 것을 권장
		final int AGE = 29;
		
		//수정 가능한 데이터
		int balance = 1000;
		//수정 불가능한 데이터
		final int READONLY = balance;
		
		//작은 크기의 자료형 데이터는 큰 자료형에 대입 가능
		double d = READONLY;
		
		//큰 크기의 자료형 데이터를 작은 자료형 데이터에 대입하는 것은 안됨
		int i = 314; //실수는 정수변수에 대입안됨
		
	}

}
