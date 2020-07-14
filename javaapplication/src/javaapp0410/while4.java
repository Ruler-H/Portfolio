package javaapp0410;

public class while4 {

	public static void main(String[] args) {
		int idx = 0;
		while(idx < 12) {
			System.out.println("image" + (((idx % 3)* 2) + 1) + ".png");
			idx = idx + 1;
		}

	}

}
