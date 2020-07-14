package javaapp0409;

public class if5 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		if(!id.equals("root")) {
			System.out.print("아이디가 없는 아이디");
		}else if(pw.equals("system")){
			System.out.print("로그인 성공");
		}else {
			System.out.print("잘못된 비밀번호");
		}

	}

}
