package javaapp0423;

public class StringTest1 {

	public static void main(String[] args) {
		// 문자열 인스턴스를 생성 - 리터럴을 이용해서 생성
		String str = "Hello23!!World{";
		
		//문자열의 길이(length)를 출력
		//int length()
		int len = str.length();
		System.out.println("길이는 " + len);
		
		//문자열 안에서 특정한 위치의 문자를 출력
		//char charAt(int idx)
		char imsi = str.charAt(3);
		System.out.println("3번째 문자 : " + imsi);
		
		//str에 있는 모든 문자를 순서대로 출력
		//charAt와 length를 이용
		int big = 0;
		int small = 0;
		int su = 0;
		int etc = 0;
		for(int i = 0; i < len; i = i + 1) {
			char ch = str.charAt(i);
			//System.out.print(ch);
			//대문자 확인
			if(ch >= 'A' && ch <= 'Z') {
				big = big + 1;
			}else if(ch >= 'a' && ch <= 'z') {
				small = small + 1;
			}else if(ch >= '0' && ch <= '9') {
				su = su + 1;
			}else {
				etc = etc + 1;
			}
		}
		System.out.println("대문자 개수 : " + big);
		System.out.println("소문자 개수 : " + small);
		System.out.println("숫자 개수 : " + su);
		System.out.println("특수문자 개수 : " + etc);
		
		//영문 대문자, 소문자, 숫자, 특수문자가 1개 이상있으면 사용 가능한 비밀번호
		//4가지 중 한 가지라도 없으면 사용 불가능한 비밀번호라고 출력
		if(big * small * su * etc != 0) {
			System.out.println("사용 가능한 비밀번호");
		}else {
			System.out.println("사용 불가능한 비밀번호");
		}
	}

}

