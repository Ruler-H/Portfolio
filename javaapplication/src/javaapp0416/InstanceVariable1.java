package javaapp0416;

public class InstanceVariable1 {

	public static void main(String[] args) {
		//Student1 클래스의 인스턴스를 생성
		Student obj1 = new Student();
		//인스턴스를 이용해서 프로퍼티 접근
		obj1.num = 1;
		obj1.name = "황병헌";
		//매개변수가 정수 3개인 메소드 호출
		obj1.set(98, 88, 99);
		int scoresum1 = obj1.sum();
		double avg = scoresum1 / 3.0;
		System.out.println("합계 : " + scoresum1 + "\t평균 : " + avg);
	
		//static 변수를 인스턴스를 이용해서 접근하면 경고, 되도록이면 클래스이름으로 접근
		
		//다른 인스턴스 생성
		Student obj2 = new Student();
		obj2.num = 2;
		obj2.name = "최황연";
		
		//클래스 안에 static 없이 만들어진 변수는 인스턴스마다 별도로 생성 - 프로퍼티라고 한다.
		System.out.println(Student.schoolName + " : " + obj1.num);
		System.out.println(obj1.name);
		System.out.println(obj1.kor);
		System.out.println(obj1.mat);
		System.out.println(obj1.eng);
		
		obj1.disp();
		System.out.println(Student.schoolName + " : " + obj2.name);

	}

}
