package javaapp0427;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListMain {

	public static void main(String[] args) {
		//문자열을 저장할 ArrayList를 생성
		ArrayList<String> list = new ArrayList<>();
		
		//데이터 추가
		list.add("갱플랭크");
		list.add("룰루");
		list.add("쓰레쉬");
		list.add("에코");
		list.add("미스 포츈");
		list.add(2, "제라스");	//2번째에 데이터 추가
		
		//이숙자라는 데이터를 삭제
		list.remove("미스 포츈");
		//위치를 가지고 삭제
		list.remove(1);
		//데이터 전체를 확인 - toString으로 확인
		System.out.println(list);
		
		//빠른 열거를 이용 - 전체 데이터를 순서대로 접근할 때는 간결
		for(String temp : list) {
			System.out.printf(temp + "\t");
		}
		System.out.printf("\n");
		//인덱스를 이용한 접근 - 짝수 번째나 홀수 번째 골라내서 접근 가능
		int size = list.size();
		for(int i = 0; i < size; i = i + 1) {
			System.out.printf(list.get(i) + "\t");
		}
		System.out.printf("\n");

	}

}
