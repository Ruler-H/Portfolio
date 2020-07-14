package javaapp0407;

public class Practice2 {

	public static void main(String[] args) {
		double d = 0.7784;
		double resultd = (double)((int)((d * 10) + 0.5))/10;
		System.out.println(resultd);
		
		double a = 0.7784;  //이 때 소수점 두째자리에서 반올림시키기
		double resulta = ((int)((a * 10) + 0.5))/10.0;
		System.out.println("result : " + resulta);
	}

}
