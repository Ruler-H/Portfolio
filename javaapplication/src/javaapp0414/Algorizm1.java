package javaapp0414;

public class Algorizm1 {

	public static void main(String[] args) {
		int[] data = { 31, 964, 6216, 10, 5662, 6631, 29 };
		// 100이 넘는 데이터의 합계, 개수, 평균을 구하기
		// 평균은 소수 첫째 자리에서 반올림해서 정수로 저장
		int len = data.length;
		int sum = 0;
		int num = 0;
		for (int i = 0; i < len; i = i + 1) {
			if (data[i] > 10000) {
				sum = sum + data[i];
				num = num + 1;
			}
		}
		int avg = (int) ((double) sum / num + 0.5);
		if (num == 0) {
			System.out.println("조건에 맞는 데이터가 없습니다.");
		} else {
			System.out.println("합계 : " + sum);
			System.out.println("개수 : " + num);
			System.out.println("평균 : " + avg);
		}
		int max = data[0];
		int min = data[0];
		int xidx = 0;
		int nidx = 0;
		for (int i = 0; i < len; i = i + 1) {
			if (data[i] > max) {
				max = data[i];
				xidx = i;
			}
			if (min > data[i]) {
				min = data[i];
				nidx = i;
			}
		}
		System.out.println("최대값 " + max + "의 위치는" + xidx);
		System.out.println("최소값 " + min + "의 위치는" + nidx);

		int minor = 0;
		int mindistance = 1000000000;
		int distance = 0; // 아주 큰 값으로 설정
		int idx = 0;
		// 거리의 최소값을 저장하기 위한 변수
		for (int i = 0; i < len; i = i + 1) {
			distance = 5800 - data[i];
			if (distance < 0) {
				distance = -distance;
			}
			if (mindistance > distance) {
				mindistance = distance;
				minor = data[i];
				idx = i;
			}

		}
		System.out.println("5800과 가장 가까운 값 " + minor + "의 위치는 " + idx);
	}
}