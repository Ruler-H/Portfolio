package javaapp0421.datashare;

public class Parent {
	public String parentVar;
	
	//parent 클래스 안에서 Child 클래스의 인스턴스를 생성
	//이런 경우를 has a, 포함 관계라고 한다.
	public Child child;
	
	public Parent() {
		parentVar = "부모의 데이터";
		//포함하고 있는 인스턴스의 데이터를 포함된 인스턴스에서 사용하고자 할 때는
		//포함된 인스턴스를 만들 때 생성자에 데이터를 넘겨주면 된다.
		child = new Child(parentVar);
		child.childVar = "부모에서 자식을 설정";
		child.disp();
	}

}
