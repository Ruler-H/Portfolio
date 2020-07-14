package javaapp0407;

public class Practice3 {

	public static void main(String[] args) {
		int money = 988;
		int resulta = ((int)((money/100.0) + 0.5))*100;
		System.out.println(resulta);
		
		int gold = 988;	//이 때 십의 자리에서 반올림 하기
		int resultb = (int)((gold / 100.0) + 0.5)*100;
		System.out.println("result : " + resultb);

	}

}
