package xmlparsing;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class KhanEntertainmentsRSS {

	public static void main(String[] args) {
		
		// 다운로드 받은 문자열을 저장할 변수
		String xmlString = null;
		
		//tile과 link 여러 개를 저장할 자료구조를 생성				//List가 null을 가지면 반복문에서 예외가 발생한다.
		//List는 처음 만들 때 인스턴스를 생성해야 한다.				//출력할 때 예외가 발생하지 않도록 하기 위해서 인스턴스를 생성하고 시작한다.
		//List는 특별한 이변이 없는 한 반복문을 돌려야 하기 때문
		List <Map<String, Object>> list = new ArrayList<>();
		//파일 경로 생성
		String filepath = "./updatefile.dat";
		//파일이 존재하는 경우에만
		File f = new File(filepath);
		if(f.exists()) {
			//파일이 있으면 파일의 내용을 읽어오기
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
				String line = br.readLine();
				java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
				if(date.toString().equals(line)) {
					System.out.println("이미 다운로드 받음");
					System.exit(0);
				}
				br.close();
			}catch(Exception e) {
				System.err.println("실패");
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		try {
			System.out.println("다운로드");
			//다운로드 받은 날짜를 기록
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			//파일에 오늘 날짜를 기록
			PrintWriter pw = new PrintWriter(filepath);
			pw.print(date.toString());
			pw.flush();
			pw.close();
			// 1.주소 만들기 - 파라미터 확인
			String addr = "http://www.khan.co.kr/rss/rssdata/kh_entertainment.xml";
			URL url = new URL(addr);

			// 2.연결 객체 만들기
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			// 헤더 설정

			// 3.스트림을 만들어서 문자열 읽어오기		// 확인한 후 한글이 깨지면 수정
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			// 문자열을 임시로 저장할 인스턴스
			StringBuilder sb = new StringBuilder();
			// 줄 단위로 읽어서 sb에 저장
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			xmlString = sb.toString();

			// 4.정리 하기
			br.close();
			con.disconnect();
		} catch (Exception e) {
			System.err.println("다운로드 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		// 데이터 확인		// System.out.println(xmlString);

		// 다운로드 받은 문자열이 있을 때만 파싱할 수 있도록 조건문 설정
		if (xmlString != null && xmlString.trim().length() != 0) {
			try {
				// 루트 태그를 찾기
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));
				Element root = document.getDocumentElement();

				// 원하는 태그를 추출 : title과 link 태그의 값을 가져오기
				NodeList titles = root.getElementsByTagName("title");
				NodeList links = root.getElementsByTagName("link");
				// 반복문을 돌려서 하나씩 순회
				for (int i = 1; i < titles.getLength(); i++) {
					Map<String, Object> map = new HashMap<>();
					//title 저장
					Node node = titles.item(i);
					Node title = node.getFirstChild();
					map.put("tiltle", title.getNodeValue());
					//link 저장
					node = links.item(i);
					title = node.getFirstChild();
					map.put("link", title.getNodeValue());
					//list에 map을 추가
					list.add(map);
				}
			} catch (Exception e) {
				System.err.println("XML 데이터 파싱 실패");
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("다운로드 받은 데이터 없음");
			System.exit(0);
		}
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}

	}

}
