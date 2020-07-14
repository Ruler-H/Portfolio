package chapter6.student;
	public class ReturnClassMain{
		public static void main(String [] args) {
			ReturnClass obj = new ReturnClass();
			obj.noReturnAdd(100, 200);
			
			int result = obj.returnAdd(100, 200);
			result = obj.returnAdd(result, 300);
			System.out.println("결과 : " + result);
	}

}
