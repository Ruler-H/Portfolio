package javaapp0410;

public class dowhile2 {

	public static void main(String[] args) {
		int [] ar = {30, 40, 20, 17, 76, 65};
		int sum = 0;
		int n = 0;

		do {
			sum = sum + ar[n];
			n = n + 1;
		}while(n < 6);
		System.out.println("ÇÕ°è : " + sum);
		double average = (double)sum / n;
		average = ((int)((average * 10) + 0.5)) / 10.0;
		System.out.println("Æò±Õ : " + average);
	}

}
