package javaapp0421.datashare;

public class Tjoeun {
	//static이 없는 프로퍼티라서 인스턴스가 각자 소유
	public String noShare;
	
	//static이 있어서 클래스에 만들고 인스턴스가 공유
	public static String msg;
	
	public void globalChange() {
		GlobalClass.globalMsg = "전역 변수 수정";
	}

}
