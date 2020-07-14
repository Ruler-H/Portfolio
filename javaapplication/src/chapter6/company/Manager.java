package chapter6.company;
//Employee 클래스로 부터 상속받는 클래스
public class Manager extends Employee {
	private String position;
	
	public Manager() {
		empNo = ++autoIncrement;
	}
	public Manager(String name, String part, String position) {
		this.name = name;
		this.part = part;
		this.position = position;
	}
	//position 접근자 메소드
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	//position을 문자열로 만들어서 리턴해주는 메소드
	public String addStr() {
		return "직책 : " + position + "\n";
	}


}
