package javaapp0408;

public class DataType4 {

	public static void main(String[] args) {
		int n = 29;
		// << : 한 번 할 때 마다 2배씩 증가
		System.out.println("29<<2 : " + (n<<2));
		// 32번 이상하라고 하면 32로 나눈 나머지 만큼만 수행
		System.out.println("29<<35 : " + (n<<35));
		// >> : 한 번 할 때 마다 나누기 2를 한 효과
		System.out.println("29>>2 : " + (n>>2));

	}

}
