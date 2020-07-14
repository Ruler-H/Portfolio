package javaapp0518;

import java.util.List;
import java.util.Scanner;

public class CafeMain {

	public static void main(String[] args) {
		//데이터베이스 사용 객체를 생성
		CafeDAO dao = CafeDAO.sharedInstance();
		//키보드 입력 객체를 생성
		Scanner sc = new Scanner(System.in);
		
		//여러 개의 데이터를 저장하기 위한 변수
		List<Cafe> list = null;
		//하나의 데이터를 저장하기 위한 변수
		Cafe cafe = null;
		//삽입, 삭제, 갱신의 결과를 저장하기 위한 변수
		int result = -1;
		
		//Cafe 각각을 위한 변수
		int num = -1;
		String name = null;
		String region = null;
		int tablenum = -1;
		int plugnum = -1;
		String refill = null;
		
		
		//mainloop라고 이름을 붙인 이유는 내부에서 switch문을 사용할 것이고 7번을 누를 때 반복문을 한번에 빠져나오기 위해서이다.
		mainloop : while(true) {
			System.out.println("1.전체보기 2.2개씩 보기 3.상세보기 4.지역으로 검색\n 5.데이터삽입 6.데이터수정 7.데이터삭제 8.프로그램 종료");
			System.out.print("메뉴 입력 : ");
			String menu = sc.nextLine();
			switch(menu) {
			case "1" :
				//전체 가져오기를 호출
				list = dao.allCafe();
				//데이터 출력
				System.out.printf("%5s%15s%30s\n", "번호", "카페이름", "위치");
				for(Cafe imsi : list) {
					System.out.printf("%5s%15s%30s\n", imsi.getNum(), imsi.getName(), imsi.getRegion());
				}
				break;
			case "2" :
				System.out.println("2개씩 보기");
				break;
			case "3" :
				//조회할 번호를 입력받기
				System.out.print("조회할 번호 : ");
				String temp = sc.nextLine();
				try {
					num = Integer.parseInt(temp);
					cafe = dao.search(num);
					if(cafe == null) {
						System.out.println("해당번호의 데이터가 없습니다.");
					}else {
						System.out.printf("%10s%10s%10s%10s%10s%10s%10s\n",
								"번호", "카페이름", "카페위치", "테이블수", "콘센트수", "아메리카노 가격", "리필 가능 여부");
						System.out.printf("%10s%10s%10s%10s%10s%10s%10s\n",
								cafe.getNum(), cafe.getName(), cafe.getRegion(), cafe.getTablenum(),
								cafe.getPlugnum(), cafe.getAmericanocost(), cafe.getRefill());
					}
				}catch(Exception e) {
					System.err.println("정수를 입력하세요!!!");
					break;
				}
				System.out.println("상세보기");
				break;
			case "4" :
				System.out.println("지역으로 검색");
				break;
			case "5" :
				System.out.println("데이터삽입");
				break;
			case "6" :
				System.out.println("데이터수정");
				break;
			case "7" :
				System.out.println("데이터삭제");
				break;
			case "8" :
				System.out.println("프로그램 종료");
				break mainloop;
			default :
				System.out.println("잘못된 메뉴 선택!!!");
				break;
			}
		}
		
		sc.close();
	}

}
