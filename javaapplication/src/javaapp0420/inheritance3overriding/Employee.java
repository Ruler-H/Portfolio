package javaapp0420.inheritance3overriding;

public class Employee {
	//프로퍼티(필드, 변수)
	//사원번호, 이름, 부서를 저장
	private int empNo;
	private String empName;
	private String empPart;
	
	//empNo를 일련번호로 만들기 위한 static 변수 - 공유
	private static int auto_increment;
	
	//생성자
	//매개변수가 없는 생성자 - default constructor
	public Employee() {
		super();
		auto_increment = auto_increment + 1;
		empNo = auto_increment;
	}


	//매개변수가 있는 생성자
	//매개변수를 받아서 프로퍼티를 초기화할 목적으로 생성
	public Employee(String empName, String empPart) {
		super();
		auto_increment = auto_increment + 1;
		empNo = auto_increment;
		this.empName = empName;
		this.empPart = empPart;
	}

	//접근자 메소드
	//프로퍼티를 private으로 만들어서 외부에서 만든 인스턴스가 프로퍼티에 접근할 수가 없어서 getter와 setter를 이용해서 접근
	//getter : 프로퍼티의 값을 리턴하는 메소드
	//setter : 프로퍼티의 값을 설정하는 메소드
	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpPart() {
		return empPart;
	}


	public void setEmpPart(String empPart) {
		this.empPart = empPart;
	}


	public int getEmpNo() {
		return empNo;
	}
	
	//프로퍼티를 합쳐서 하나의 문자열로 만든 후 리턴해주는 메소드 - 디버깅을 위한 메소드
	//데이터가 제대로 설정되었는지 확인할 때 하나 하나의 값을 확인하는 것은 자원의 낭비이기 때문에 한꺼번에 확인하기 위한 메소드
	//나중에는 toString()으로 생성
	public String resultStr() {
		String result = "사원번호 : " + empNo + " 이름 : " + empName + " 부서 : " + empPart;
		return result;
	}
	
	
	
	
}
