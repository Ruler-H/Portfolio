package chapter6.student;

public class StaticVariable {

	public static void main(String[] args) {
		Student2 obj1 = new Student2();
		Student2 obj2 = new Student2();
		
		//static으로 선언된 변수는 클래스 이름으로 접근 가능
		System.out.println("Student의 선생님 = " + Student2.teacher);
		Student2.teacher = "안중근";
		//static으로 선언된 변수는 객체 참조 변수로도 접근이 가능
		//이클립스에서는 객체 참조 변수로 static 변수에 접근하면 경고 발생
		//객체에게도 영향을 미침
		System.out.println("obj1의 선생님 = " + obj1.teacher);
		System.out.println("obj2의 선생님 = " + obj2.teacher);
		
		//인스턴스가 변경해도 클래스나 다른 인스턴스가 공유하므로 모든 변경된 결과가 출력됨
		obj1.teacher = "남자현";
		System.out.println("이름 변경 후");
		System.out.println("Student의 선생님 = " + Student2.teacher);
		System.out.println("obj1의 선생님 = " + obj1.teacher);
		System.out.println("obj2의 선생님 = " + obj2.teacher);

	}

}
