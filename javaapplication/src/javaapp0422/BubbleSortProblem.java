package javaapp0422;

public class BubbleSortProblem {

	public static void main(String[] args) {
		int[] ar = { 30, 40, 10, 50, 20 };
		int temp;
		int i;
		for (i = 0; i < ar.length; i = i + 1) {
			System.out.print(ar[i] + " ");
		}
		System.out.println(" ");
		for (i = 0; i < ar.length - 1; i = i + 1) {
			int su = 0;
			for (int j = 0; j < ar.length - i - 1; j = j + 1) {
				if (ar[j] > ar[j + 1]) {
					temp = ar[j];
					ar[j] = ar[j + 1];
					ar[j + 1] = temp;
					su = 1;
				}
			
			}
			if(su == 0) {
				break;
			}
			
			for (int k = 0; k < ar.length; k = k + 1) {
				System.out.print(ar[k] + " ");
			}
			System.out.println(" ");
		}
	}

}
