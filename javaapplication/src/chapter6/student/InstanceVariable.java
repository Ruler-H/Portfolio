package chapter6.student;

public class InstanceVariable {

	public static void main(String[] args) {
		Student1 obj1 = new Student1();
		// 인스턴스 변수는 초기화 하지 않으면 자동으로 0의 값을 가지며
		// 반드시 객체 이름으로 호출해야 한다.
		obj1.name = "아이린";
		obj1.eng = 40;
		obj1.mat = 50;
		System.out.println("name : " + obj1.name);
		System.out.println("kor : " + obj1.kor);
		System.out.println("mat : " + obj1.mat);
		System.out.println("eng : " + obj1.eng);
		
		Student1 obj2 = new Student1();
		//인스턴스 변수는 각 인스턴스 마다 별개로 소유
		obj2.name = "배수지";
		
		System.out.println("obj1.name : " + obj1.name);
		System.out.println("obj2.name : " + obj2.name);

		
	}

}
