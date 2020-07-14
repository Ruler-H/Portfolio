package javaapp0519;

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
		int americanocost = -1;
		String refill = null;
		
		
		//mainloop라고 이름을 붙인 이유는 내부에서 switch문을 사용할 것이고 7번을 누를 때 반복문을 한번에 빠져나오기 위해서이다.
		mainloop : while(true) {
			System.out.println(
					"1.전체보기 2.2개씩 보기 3.상세보기 4.카페이름, 지역으로 검색\n 5.데이터삽입 6.데이터수정 7.데이터삭제 8.프로그램 종료");
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
			case "2" :	//System.out.println("2개씩 보기");
				int cnt = dao.getCount();	//System.out.println("데이터 개수 : " + cnt);
				//페이지 수 만들기 - 페이지당 데이터 개수는 2
				int pagesu = (int)((double)cnt/2 + (double)(2-1)/2);	//System.out.println("페이지 개수 : " + pagesu);
				list = dao.pageCafe(1, 2);
				for(Cafe imsi : list) {
					System.out.println(imsi);
				}
				int pageno = 1;
				while(true) {
					//아무키나 누르고 Enter치면 종료
					//그냥 Enter치면 다음 페이지의 데이터도 가져와서 출력하기
					System.out.println("아무키나 누르면 종료");
					System.out.print("Enter만 누르면 다음페이지 데이터 가져오기");
					String temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						pageno = pageno + 1;
						if(pageno > pagesu) {
							System.out.println("더이상 가져올 데이터 없음");
						}else {
							//pageno에 해당하는 데이터 가져오기
							List<Cafe>currentData = dao.pageCafe(pageno, 2);
							//위의 데이터를 list에 추가
							list.addAll(currentData);
							//출력
							for(Cafe imsi : list) {
								System.out.println(imsi);
							}
						}
					}else {
						break;
					}
				}
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
						System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\n",
								"번호", "카페이름", "카페위치", "테이블수", "콘센트수", "아메리카노 가격", "리필 가능 여부");
						System.out.printf("%10s\t%10s\t%10s\t%10s\t%10s\t%10s\t%10s\n",
								cafe.getNum(), cafe.getName(), cafe.getRegion(), cafe.getTablenum(),
								cafe.getPlugnum(), cafe.getAmericanocost(), cafe.getRefill());
					}
				}catch(Exception e) {
					System.err.println("정수를 입력하세요!!!");
					break;
				}
				System.out.println("상세보기");
				break;
			case "4" :    //System.out.println("지역으로 검색");
				System.out.print("조회할 카페이름이나 지역 : ");
				temp = sc.nextLine();
				list = dao.searchCafe(temp);
				if(list.size() == 0) {
					System.out.println("조회된 데이터가 없습니다.");
				}else {
					for(Cafe imsi : list) {
						System.out.printf("%5d\t%10s\t%10s\t%10d\n", 
								imsi.getNum(), imsi.getName(), imsi.getRegion(), imsi.getTablenum());
					}
				}
				break;
			case "5" :
				//num을 입력
				/*System.out.print("삽입할 번호를 입력 : ");
				temp = sc.nextLine();
				num = Integer.parseInt(temp);
				
				//num이 존재하는지 조회
				cafe = dao.search(num);*/
				if(cafe == null){
					//num이 존재하지 않는 경우
					//카페이름과 위치, 카페 테이블수, 콘센트수, 아메리카노 가격, 리필 가능 여부를 입력받기
					System.out.print("카페이름 : ");
					name = sc.nextLine();
					System.out.print("카페위치 : ");
					region = sc.nextLine();
					System.out.print("카페 테이블 수 : ");
					temp = sc.nextLine();
					tablenum = Integer.parseInt(temp);
					System.out.print("카페 콘센트 수 : ");
					temp = sc.nextLine();
					plugnum = Integer.parseInt(temp);
					System.out.print("아메리카노 가격 : ");
					temp = sc.nextLine();
					americanocost = Integer.parseInt(temp);
					System.out.print("리필 가능 여부(1.T 2.F) : ");
					refill = sc.nextLine();
					
					//데이터베이스 메소드에 넘겨주기 위해 입력받는 데이터를 1개로 만들기
					cafe = new Cafe();
					cafe.setNum(num);
					cafe.setName(name);
					cafe.setRegion(region);
					cafe.setTablenum(tablenum);
					cafe.setPlugnum(plugnum);
					cafe.setAmericanocost(americanocost);
					cafe.setRefill(refill);
					
					//데이터베이스 메소드 호출
					result = dao.insertCafe(cafe);
					//결과 사용
					if(result > 0) {
						System.out.println("데이터 삽입 성공");
					}else {
						System.out.println("데이터 삽입 실패");
					}
					
				}/*else {
					//num이 존재하는 경우
					System.out.println("이미 존재하는 번호입니다.");
				}*/
				break;
			case "6" :		//System.out.println("데이터수정");
				System.out.print("수정할 번호 : ");
				temp = sc.nextLine();
				num = Integer.parseInt(temp);
				cafe = dao.search(num);
				if(cafe == null) {
					System.out.println("없는 번호입니다.");
				}else {
					System.out.print("수정하지 않으려면 Enter");
					System.out.print("카페이름(이전 - " + cafe.getName() + ")" + " : ");
					name = sc.nextLine();
					if(name.trim().length() == 0) {
						name = cafe.getName();
					}
					System.out.print("수정하지 않으려면 Enter");
					System.out.print("카페위치(이전 - " + cafe.getRegion() + ")" + " : ");
					region = sc.nextLine();
					if(region.trim().length() == 0) {
						region = cafe.getRegion();
					}
					System.out.print("수정하지 않으려면 Enter");
					System.out.print("카페 테이블 수(이전 - " + cafe.getTablenum() + ")" + " : ");
					temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						tablenum = cafe.getTablenum();
					}else {
						tablenum = Integer.parseInt(temp);						
					}
					System.out.print("수정하지 않으려면 Enter");
					System.out.print("카페 콘센트 수(이전 - " + cafe.getPlugnum() + ")" + " : ");
					temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						plugnum = cafe.getPlugnum();
					}else {
						plugnum = Integer.parseInt(temp);
					}
					System.out.print("수정하지 않으려면 Enter");
					System.out.print("아메리카노 가격(이전 - " + cafe.getAmericanocost() + ")" + " : ");
					temp = sc.nextLine();
					if(temp.trim().length() == 0) {
						americanocost = cafe.getAmericanocost();
					}else {
						americanocost = Integer.parseInt(temp);
					}
					System.out.print("수정하지 않으려면 Enter");
					System.out.print("리필 가능 여부(1.T 2.F)(이전 - " + cafe.getRefill() + ")" + " : ");
					refill = sc.nextLine();
					if(refill.trim().length() == 0) {
						refill = cafe.getRefill();
					}					
					cafe.setName(name);
					cafe.setName(name);
					cafe.setRegion(region);
					cafe.setTablenum(tablenum);
					cafe.setPlugnum(plugnum);
					cafe.setAmericanocost(americanocost);
					cafe.setRefill(refill);				
					result = dao.updateCafe(cafe);
					//결과 사용
					if(result > 0) {
						System.out.println("데이터 수정 성공");
					}else {
						System.out.println("데이터 수정 실패");
					}					
				}
				break;
			case "7" :
				//System.out.println("데이터삭제");
				System.out.print("삭제할 번호 : ");
				temp = sc.nextLine();
				num = Integer.parseInt(temp);
				//데이터 존재 여부를 확인
				cafe = dao.search(num);
				if(cafe == null) {
					System.out.println("삭제할 수 없는 번호입니다.");
				}else {
					//정말로 삭제할 것인지 확인
					System.out.print("정말로 삭제(Y) : ");
					temp = sc.nextLine();
					//영문을 입력받아서 비교할 때
					if(temp.trim().toUpperCase().equals("Y")) {
						result = dao.deleteCafe(num);
						//삭제 결과 사용
						if(result > 0) {
							System.out.println("데이터 삭제 성공");
						}else {
							System.out.println("데이터 삭제 실패");
						}
					}
				}
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
