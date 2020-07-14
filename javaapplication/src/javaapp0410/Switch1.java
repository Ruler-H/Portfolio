package javaapp0410;

public class Switch1 {

	public static void main(String[] args) {
		final String SEOUL = "서울";
		final String GOYANG = "고양";
		final String PAJU = "파주";
		final String YANGJU = "양주";
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("거주지 입력(서울, 고양, 파주, 양주) : ");
		String city = sc.nextLine();
		switch(city){
			case SEOUL : System.out.println("서울");
			break;
			case GOYANG : System.out.println("고양");
			break;
			case PAJU : System.out.println("파주");
			break;
			case YANGJU : System.out.println("양주");
			break;
			default : System.out.println("잘못된 지역");
			break;
		}
		sc.close();

	}
}
