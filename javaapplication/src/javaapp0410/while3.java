package javaapp0410;

public class while3 {

	public static void main(String[] args) {
		int idx = 0;
		while(idx < 9) {
			System.out.println("image" + ((idx % 3) + 1) + ".png");
			idx = idx + 1;
		}

	}

}
