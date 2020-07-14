package javaapp0427;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListCompare {

	public static void main(String[] args) {
		// 문자열을 저장하는 ArrayList와 LinkedList를 생성
		ArrayList<String> al = new ArrayList<>();
		LinkedList<String> li = new LinkedList<>();

		// 데이터를 2개씩 삽입
		al.add("First");
		al.add("Third");

		li.add("First");
		li.add("Third");

		// 1번째 자리에 Second 문자열을 10만개 삽입하고 시간을 측정
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i = i + 1) {
			al.add(1, "Second");
		}

		long end = System.nanoTime();
		System.out.println("ArrayList : " + (end - start));
		
		start = System.nanoTime();
		for (int i = 0; i < al.size(); i = i + 1) {
			al.get(i);
		}
		end = System.nanoTime();
		System.out.println("ArrayList : " + (end - start));

		start = System.nanoTime();
		for (int i = 0; i < 100000; i = i + 1) {
			li.add(1, "Second");
		}
		end = System.nanoTime();
		System.out.println("LinkedList : " + (end - start));

		start = System.nanoTime();
		for (int i = 0; i < al.size(); i = i + 1) {
			li.get(i);
		}
		end = System.nanoTime();
		System.out.println("LinkedList : " + (end - start));
	}

}
