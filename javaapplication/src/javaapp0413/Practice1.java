package javaapp0413;

public class Practice1 {

	public static void main(String[] args) {
		for(int i=0; i<5; i=i+1) {
			for(int j=0; j<5; j=j+1) {
				if(i+j<4) {
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}
}