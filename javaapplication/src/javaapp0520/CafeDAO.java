package javaapp0520;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample"
					+ "?useUnicode=true&characterEncoding=utf8", "root", "********");
			//System.out.println("데이터베이스 접속 성공");
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
			rs.close();
			
			//현재 날짜를 포함한 파일 경로를 만들기
			//java.sql.Date 인스턴스 생성
			Date today = new Date(System.currentTimeMillis());
			//현재 디렉토리에 오늘날짜.log 문자열 생성
			String filepath = "./" + today.toString() + ".log";
			//try() 안에서 만들면 close를 호출하지 않아도 된다.
			//true를 대입한 것은 없으면 만들지만 있으면 데이터를 뒤에 추가
			try(PrintWriter pw = new PrintWriter(new FileOutputStream(filepath, true))){
				java.util.Date date = new java.util.Date();
				pw.print(date.toString() + "\t전체보기\n");
				pw.flush();
			}
			
			Date curdate = new Date(System.currentTimeMillis());
			String filename = "./" + curdate.toString() + ".dat";
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename, true))){
				Log log = new Log();
				log.setDate(new java.util.Date());
				log.setTask("전체보기");
				oos.writeObject(log);
				oos.flush();
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
	
	//cafe테이블에서 가장 큰 num을 찾아오는 메소드
	public int maxNum() {
		//데이터가 없을 때는 번호가 0이 있다고 가정해야 하기 때문에 result = 0
		//가장 큰 수를 찾는 SQL문 "select max(num) from cafe"
		int result = 0;
		connect();
		try {
			pstmt = con.prepareStatement("select max(num) from cafe");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				//아래와 같은 코드를 입력하면 select의 첫 번째 컬럼의 값을 정수로 result에 저장
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			//자신이 알아볼 수 있는 에러 메시지를 입력
			System.err.println("가장 큰 번호 가져오기 실패");
			//프로그램이 주는 예외 메시지를 출력
			System.err.println(e.getMessage());
			//예외 발생 지점을 찾기 위한 작업
			e.printStackTrace();
		}
		close();
		return result;
	}
	//3.데이터를 삽입하는 메소드
	//insert into 테이블이름(컬럼이름 나열) values(값을 나열)
	//특별한 경우가 아니면 컬럼은 2개 이상
	//select를 제외한 모든 SQL의 실행은 영향받는 행의 개수를 리턴
	public int insertCafe(Cafe cafe) {
		//Serializable된 데이터 읽어오기
		Date today1 = new Date(System.currentTimeMillis());
		String filename = "./" + today1.toString() + ".dat";
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Log log = (Log)ois.readObject();
			System.out.println(log);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//여기서 -1은 의미없는 값으로 삽입 실패를 의미하는 값
		//어떤 음수라도 가능 - 0은 조심
		int result = -1;
		//데이터베이스 연결
		int num = this.maxNum() + 1;
		connect();
		
		try {
			//SQL 실행 객체 생성 - SQL 생성
			//값을 대입하는 곳은 ?로 설정
			//값을 대입하는 곳 중에서 고정된 값이면 고정된 값을 이용
			pstmt = con.prepareStatement(
					"insert into cafe(num, name, region, tablenum, plugnum, americanocost, refill)"
					+ " values(?, ?, ?, ?, ?, ?, ?)");
			//비어 있는 곳에 값을 채움(바인딩 - Binding)
			//pstmt.setInt(1, cafe.getNum());  - 번호를 입력받는 경우의 코드
			
			//가장 큰 번호를 찾아서 +1을 하는 방식의 코드
			pstmt.setInt(1, num);
			pstmt.setString(2, cafe.getName());
			pstmt.setString(3, cafe.getRegion());
			pstmt.setInt(4, cafe.getTablenum());
			pstmt.setInt(5, cafe.getPlugnum());
			pstmt.setInt(6, cafe.getAmericanocost());
			pstmt.setString(7, cafe.getRefill());
			
			//SQL 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			//자신이 알아볼 수 있는 에러 메시지를 입력
			System.err.println("데이터 삽입 실패");
			//프로그램이 주는 예외 메시지를 출력
			System.err.println(e.getMessage());
			
			//위의 2개 작업은 파일이나 데이터베이스에 기록하고 주석 처리
			
			//예외 발생 지점을 찾기 위한 작업
			e.printStackTrace();
		}
		//현재 날짜를 포함한 파일 경로를 만들기
		//java.sql.Date 인스턴스 생성
		Date today = new Date(System.currentTimeMillis());
		//현재 디렉토리에 오늘날짜.log 문자열 생성
		String filepath = "./" + today.toString() + ".log";
		//try() 안에서 만들면 close를 호출하지 않아도 된다.
		//true를 대입한 것은 없으면 만들지만 있으면 데이터를 뒤에 추가
		try(PrintWriter pw = new PrintWriter(new FileOutputStream(filepath, true))){
			java.util.Date date = new java.util.Date();
			pw.print(date.toString() + "\t삽입\n");
			pw.flush();
		}catch(Exception e) {
			
		}
		//데이터베이스 연결 해제
		close();
		return result;
	}
	
	//4.데이터를 삭제하는 메소드
	//delete from 테이블이름 where 기본키 = ?
	//리턴타입은 정수
	//매개변수는 기본키
	public int deleteCafe(int num) {
		int result = -1;
		connect();
		try {
			pstmt = con.prepareStatement("delete from cafe where num = ?");
			pstmt.setInt(1, num);
			//실행
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			//자신이 알아볼 수 있는 에러 메시지를 입력
			System.err.println("데이터 삭제 실패");
			//프로그램이 주는 예외 메시지를 출력
			System.err.println(e.getMessage());
			//예외 발생 지점을 찾기 위한 작업
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	//5.데이터를 수정하는 메소드
	public int updateCafe(Cafe cafe) {
		int result = -1;
		connect();
		try {
			pstmt = con.prepareStatement("update cafe set name = ?, region = ?, tablenum = ?, plugnum = ?, "
					+ "americanocost = ?, refill = ? where num = ?");
			pstmt.setString(1, cafe.getName());
			pstmt.setString(2, cafe.getRegion());
			pstmt.setInt(3, cafe.getTablenum());
			pstmt.setInt(4, cafe.getPlugnum());
			pstmt.setInt(5, cafe.getAmericanocost());
			pstmt.setString(6, cafe.getRefill());
			pstmt.setInt(7, cafe.getNum());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			//자신이 알아볼 수 있는 에러 메시지를 입력
			System.err.println("데이터 수정 실패");
			//프로그램이 주는 예외 메시지를 출력
			System.err.println(e.getMessage());
			//예외 발생 지점을 찾기 위한 작업
			e.printStackTrace();
		}
		close();
		return result;
	}
	
	//6.카페이름이나 지역에 포함된 데이터 찾아오기
	//검색어를 매개변수로 받아서 검색어가 포함된 데이터를 찾아오는 메소드
	public List<Cafe> searchCafe(String word){
		List<Cafe> list = new ArrayList<Cafe>();
		connect();
		try {
		pstmt = con.prepareStatement("select * from cafe where name like ? or region like ?");
		pstmt.setString(1, "%" + word + "%");
		pstmt.setString(2, "%" + word + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Cafe cafe = new Cafe();
			cafe.setNum(rs.getInt("num"));
			cafe.setName(rs.getString("name"));
			cafe.setRegion(rs.getString("region"));
			cafe.setTablenum(rs.getInt("Tablenum"));
			
			list.add(cafe);
		}
		rs.close();
		}catch(Exception e) {
			//자신이 알아볼 수 있는 에러 메시지를 입력
			System.err.println("데이터 검색 실패");
			//프로그램이 주는 예외 메시지를 출력
			System.err.println(e.getMessage());
			//예외 발생 지점을 찾기 위한 작업
			e.printStackTrace();
		}
		close();
		return list;
	}
	
	//7.전체데이터 개수를 구하는 메소드
	//select count(*) from 테이블이름;
	public int getCount() {
		int result = -1;
		connect();
		
		try {
			pstmt = con.prepareStatement("select count(*) from cafe");
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("count(*)");
			}
			rs.close();
			}catch(Exception e) {
				//자신이 알아볼 수 있는 에러 메시지를 입력
				System.err.println("데이터 개수 확인 실패");
				//프로그램이 주는 예외 메시지를 출력
				System.err.println(e.getMessage());
				//예외 발생 지점을 찾기 위한 작업
				e.printStackTrace();
			}
		
		close();
		return result;
	}
	
	//페이지 번호와 페이지 당 데이터 개수를 받아서 페이지 번호에 해당하는 데이터를 조회하는 메소드
	//실제 업무의 경우 매개변수로 검색어가 포함된다.
	public List<Cafe> pageCafe(int pageno, int pagecnt) {
		List<Cafe> list = new ArrayList<Cafe>();
		connect();
		
		try {
			pstmt = con.prepareStatement("select * from cafe limit ?, ?");
			pstmt.setInt(1, pagecnt*(pageno-1));
			pstmt.setInt(2, pagecnt);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cafe cafe = new Cafe();
				cafe.setNum(rs.getInt("num"));
				cafe.setName(rs.getString("name"));
				cafe.setRegion(rs.getString("region"));
				list.add(cafe);
			}
		}catch(Exception e) {
			//자신이 알아볼 수 있는 에러 메시지를 입력
			System.err.println("실패");
			//프로그램이 주는 예외 메시지를 출력
			System.err.println(e.getMessage());
			//예외 발생 지점을 찾기 위한 작업
			e.printStackTrace();
		}
		
		close();
		return list;
	}
	
	
	
	
	
	
	
}
