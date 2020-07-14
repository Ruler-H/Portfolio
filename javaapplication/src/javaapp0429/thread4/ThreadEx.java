package javaapp0429.thread4;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadEx implements Runnable {
	public int result = 0;
	public int idx = 0;
	
	//idx를 10000번 증가시키면서 result에 더하는 메소드
	static ReentrantLock lock = new ReentrantLock();
	public void sum() {
		for(int i = 0; i < 10000; i = i + 1) {
			lock.lock();
			//synchronized(this) {
			idx = idx + 1;
			try {
			Thread.sleep(1);
			}catch(InterruptedException e) {}
			result = result + idx;
			//}
			lock.unlock();
		}
	}

	@Override
	public void run() {
		sum();
		
	}
	

}
