package javaapp0513.datebase;


import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class CafeMain {

	// static 초기화
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 클래스 로드 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// 키보드로 부터 입력받기 위한 인스턴스 생성
		Scanner sc = new Scanner(System.in);
		
		//CafeDAO 인스턴스 생성
		CafeDAO dao = CafeDAO.sharedInstance();
		mainloop: while (true) {
			System.out.print("메뉴 입력(1. 전체 데이터 보기 2. 코드로 데이터 조회하기 3. 데이터 삽입 4. 데이터 수정 5. 데이터 삭제 6. 데이터 검색 7. 종료) : ");
			String menu = sc.nextLine();
			
			//switch 구문 내에서 사용할 변수
			List<Cafe> list = null;
			Cafe cafe = null;
			int result = -1;
			int num = 0;
			switch (menu) {
			case "1":
				//전체 데이터 가져오는 메소드 호출
				List<Map<String, Object>> maplist = dao.allCafe();
				//list를 순회하면서 출력하기
				for(Map g : maplist) {
					Set<String> keyset = g.keySet();
					for(String key : keyset) {
						System.out.print(g.get(key) + "\t");
					}
					System.out.println();
				}
				break;
			case "2":
				//코드 1개 입력받기
				System.out.print("조회할 코드 입력 : ");
				num = sc.nextInt();
				sc.nextLine();
				
				//DAO 메소드 호출
				cafe = dao.getCafe(num);
				if(cafe == null) {
					System.out.println("코드에 해당하는 데이터 없음");
				}else {
					System.out.println(cafe);
				}
				break;
			case "3":
				//삽입할 코드를 입력
				System.out.print("삽입할 코드를 입력 : ");
				num = sc.nextInt();
				sc.nextLine();
				//코드에 해당하는 데이터를 가져오기
				cafe = dao.getCafe(num);
				if(cafe == null) {
					//코드에 해당하는 데이터가 없으면
					System.out.print("카페 이름 입력 : ");
					String name = sc.nextLine();
					System.out.print("카페 지역 입력 : ");
					String region = sc.nextLine();
					System.out.print("테이블 개수 입력 : ");
					int tablenum = sc.nextInt();
					sc.nextLine();
					System.out.print("와이파이 보유 여부 입력(보유-T, 미보유-F) : ");
					String wifi = sc.nextLine();
					Date opendate = new Date(System.currentTimeMillis());
					
					cafe = new Cafe();
					cafe.setNum(num);
					cafe.setName(name);
					cafe.setRegion(region);
					cafe.setTablenum(tablenum);
					cafe.setWifi(wifi);
					cafe.setOpendate(opendate);
					
					//sql 실행
					result = dao.insertCafe(cafe);
					
					if(result > 0) {
						System.out.println("데이터 삽입 성공");
					}else {
						System.out.println("데이터 삽입 실패");
					}
				}else {
					//코드에 해당하는 데이터가 있으면
					System.out.println("이미 존재하는 코드입니다.");
				}
				break;
			case "4":
				while(true) {
					System.out.print("수정할 데이터의 코드를 입력 : ");
					num = sc.nextInt();
					sc.nextLine();
					cafe = dao.getCafe(num);
					//데이터가 존재하는 경우
					if(cafe != null) {
						System.out.print("수정할 이름 : ");
						String name = sc.nextLine();
						cafe.setName(name);
						System.out.print("수정할 지역명 : ");
						String region = sc.nextLine();
						cafe.setRegion(region);
						System.out.print("수정할 테이블 수 : ");
						int tablenum = sc.nextInt();
						sc.nextLine();
						cafe.setTablenum(tablenum);
						System.out.print("와이파이 여부 수정 : ");
						String wifi = sc.nextLine();
						cafe.setWifi(wifi);
						
						result = dao.updateCafe(cafe);
						if(result > 0) {
							System.out.println("데이터 수정 성공");
						}else if(result == 0) {
							System.out.println("조건에 맞는 데이터 없음");
						}else {
							System.err.println("데이터 수정 실패");
						}
						break;
					}else {
						System.out.println("수정할 수 없는 코드입니다.");
					}
				}
				break;
			case "5":
				System.out.print("삭제할 코드를 입력 : ");
				num = sc.nextInt();
				sc.nextLine();
				cafe = dao.getCafe(num);
				if(cafe == null) {
					System.out.println("없는 코드 입니다.");
				}else {
					//대화 상자를 출력해서 묻기
					int r = JOptionPane.showConfirmDialog(null, "정말로 삭제", "삭제", JOptionPane.YES_NO_OPTION);
					if(r == JOptionPane.YES_OPTION) {
						//데이터 삭제
						result = dao.deleteCafe(num);
						if(result > 0) {
							JOptionPane.showConfirmDialog(null, "삭제 성공");
						}
					}
				}
				break;
			case "6":
				System.out.print("카페 이름이나 위치 입력 : ");
				String word = sc.nextLine();
				
				//데이터베이스 처리 메소드 호출
				List<Cafe> ar = dao.search(word);
				
				for(Cafe g : ar) {
					System.out.println(g);
				}
				break;
			case "7":
				System.out.println("프로그램 종료");
				// mainloop라는 반복문을 종료
				break mainloop;
			default:
				System.out.println("잘못된 메뉴를 입력하셨습니다.");
				break;
			}
		}

		// 사용이 끝나면 키보드 연결 해제
		sc.close();

	}

}
