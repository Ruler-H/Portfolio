package chapter7.company2;

public class Manager extends Employee{
	private String position;	//직책
	
	public Manager() {
		super("A0000","noname","대기발령");
	}
	
	//매개변수 4개를 갖는 생성자
	public Manager(String empNo, String name, String part, String position) {
		super(empNo, name, part);
		this.position = position;
	}
	
	public String addStr() {
		String result = super.resultStr();
		result += "직책 : " + position + "\n";
		return result;
	}

}
