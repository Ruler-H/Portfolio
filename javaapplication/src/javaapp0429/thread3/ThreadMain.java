package javaapp0429.thread3;

public class ThreadMain {

	public static void main(String[] args) {
		ThreadEx th = new ThreadEx();
		th.start();

		try {
			Thread.sleep(3000);
			//th에 InterruptedException을 발생 시킴
			//스레드 수행 내용에서 구문이 종료되면 스레드도 종료
			th.interrupt();
		}catch(Exception e) {
			
		}
	}

}
