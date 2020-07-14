package javaapp0410;

public class dowhile1 {

	public static void main(String[] args) {
		int idx = 1;
		int sum = 0;
		do {
			sum = sum + idx;
			idx = idx + 1;
		}while(idx < 11);
		System.out.println("합계 : " + sum);
	}

}
