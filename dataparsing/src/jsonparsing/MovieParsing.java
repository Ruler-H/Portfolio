package jsonparsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class MovieParsing {

	public static void main(String[] args) {
		//다운로드 받을 문자열을 저장할 변수
		String jsonString = null;
		// 웹에서 다운로드 받기
		try {
			//다운로드 받을 주소 만들기
			String addr = "http://swiftapi.rubypaper.co.kr:2029/hoppin/movies?version=1&page=1&count=20&genreId=&order=releasedatease";
			//URL에 한글이 있으면 한글 부분은 UTF-8로 인코딩해야 한다.
			//URLEncoder.encode("한글문자열", "UTF-8")
			URL url = new URL(addr);
			
			//HttpURLConnection 생성
			//openConnection은 URLConnectuon이라는 추상클래스 타입으로 리턴하므로 강제 형 변환을 해서 일반 클래스 타입으로 변경
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			//옵션 설정
			con.setConnectTimeout(30000);	//최대 연결 시간 설정
			con.setUseCaches(false);	//이전에 받은 데이터 사용 여부
			
			//문자열을 읽을 스트림을 생성
			//읽은 내용이 깨질 대는 con.getInputStream 다음에, "인코딩 방식"을 추가
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			//문자열을 읽기 위한 임시변수를 생성
			StringBuilder sb = new StringBuilder();
			while(true) {
				//한 줄 읽어오기
				String line = br.readLine();
				//읽은 데이터가 없으면 종료
				if(line == null) {
					break;
				}
				//읽은 데이터가 있으면 sb에 추가
				sb.append(line + "\n");
			}
			
			//연결 종료
			br.close();
			con.disconnect();
			//읽은 내용을 String으로 변환
			jsonString = sb.toString();
			
			
		}catch(Exception e) {
			System.err.println("다운로드 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println(jsonString);
		
		//파싱 결과를 저장할 변수를 생성
		//title과 ratingAverage를 저장
		//title과 ratingAverage를 Map에 저장
		List<Map<String, Object>> list = new ArrayList<>();
		
		//데이터 파싱
		try {
			//텍스트가 존재하는 경우만 수행
			//&&만들 때는 null 체크를 먼저
			if(jsonString != null && jsonString.trim().length() > 0) {
				//천번째는 JSON 객체
				JSONObject mainData = new JSONObject(jsonString);
				//System.out.println(mainData);
				
				//hoppin이라는 key의 값을 객체로 가져오기
				JSONObject hoppin = mainData.getJSONObject("hoppin");
				//System.out.println(hoppin);
				JSONObject movies = hoppin.getJSONObject("movies");
				//System.out.println(movies);
				JSONArray movie = movies.getJSONArray("movie");
				//System.out.println(movie);
				for(int i = 0; i < movie.length(); i++) {
					JSONObject imsi = movie.getJSONObject(i);
					//System.out.println(imsi);
					
					//데이터 추출
					String title = imsi.getString("title");
					String ratinAverage = imsi.getString("ratingAverage");
					//Map으로 생성
					Map<String, Object> map = new HashMap<>();
					map.put("title", title);
					map.put("ratingAverage", Double.parseDouble(ratinAverage));
					//list에 추가
					list.add(map);
				}
				
			}else {
				System.out.println("다운로드 받은 문자열이 없음");
				//프로그램 종료
				System.exit(0);
			}
		}catch(Exception e) {
			System.err.println("데이터 파싱 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		//System.out.println(list);
		
		//데이터베이스에 저장
		try {
			//드라이버 클래스 로드
			Class.forName("com.mysql.jdbc.Driver");
			//이 메시지가 출력안되면 MySQL Driver를 프로젝트에 삽입하지 않았거나 드라이버 클래스 이름이 잘못된 것
			
			//데이터베이스 연결
			//MySQL은 한글이 있는 경우 연결 문자열에 유니코드 사용을 명시해야 한다.
			//?useUnicode=true&characterEncoding=utf8 -> 한글이 있을때 코드 추가 작성

			//&serverTimezone=UTCMySQL과 java의 driver의 번전이 맞지 않아서 timeZone에러가 발생하는 경우 추가
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useUnicode=true&"
					+ "characterEncoding=utf8&serverTimezone=UTC","root","********");
			//System.out.println(con);
			
			//list를 순회하면서 데이터를 테이블에 삽입하기
			for(Map<String, Object> map : list) {
				//SQL 실행 객체 만들기
				PreparedStatement pstmt = con.prepareStatement("insert into movie(title, ratingaverage)"
						+ " values(?,?)");
				pstmt.setString(1, (String)map.get("title"));
				pstmt.setDouble(2, (Double)map.get("ratingAverage"));

				//SQL을 실행
				pstmt.executeUpdate();
				
				pstmt.close();
			}
			
			//연결객체 닫기
			con.close();
			//System.out.println("드라이버 클래스 로드");
		}catch(Exception e) {
			System.err.println("데이터베이스에 저장 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
