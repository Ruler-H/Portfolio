package chapter7.convert;

public class Employee {

	private String empNo;	//사원번호
	private String name;	//이름
	private String part;	//부서
	
	public Employee() {
		super();
	}

	public Employee(String empNo, String name, String part) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.part = part;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
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

	//멤버 필드의 값을 결과 문자열로 결합
		public String resultStr() {
			String result = "";
			
			result += "사번 : " + empNo + "\n";
			result += "이름 : " + name + "\n";
			result += "부서 : " + part + "\n";
			
			return result;
		}
	
	

}
