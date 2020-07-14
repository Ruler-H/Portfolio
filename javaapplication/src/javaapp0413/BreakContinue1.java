package javaapp0413;

public class BreakContinue1 {

	public static void main(String[] args) {
		for(int i = 1; i < 11; i = i + 1) {
			if(i % 3 == 0) {
				continue;
			}
			System.out.println(i);
		}

	}

}
