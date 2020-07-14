package javaapp0526;

public class Practice {

	public static void main(String[] args) {
		int[][] ar = new int[5][5];
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ar[i][j] = cnt;
				cnt = cnt + 1;
			}
		}

		for (int i = 0; i < 25; i++) {
			System.out.println(ar[i/5][i%5] + "\t");
		}

		int[] k = new int[25];
		cnt = 101;
		for (int i = 0; i < 25; i++) {
			k[i] = cnt;
			cnt = cnt + 1;
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				ar[i][j] = k[i * 5 + j];
			}
		}

		for (int i = 0; i < 25; i++) {
			System.out.println(ar[i/5][i%5] + "\t");
		}

	}

}
