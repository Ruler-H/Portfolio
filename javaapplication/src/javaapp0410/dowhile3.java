package javaapp0410;

public class dowhile3 {

	public static void main(String[] args) {
		int [] ar = {700, 600, 500, 430};
		int sum = 0;
		int idx = 0;
		do {
			sum = sum + ar[idx];
			idx = idx + 1;
		}while(idx < 4);
		System.out.println("합계 : " + sum);
		double avg = (double)sum / idx;
		System.out.println("평균 : " + avg);
		int avg2 = (int)((avg / 100) + 0.5) * 100;
		System.out.println("평균(10의 자리 반올림) : " + avg2);

	}

}
