package javaapp0413;

public class For1 {

	public static void main(String[] args) {
		for (int idx = 0;; idx = idx + 1) {
			if (idx % 2 == 0) {
				System.out.println("왼쪽");
				System.out.println("왼쪽");
				System.out.println("왼쪽");
			} else {
				System.out.println("오른쪽");
				System.out.println("오른쪽");
				System.out.println("오른쪽");
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}

	}

}
