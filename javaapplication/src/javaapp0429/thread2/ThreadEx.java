package javaapp0429.thread2;

public class ThreadEx extends Thread {
	//스레드로 동작할 메소드
	@Override //안 해도 되는데 상위 클래스에 없는 메소드에 붙이면 에러
	public void run() {
		try {
			//0.5초 마다 문자열을 10번 출력
			for(int i = 0; i < 10; i = i + 1) {
				Thread.sleep(500);
				System.out.println("라투");
			}
			System.out.println("라투 사망");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
