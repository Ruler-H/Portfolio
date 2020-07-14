package chapter7.overriding;

public class Manager extends Employee{
	private String position;	//직책
	
	public Manager() {
		
	}

	//매개변수 4개를 갖는 생성자
	public Manager(String empNo, String name, String part, String position) {
		super(empNo, name, part);
		this.position = position;
	}
	
	//관리자에서 추가되는 정보를 결과 문자열로 결합
	public String resultStr() {
		String result = super.resultStr();
		result += "직책 : " + position + "\n";
		return result;
	}
	

}
