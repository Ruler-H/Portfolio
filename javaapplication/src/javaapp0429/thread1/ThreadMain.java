package javaapp0429.thread1;

public class ThreadMain {

	public static void main(String[] args) {
		ThreadEx th1 = new ThreadEx();
		ThreadEx th2 = new ThreadEx();
		//일반 프로세스 형태로 호출
		//th1.run();
		//th2.run();
		
		//스레드로 실행
		th1.start();
		th2.start();

	}

}
