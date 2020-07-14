package chapter6.company;

public class Employee {
	//사원번호, 이름, 부서를 저장할 멤버 변수를 선언
	//protected은 상속받은 클래스에서 사용할 수 있고 객체가 사용하지는 못한다.
	protected int empNo;
	protected String name;
	protected String part;
	
	//일련번호 생성을 위한 static 변수 선언
	protected static int autoIncrement;
	
	public Employee() {
		super();
		empNo = ++autoIncrement;
	}
	public Employee(String name, String part) {
		super();
		this.name = name;
		this.part = part;
	}
	//접근자 메소드
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	//멤버 변수의 값들을 문자열로 만들어서 리턴해주는 메소드
	public String resultStr() {
		String str = " ";
		str += "사번 : " + empNo + "\n";
		str += "이름 : " + name + "\n";
		str += "부서 : " + part + "\n";
		str += "============================\n";
		return str;
	}
}
