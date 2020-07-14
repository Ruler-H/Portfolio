package javaapp0421.datashare;

public class Main {

	public static void main(String[] args) {
		//클래스의 인스턴스 2개 생성
		Tjoeun obj1 = new Tjoeun();
		Tjoeun obj2 = new Tjoeun();
		
		//noShare는 인스턴스 프로퍼티이므로 변경해도 다른 인스턴스에는 아무런 영향이 없다.
		obj1.noShare = "공유하지 않음 obj2";
		
		System.out.println(obj2.noShare);
		
		obj1.msg = "공유합니다. obj2";
		
		System.out.println(obj2.msg);
		
		obj1.globalChange();
		
		System.out.println(GlobalClass.globalMsg);
		
		Singleton s1 = Singleton.sharedInstance();
		Singleton s2 = Singleton.sharedInstance();
		
		//2개의 인스턴스가 동일한지 확인은 해시코드를 이용
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		Singleton.sharedInstance().sharedVariable = "Singleton";
		
		Parent p = new Parent();
		int a = Math.max(5, 10);
		System.out.println(a);

	}

}
