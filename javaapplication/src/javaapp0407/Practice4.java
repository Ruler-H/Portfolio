package javaapp0407;

public class Practice4 {

	public static void main(String[] args) {
		int money = 9400;
		int resulta = money/5000;
		int resultb = (money - (resulta * 5000))/1000;
		int resultc = (money - (resulta * 5000) - (resultb * 1000))/100;
		System.out.println("5000원 : " + resulta + "장");
		System.out.println("1000원 : " + resultb + "장");
		System.out.println("100원 : " + resultc + "개");

	}

}
