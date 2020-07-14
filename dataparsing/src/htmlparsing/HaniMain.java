package htmlparsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HaniMain {

	public static void main(String[] args) {
		String html = null;
		try {
			//URL 만들기 - 파라미터에 한글이 있으면 파라미터를 인코딩, 파라미터는 ? 다음에 나오는 문자열
			String addr = "http://www.hani.co.kr/";
			URL url = new URL(addr);
			//연결 객체 만들기	header에 추가하는 옵션이 있는지 확인		header가 있는 경우는 api key나 id나 pw를 설정해야 하는 경우
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(30000);
			con.setUseCaches(true);	//true or false 캐싱데이터를 받을지 안받을지
			//스트림을 사용해서 문자열을 읽어오는 부분	읽었는데 한글이 깨지면 InputStreamReader 생성자에 euc-kr 추가
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			//문자열을 복사하고 정리
			html = sb.toString();
			br.close();
			con.disconnect();
		}catch(Exception e) {
			System.err.println("다운로드 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		//데이터 확인 - 제대로 읽어왔느지 한글이 깨지는지 확인
		//System.out.println(html);
		if(html != null && html.trim().length() > 0) {
			//문서 구조 가져오기
			Document document = Jsoup.parse(html);
			//선택자 이용해서 가져오기
			Elements elements = document.select("#main-top > div.main-top > div.main-top-article > h4 > a");
			//선택자를 이용한 것은 반복문을 수행
			for(int i = 0; i < elements.size(); i++) {
				//DOM 1개 가져오기
				Element element = elements.get(i);
				//태그 안의 내용을 가져오기
				System.out.println(element.text());
				//시작 태그 안의 href라는 속성의 값을 가져오기 href는 해당 태그의 링크
				System.out.println(element.attr("href"));
			}
		}else {
			System.out.println("읽어온 데이터가 없음");
		}
	}

}

