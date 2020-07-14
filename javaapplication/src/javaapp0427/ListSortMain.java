package javaapp0427;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortMain {

	public static void main(String[] args) {
		// 정수 데이터를 저장할 수 있는 ArrayList를 생성
		ArrayList<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(10);
		list.add(50);
		list.add(70);
		list.add(20);
		list.add(30);
		list.add(80);
		list.add(90);
		
		//데이터를 오름차순 정렬
		list.sort(new Comparator<Integer>() {

			@Override
			// 숫자 데이터의 경우 앞의 데이터에서 뒤의 데이터를 뺄셈한 결과를 리턴하면 오름차순 정렬
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
			
		});
		//결과 확인
		System.out.println(list);
		
		// 문자열을 저장하는 ArrayList를 생성
		ArrayList<String> strList = new ArrayList<>();
		// 데이터 추가
		strList.add("갱플랭크");
		strList.add("쓰레쉬");
		strList.add("피즈");
		strList.add("미스 포츈");
		strList.add("에코");
		strList.add("다리우스");
		strList.add("제이스");
		strList.add("이렐리아");
		strList.add("케이틀린");
		strList.add("애쉬");
		strList.add("진");
		strList.add("애니");
		
		// 데이터를 내림차순 정렬
		strList.sort(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// String과 Date는 compareTo 메소드를 이용해서 크기 비교 수행
				// 앞의 데이터를 기준으로 비교 : 오름차순
				// 뒤의 데이터를 기준으로 비교 : 내림차순
				// 알고리즘에서는 비교하는 부등호의 방향을 반대로
				return o1.compareTo(o2);
			}
			
		});
		// 전체 데이터를 확인
		System.out.println(strList);

	}

}
