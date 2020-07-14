package javaapp0417;

public class TaskMain {

	public static void main(String[] args) {

		//TaskClass 클래스에 존재하는
		//public static int noRecuresionFibo(int n) 사용
		int result = TaskClass.noRecuresionFibo(9);
		System.out.println("9번째 숫자 : " + result);
		result = TaskClass.noRecuresionFibo(10);
		System.out.println("10번째 숫자 : " + result);
		result = TaskClass.noRecuresionFibo(11);
		System.out.println("11번째 숫자 : " + result);
		result = TaskClass.noRecuresionFibo(12);
		System.out.println("12번째 숫자 : " + result);
		result = TaskClass.noRecuresionFibo(13);
		System.out.println("13번째 숫자 : " + result);
		result = TaskClass.noRecuresionFibo(14);
		System.out.println("14번째 숫자 : " + result);
		TaskClass obj = new TaskClass();
		result = obj.recursiveFibo(9);
		System.out.println("9번째 숫자 : " + result);
		result = obj.recursiveFibo(10);
		System.out.println("10번째 숫자 : " + result);
		result = obj.recursiveFibo(100);
		System.out.println("100번째 숫자 : " + result);
		

	}

}
