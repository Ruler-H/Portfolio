package javaapp0429.thread2;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		try {
			//상하좌우를 번갈아가면서 3번씩 출력하기, 0.2초마다 쉬면서 수행
			String [] action = {"상", "하", "좌", "우"};
			for(int i = 0; i < 12; i = i + 1) {
				Thread.sleep(200);
				System.out.println("챔피언 : " + action[i%action.length]);
			}
		}catch(Exception e) {
			//자신만의 메시지를 출력하고 기록
			System.out.println("문제 발생");
			//예외 내용을 출력
			System.out.println(e.getMessage());
			//예외 발생 지점을 찾기
			e.printStackTrace();
		}

	}

}
