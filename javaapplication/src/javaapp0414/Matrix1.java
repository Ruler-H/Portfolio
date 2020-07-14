package javaapp0414;

public class Matrix1 {

	public static void main(String[] args) {
		// 2행 3열 짜리 배열
		int[][] ar = { { 651, 847, 156 }, { 846, 902, 685 } };

		// 배열 요소 1개에 접근 : 배열이름[행번호][열번호]
		System.out.println(ar[0][0]);
		// 데이터 개수 파악
		System.out.println("ar : " + ar.length);
		System.out.println("ar[0] : " + ar[0].length);

		// 모든 데이터를 열 우선으로 접근
		// 행의 개수 찾기
		int numRow = ar.length;
		for (int i = 0; i < numRow; i = i + 1) {
			int numCol = ar[i].length;
			for (int k = 0; k < numCol; k = k + 1) {
				System.out.println(ar[i][k]);
			}
		}
		System.out.println("=========================");
		int numCol = ar[0].length;
		for (int k = 0; k < numCol; k = k + 1) {
			for (int i = 0; i < numRow; i = i + 1) {
				System.out.println(ar[i][k]);
			}
		}
		System.out.println("=============구구단=========");
		for(int j=1;j<=9;j=j+1) {
			for(int i=2;i<=9;i=i+1) {
				System.out.printf("%2d * %2d = %2d /", i, j, i*j);
			}
			System.out.printf("\n");
		}
		//전체 합계를 저장할 변수
		int sum = 0;
		//행의 합계를 저장할 배열
		//sumRow[0], sumRow[1]은 모두 0
		//배열을 생성하고 데이터를 대입하지 않으면 0, false, null
		int [] sumRow = new int[ar.length];
		//열의 합계를 저장할 배열
		int [] sumCol = new int[ar[0].length];
		//전체 데이터 합계는 전체 데이터를 순회하면서 데이터를 sum에 더하면 된다.
		//전체 데이터가 6개이고 2행 3열인 경우 하나의 반복문으로 전체 데이터를 접근
		//이차원 배열을 만들어야 하는 경우 일차원 배열로 만들고 아래 접근 방법을 이용해서
		//행단위 구분을 하기도 한다.
		for(int i=0; i<(ar.length*ar[0].length);i=i+1) {
			//행번호는 열의 개수로 나눈 몫
			//열번호는 열의 개수로 나눈 나머지
			sum = sum + ar[i/ar[0].length][i%ar[0].length];
		}
		System.out.println("전체 합계 : " + sum);
		System.out.println("행의 합계 출력");
		for(int i=0; i<ar.length;i=i+1) {
			for(int j=0; j<ar[0].length; j=j+1) {
				sumRow[i] = sumRow[i] + ar[i][j];
			}
			System.out.println(sumRow[i]);
		}
		System.out.println("열의 합계 출력");
		for(int j=0; j<ar[0].length;j=j+1) {
			for(int i=0; i<ar.length; i=i+1) {
				sumCol[j] = sumCol[j] + ar[i][j];
			}
			System.out.println(sumCol[j]);
		}
	}
}
