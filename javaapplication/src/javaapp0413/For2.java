package javaapp0413;

public class For2 {

	public static void main(String[] args) {
		//0,1 반복
		/*for(int idx = 1; idx < 11; idx = idx + 1) {
			int nmg = idx % 2;
			System.out.println(nmg);
			try {
				Thread.sleep(1000);
			}catch(Exception e) { }
		}
	}*/
		//0, 0, 1, 1 반복
		for(int idx = 0; idx < 10; idx = idx + 1) {
			int mok = idx / 2;
			int nmg = mok % 2;
			System.out.println(nmg);
			try {
				Thread.sleep(1000);
			}catch(Exception e) { }
		}
	}

}
