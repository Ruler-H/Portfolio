package javaapp0429.thread5;

public class Customer extends Thread {
	// 공유자원을 소비하는 메소드
	public synchronized void get() {
		//사용할 자원이 없으면 대기
		if(ShareData.list.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 첫번째 데이터 삭제
		String msg = ShareData.list.remove(0);
		System.out.println("Data" + msg + "소비");
	}

	public void run() {
		try {
			for(int i = 0; i < 10; i = i + 1) {
				Thread.sleep(1000);
				get();
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

}
