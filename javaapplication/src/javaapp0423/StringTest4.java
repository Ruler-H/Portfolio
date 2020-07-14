package javaapp0423;

public class StringTest4 {

	public static void main(String[] args) {
		String data = "1000, -, 4300, 3700";
		String[] ar = data.split(",");
		for (String temp : ar) {
			System.out.println(temp);
		}
		int sum = 0;
		for (String temp : ar) {
			try {
				sum = sum + Integer.parseInt(temp);
			} catch (Exception e) {
			}
		}
		System.out.println("합계 : " + sum);

		// 날짜와 매출을 연속적으로 기록한 것
		String coupang = "0420, 10000, 0421, 20000, 0422, -, 0423, 14000";
		// 데이터를 가지고 매출의 평균을 구하시오.
		// -는 매출이 없는 것이 아니라 영업을 하지 않은 경우이므로 제외하고 매출의 평균을 구하시오.

		// 1. , 단위로 분할해서 출력
		String[] br = coupang.split(",");
		// 2. 짝수번째 데이터만 출력
		// 3. 짝수번째 데이터의 평균을 구하기
		int sumcr = 0;
		int count = 0;
		int su = br.length;
		int [] cr = new int [br.length];
		for (int i = 0; i < su; i = i + 1) {
			cr[i] = Integer.parseInt(br[i]);
			if (i % 2 == 1) {
			System.out.println(br[i]);
			}
			try {
				if (i % 2 == 1 && cr[i] > 0) {
					sumcr = sumcr + cr[i];
					count = count + 1;
				}
			}catch(Exception e) {}
		} 
		System.out.println("매출의 평균은 " + sumcr / count);
	}

}
