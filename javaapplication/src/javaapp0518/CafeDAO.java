package javaapp0518;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CafeDAO {
	//클래스가 로드될 때 1번만 수행되는 코드, 제일 먼저 실행되는 코드
	static {
		//MySQL 드라이버 클래스 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.err.println("드라이버 클래스 로드 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	//싱글톤 패턴(인스턴스를 1개만 생성할 수 있도록 하는 패턴)을 위한 코드
	//Back-End Programmer를 주력으로 하고자 하는 경우에는 객체지향 디자인 패턴을 학습
	
	//생성자가 private이므로 외부에서 인스턴스 생성을 못함
	private CafeDAO() {}
	
	//변수를 1개만 생성할 수 있도록 선언
	private static CafeDAO cafeDAO;
	
	//외부에서 생성된 인스턴스를 사용할 수 있도록 리턴해주는 메소드
	public static CafeDAO sharedInstance() {
		//static 변수이므로 null을 대입하지 않는 이상 맨 처음에만 null이고 이후에는 null이 될 수 없음
		if(cafeDAO == null) {
			cafeDAO = new CafeDAO();
		}
		return cafeDAO;
	}
	//Java Server 개발에는 Spring을 많이 사용하는데 Spring이 자동으로 클래스를 Singleton Pattern으로 디자인해 준다.
	
	//여러 메소드에서 공통으로 사용할 변수
	//java.sql 패키지의 클래스를 import
	private Connection con;
	private PreparedStatement pstmt;
	
	//데이터베이스 접속을 위한 메소드
	private void connect() {
		try {
			//데이터베이스 연결
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "********");
			System.out.println("데이터베이스 접속 성공");
		} catch (Exception e) {
			System.err.println("데이터베이스 접속 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	//데이터베이스 연결 객체를 정리해주는 메소드
	private void close() {
		try {
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		} catch (Exception e) {
			System.err.println("데이터베이스 접속 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//1.전체보기를 위한 메소드
	//조회는 몇 열의 데이터를 몇 행으로 조회하는지 : 리턴타입
	//where 절이 있는지 확인 : 파라미터
	//select * from cafe;
	public List<Cafe> allCafe(){
		//List를 리턴할 때는 인스턴스를 만들고 리턴
		List<Cafe> list = new ArrayList<Cafe>();
		
		//데이터베이스 연결
		connect();
		
		try {
			//SQL 실행 객체 생성
			pstmt = con.prepareStatement("select * from cafe");
			//SQL 실행
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cafe cafe = new Cafe();
				cafe.setNum(rs.getInt("num"));
				cafe.setName(rs.getString("name"));
				cafe.setRegion(rs.getString("region"));
				//List에 추가
				list.add(cafe);
			}
		}catch(Exception e) {
			System.err.println("전체 데이터 가져오기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		//데이터베이스 연결 해제
		close();
		
		//데이터가 없을 때는 List의 size가 0
		return list;
	}
	
	//2.상세보기를 위한 메소드
	//select * from cafe where 기본키 = ?
	public Cafe search(int num) {
		//하나의 행이 리턴되는 경우는 인스턴스는 데이터를 가져왔을 때 생성
		Cafe cafe = null;
		connect();
		
		try {
			//select 구문의 경우 where절이 있으면 데이터를 매개변수로 받아서 바인딩을 해야 한다.
			pstmt = con.prepareStatement("select * from cafe where num = ?");
			pstmt.setInt(1, num);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//리턴할 데이터의 인스턴스를 생성
				cafe = new Cafe();
				cafe.setNum(rs.getInt("num"));
				cafe.setName(rs.getString("name"));
				cafe.setRegion(rs.getString("region"));
				cafe.setTablenum(rs.getInt("tablenum"));
				cafe.setPlugnum(rs.getInt("plugnum"));
				cafe.setAmericanocost(rs.getInt("americanocost"));
				cafe.setRefill(rs.getString("refill"));
			}
			
		}catch(Exception e) {
			System.err.println("상세보기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return cafe;
	}
}
