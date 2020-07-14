package javaapp0410;

public class while2 {

	public static void main(String[] args) {
		int idx = 0;
		while(idx < 8) {
			System.out.println("image" + ((idx % 4) + 1) + ".png");
			idx = idx + 1;
		}
	}

}
