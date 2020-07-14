package javaapp0422;

public class SelectionSort1 {

	public static void main(String[] args) {
		int [] ar = {30, 20, 40, 50, 10};
		//데이터를 전부 출력
		int size = ar.length;
		//정렬 전 출력
		System.out.printf("정렬 전 : ");
		for(int i = 0; i < size; i = i + 1) {
			System.out.printf("%5d", ar[i]);
		}
		System.out.printf("\n");
		
		//선택 정렬
		//첫번째 부터 마지막 바로 이전 데이터까지 - 기준점
		for(int i = 0; i < size - 1; i = i + 1) {
			//뒤에 있는 모든 데이터 - 비교점
			for(int j = i+1; j < size; j = j + 1) {
				//비교되는 데이터가 더 작으면
				if(ar[i] > ar[j]) {
					//데이터를 교환
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
			/*
			//중간과정 출력
			System.out.printf("%3d pass : ", i + 1);
			for(int k = 0; k < size; k = k + 1) {
				System.out.printf("%5d", ar[k]);
			}
			System.out.printf("\n");
			*/
		}
		//정렬 후 출력
		System.out.printf("정렬 후 : ");
		for(int i = 0; i < size; i = i + 1) {
			System.out.printf("%5d", ar[i]);
		}
		System.out.printf("\n");
	}

}
