package javaapp0428;

public class Wanjeonsu {

	public static void main(String[] args) {
		int sum = 0;
		int cnt = 0;
		for(int i = 2; i <= 1000; i = i + 1) {
			for(int j = 1; j <= i/2; j = j + 1) {
				if(i % j == 0) {
					sum = sum + j;
				}
			}
			if(sum == i) {
				cnt = cnt + 1;
				System.out.println(i);
			}
			sum = 0;
		}
		System.out.println(cnt);

	}

}
