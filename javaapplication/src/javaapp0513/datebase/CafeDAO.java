package javaapp0513.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//데이터베이스 연동 메소드를 소유한 클래스
public class CafeDAO {
	// 싱글톤 패턴 디자인 - 객체를 1개만 생성할 수 있도록 만든 패턴
	// 외부에서 생성할 수 없도록 생성자를 private으로
	private CafeDAO() {

	}

	// 만들어진 객체의 참조를 저장하기 위한 변수
	private static CafeDAO cafeDAO = null;

	// 객체가 없으면 만들어서 리턴하고 있으면 있는 것을 리턴하도록 하는 객체 사용을 위한 메소드
	public static CafeDAO sharedInstance() {
		if (cafeDAO == null) {
			cafeDAO = new CafeDAO();
		}
		return cafeDAO;
	}

	// 메소드들에서 공통으로 사용할 변수
	private Connection con;
	private PreparedStatement pstmt;

	// 데이터베이스 연결 메소드
	private void connect() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.200:1521:xe", "user01", "user01");
		} catch (Exception e) {
			System.err.println("연결 실패");
			System.err.println(e.getMessage());
		}
	}

	// 데이터베이스 연결을 해제하는 메소드
	private void close() {
		try {
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.err.println("연결 해제 실패");
			System.err.println(e.getMessage());
		}
	}

	// 여러 개의 데이터를 가져오는 메소드
	// select는 where절을 확인해서 매개변수를 생성
	// select * from cafe;
	// List를 리턴할 때는 인스턴스를 만들고 데이터를 추가한 후 리턴
	// 여러 개의 데이터를 가져올 때는 데이터가 없는 경우 size가 0
	public List<Map<String, Object>> allCafe() {
		// 리턴할 데이터 생성
		// 여러 개일 때는 생성자를 호출해서 인스턴스를 생성
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		// 데이터베이스 연결
		connect();

		try {
			// sql 실행 객체 생성
			pstmt = con.prepareStatement("select * from cafe");
			// sql 실행
			ResultSet rs = pstmt.executeQuery();
			// 데이터가 여러 개
			while (rs.next()) {
				// 행 단위 작업 수행
				//Cafe imsi = new Cafe();
				Map<String, Object> map = new HashMap<>();
				map.put("num", rs.getInt("num"));
				map.put("name", rs.getString("name"));
				map.put("region", rs.getString("region"));
				map.put("tablenum", rs.getInt("tablenum"));
				map.put("wifi", rs.getString("wifi"));
				map.put("opendate", rs.getDate("opendate"));
				list.add(map);
			 /* imsi.setNum(rs.getInt("num")); imsi.setName(rs.getString("name"));
			 * imsi.setRegion(rs.getString("region"));
			 * imsi.setTablenum(rs.getInt("tablenum")); imsi.setWifi(rs.getString("wifi"));
			 * imsi.setOpendate(rs.getDate("opendate"));*/
			} 
		} catch (Exception e) {
			System.err.println("SQL 실행 에러");
			System.err.println(e.getMessage());
		}

		// 데이터베이스 연결 해제
		close();

		return list;

	}

	// code를 가지고 데이터를 찾아오는 메소드
	// code는 기본키
	// select * from cafe where code = ?
	public Cafe getCafe(int num) {
		Cafe cafe = null;
		// 데이터베이스 연결
		connect();

		// 데이터베이스 작업
		try {
			// SQL 실행 객체 생성
			pstmt = con.prepareStatement("select * from cafe where num = ?");
			pstmt.setInt(1, num);
			// sql 실행
			ResultSet rs = pstmt.executeQuery();
			// 데이터가 2개 이상 나올 수 없으므로 if로 처리
			if (rs.next()) {
				cafe = new Cafe();
				cafe.setNum(rs.getInt("num"));
				cafe.setName(rs.getString("name"));
				cafe.setRegion(rs.getString("region"));
				cafe.setTablenum(rs.getInt("tablenum"));
				cafe.setWifi(rs.getString("wifi"));
				cafe.setOpendate(rs.getDate("opendate"));
			}
		} catch (Exception e) {
			System.err.println("상세보기 에러");
			System.err.println(e.getMessage());
		}

		// 데이터베이스 연결 해제
		close();

		return cafe;
	}

	// 데이터를 삽입하는 메소드
	// 삽입이나 수정은 매개변수가 DTO 아니면 Map
	// -1이 리턴되면 실패 0이 리턴되면 조건에 맞는 데이터가 없음
	// 양수가 리턴되면 작업을 수행한 것임
	public int insertCafe(Cafe cafe) {
		int result = -1;

		connect();
		try {
			// 데이터를 삽입하는 SQL 만들기
			pstmt = con.prepareStatement(
					"insert into cafe(num, name, region, tablenum, wifi, opendate) values(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, cafe.getNum());
			pstmt.setString(2, cafe.getName());
			pstmt.setString(3, cafe.getRegion());
			pstmt.setInt(4, cafe.getTablenum());
			pstmt.setString(5, cafe.getWifi());
			pstmt.setDate(6, cafe.getOpendate());

			// sql 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("데이터 삽입 에러");
			System.err.println(e.getMessage());
		}
		close();
		return result;
	}

	// 데이터를 수정하는 메소드
	// 삽입하는 메소드와 동일한 모양
	public int updateCafe(Cafe cafe) {
		int result = -1;
		connect();

		try {
			pstmt = con.prepareStatement("update cafe set name = ?, region = ?, tablenum = ?, wifi = ? where num = ?");
			pstmt.setString(1, cafe.getName());
			pstmt.setString(2, cafe.getRegion());
			pstmt.setInt(3, cafe.getTablenum());
			pstmt.setString(4, cafe.getWifi());
			pstmt.setInt(5, cafe.getNum());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("데이터 수정 에러");
			System.err.println(e.getMessage());
		}

		close();
		return result;
	}

	// 데이터를 삭제하는 메소드
	// 삭제는 대부분의 경우 기본키만으로 수행
	public int deleteCafe(int num) {
		int result = -1;
		connect();

		try {
			pstmt = con.prepareStatement("delete from cafe where num = ?");
			pstmt.setInt(1, num);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.err.println("데이터 삭제 에러");
			System.err.println(e.getMessage());
		}

		close();
		return result;
	}

	// 매개변수가 name이나 manufacture에 포함된 데이터를 조회하는 메소드
	public List<Cafe> search(String word) {
		// List는 생성해서 리턴
		List<Cafe> list = new ArrayList<Cafe>();
		connect();
		try {
			// 대소문자 구분을 하지 않은 검색은 sql에서도 대문자나 소문자로 바꾸고 java에서도 대문자나 소문자로 바꿔주어야 한다.
			pstmt = con.prepareStatement("select * from cafe where upper(name) like ? or upper(region) like ?");
			pstmt.setString(1, "%" + word.toUpperCase() + "%");
			pstmt.setString(2, "%" + word.toUpperCase() + "%");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Cafe cafe = new Cafe();
				cafe.setNum(rs.getInt("num"));
				cafe.setName(rs.getString("name"));
				cafe.setRegion(rs.getString("region"));
				cafe.setTablenum(rs.getInt("tablenum"));
				cafe.setWifi(rs.getString("wifi"));
				cafe.setOpendate(rs.getDate("opendate"));

				list.add(cafe);
			}
			rs.close();
		} catch (Exception e) {
			System.err.println("데이터 검색 에러");
			System.err.println(e.getMessage());
		}
		close();
		return list;
	}
}
