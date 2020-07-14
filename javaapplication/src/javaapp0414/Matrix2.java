package javaapp0414;

public class Matrix2 {

	public static void main(String[] args) {
		int [] ar = new int[20];
		for(int i=0; i<20; i=i+1) {
			ar[i] = i+1;
			System.out.printf("%3d\t", ar[i]);
			if(i%5==4) {
				System.out.printf("\n");
			}
		}

	}

}
