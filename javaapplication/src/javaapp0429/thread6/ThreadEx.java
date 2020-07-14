package javaapp0429.thread6;

import java.util.concurrent.Semaphore;

public class ThreadEx extends Thread {
	static Semaphore semaphore = new Semaphore(3);
	public void run() {
		try {
			semaphore.acquire();
			for(int i = 0; i < 3; i = i + 1) {
				Thread.sleep(1000);
				System.out.println(this.getName());
			}
			semaphore.release();
		}catch(Exception e) {
			
		}
	}

}
