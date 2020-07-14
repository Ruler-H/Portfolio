package javaapp0407;

public class Practice {

	public static void main(String[] args) {
		double d1 = 10.776;
		//위의 숫자를 소수 첫째 자리에서 반올림해서 저장
		int result = (int)(d1 + 0.5);
		System.out.println("result : " + result);
		
		//소수 첫째 자리 올림
		//페이지당데이터개수-1 / 페이지당데이터개수
		int count = 111;
		int pageCnt = 20;
		result = (count+(pageCnt-1))/pageCnt;
		System.out.println("result : " + result);
		
		//short는 -32768 ~ 32767까지 저장 가능
		//Overflow 발생 - -32768
		short s1 = (short)-32769;
		System.out.println("s1 : " + s1);
		
		int a = 10;
		int b = 10;
		int c = 20;
		System.out.println("a : " + 
				System.identityHashCode(a));
		System.out.println("b : " + 
				System.identityHashCode(b));
		System.out.println("c : " + 
				System.identityHashCode(c));
		double z = 0.1+0.1;
		System.out.println(z);
	}

}