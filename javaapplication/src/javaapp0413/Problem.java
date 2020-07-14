package javaapp0413;

public class Problem {

	public static void main(String[] args) {
		int n = 0;
		for(int i=0; i<5; i=i+1) {
			if(i<4) {
				for(int j=0; j<9; j=j+1) {
					if(i+j==4 || j-i==4) {
						System.out.print(n);
						n=n+1;
					}else {
						System.out.print(" ");
					}
				}
				System.out.print("\n");
			}
			if(i==4) {
				for(int s=0; s<9; s=s+1) {
					System.out.print(n%10);
					n=n+1;
				}
			}
		}
	}
}
