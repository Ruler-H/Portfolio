package javaapp0422;

public class Naerim {

	public static void main(String[] args) {
		int [] ar = {17, 20, 30, 15, 29};
		for(int i = 0; i < ar.length-1; i = i + 1) {
			for(int j = i + 1; j < 5; j = j + 1) {
				if(ar[i] < ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
			System.out.print(ar[0]);
			System.out.print(ar[1]);
			System.out.print(ar[2]);
			System.out.print(ar[3]);
			System.out.print(ar[4]);
			System.out.println(" ");
		}

	}

}
