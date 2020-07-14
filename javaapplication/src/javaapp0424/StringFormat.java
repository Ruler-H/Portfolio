package javaapp0424;

public class StringFormat {

	public static void main(String[] args) {
		Integer x = 100;
		Integer y = 300;
		
		//인스턴스를 문자열로 변환 - toString으로 호출
		//프로그래밍언어마다 이러한 메소드가 존재
		String msg = x.toString();
		
		//문자열과 문자열을 결합
		msg = x.toString() + y.toString();
		System.out.println(msg);
		
		//x:  100 y:  200으로 출력
		//숫자는 5자리로 표현
		//되도록이면 변수에 저장하고 출력
		//지금은 콜손에 출력하기 때문에 printf를 이용하지만
		//GUI 프로그램에서는 뷰에 텍스트를 설정하기 때문에 문자열 데이터를 대입하는 구조로 출력함
		msg = String.format("x:%5d y:%5d", x, y);
		System.out.println(msg);
		System.out.printf("x:%5d y:%5d", x, y);

	}

}
