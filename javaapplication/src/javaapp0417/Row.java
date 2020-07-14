package javaapp0417;

public class Row {
	//회원가입을 위한 프로퍼티
	private int num;
	private String id;
	private String pw;
	private String name;
	private int birth;
	private String gender;
	private String phone;
	
	//static변수를 1씩 증가시키면서 프로퍼티에 대입하면 일련번호가 된다.
	private static int idx = 1;
	
	public Row() {
		super();
		num = idx;
		idx = idx +1;
		//idx는 계속해서 하나씩 증가
	}
	
	//생성자 - 매개변수가 없는 생성자와 매개변수가 있는 생성자
	int sequence = 1;
	public Row(int num, String id, String pw, String name, int birth, String gender, String phone) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		num = sequence;
		sequence = sequence + 1;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}

