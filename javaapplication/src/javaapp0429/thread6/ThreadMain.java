package javaapp0429.thread6;

public class ThreadMain {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i = i + 1) {
			ThreadEx th = new ThreadEx();
			th.start();
		}
		 

	}

}
