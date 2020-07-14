package javaapp0427;

import java.util.PriorityQueue;

public class Queue {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(100);
		pq.add(50);
		pq.add(200);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());

	}

}
