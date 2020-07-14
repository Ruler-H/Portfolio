package javaapp0417;

public class TaskClass {

	//재귀를 이용하지 않고 n번째 피보나치 수열의 값을 리턴해주는 메소드
	public static int noRecuresionFibo(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}else {
			//현재 계산 값의 2번째 전의 항의 데이터를 저장할 변수
			int f1 = 1;
			//현재 계산 값의 1번째 전의 항의 데이터를 저장할 변수
			int f2 = 1;
			//현재 위치의 피보나치 수열의 값
			int fibo = -1;
			for(int i = 3; i<=n; i=i+1) {
				fibo = f1 + f2;
				f2 = f1;
				f1 = fibo;
			}
			return fibo;
		}		
	}
	public int recursiveFibo(int n){
		if(n == 1|| n == 2){
				return 1;
		}else{
				return recursiveFibo(n-1) + recursiveFibo(n-2);
		}
}
}
