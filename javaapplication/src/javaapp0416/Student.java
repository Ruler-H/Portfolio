package javaapp0416;

public class Student {
	//인스턴트 변수를 선언
	//public이 붙으면 클래스 안에서 사용할 수 있고
	//인스턴스를 만들어서 인스턴스를 이용해서 사용이 가능
	public int num;
	public String name;
	public int kor;
	public int mat;
	public int eng;
	
	public int sum() {
		int tot = kor + eng + mat;
		//System.out.println("합계 : " + tot);
		return tot;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public static String getSchoolname() {
		return schoolName;
	}

	//3개의 정수를 받아서 kor, eng, mat에 대입하는 메소드
	public void set(int nkor, int neng, int nmat) {
		kor = nkor;
		eng = neng;
		mat = nmat;
	}
	
	//데이터를 출력하는 메소드
	public void disp() {
		System.out.println("번호 : " + num);
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("수학 : " + mat);
		System.out.println("영어 : " + eng);
	}
	
	//학교 이름을 저장하기 위한 변수
	//static이 붙으면 하나만 만들어서 공유
	public static final String schoolName = "성사";

}
