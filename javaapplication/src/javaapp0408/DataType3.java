package javaapp0408;

public class DataType3 {

	public static void main(String[] args) {
		int time = 87600;
		int day = time / 86400;
		int hour = (time % 86400) / 3600;
		int minute = (time % 3600) / 60;
		int second = (time % 60);
		System.out.println(day + "일" + hour + "시" + minute + "분"
		+ second + "초");

	}

}
