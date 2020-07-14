package javaapp0410;

public class while5 {

	public static void main(String[] args) {
		int idx = 0;
		while(idx < 12) {
			System.out.println("image" + (3 - (idx % 3)) + ".png");
			idx = idx + 1;
		}
	}

}
