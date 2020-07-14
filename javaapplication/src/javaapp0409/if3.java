package javaapp0409;

public class if3 {

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		if(id.equals("ghkd") && password.equals("qudgjs")) {
			System.out.print("관리자님, 환영합니다.");
		}else {
			System.out.print("없는 아이디이거나 잘못된 비밀번호 입니다.");
		}
		
		sc.close();

	}

}
