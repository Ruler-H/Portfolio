package htmlparsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DongACrawling {

	public static void main(String[] args) {
		String html = null;
		try {
			//URL 만들기 - 파라미터에 한글이 있으면 파라미터를 인코딩, 파라미터는 ? 다음에 나오는 문자열
			String query = "황병헌";
			//파라미터 인코딩
			query = URLEncoder.encode(query, "utf-8");
			String addr = "https://www.donga.com/news/search?p=1&query="+
			query + "&check_news=1&more=1&sorting=1&search_date=1&v1=&v2=&range=1";
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
		//데이터 건수를 저장할 변수
		int cnt = -1;
		try {
			//텍스트를 메모리 펼치기
			Document document = Jsoup.parse(html);
			Elements elements = document.select("#content > div.searchContWrap > div.searchCont > h2 > span:nth-child(1)");
			
			for(int i = 0; i < elements.size(); i++) {
				Element element = elements.get(i);
				String content = element.text();
				//System.out.println(content);
				//기사 건수만 찾아오기
				//공백을 기준으로 분할
				String [] ar = content.split(" ");
				cnt = Integer.parseInt(ar[1]);
				//System.out.println(cnt);  -> 105
			}
		}catch(Exception e) {
			System.err.println("기사 개수 가져오기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		//페이지 당 데이터 개수
		int perPageCnt = 15;
		
		//페이지 개수 계산 : 전체 데이터 개수를 페이지당 데이터 개수로 나누고 나머지가 있으면 페이지 개수를 1개 추가
		int pageCnt = cnt / perPageCnt;
		if(cnt % perPageCnt != 0) {
			pageCnt = pageCnt + 1;
		}
		//System.out.println(pageCnt); -> 7
		
		//기사의 링크를 저장할 변수
		List<String> list = new ArrayList<>();
		try {
			for(int i = 0; i < pageCnt; i++) {
				//반복문 안에서 예외가 발생했을 때 다음 반복으로 넘어가고자 하면 반복문 안에서 예외 처리해야 한다.
				try {
					String query = "황병헌";
					//파라미터 인코딩
					query = URLEncoder.encode(query, "utf-8");
					String addr = "https://www.donga.com/news/search?p=" + ((i * perPageCnt) + 1) + "&query="+
					query + "&check_news=1&more=1&sorting=1&search_date=1&v1=&v2=&range=1";
					URL url = new URL(addr);
					
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					con.setUseCaches(false);
					con.setConnectTimeout(10000);
					
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					StringBuilder sb = new StringBuilder();
					while(true) {
						String line = br.readLine();
						if(line == null) {
							break;
						}
						sb.append(line + "\n");
					}
					
					html = sb.toString();
					br.close();
					con.disconnect();
					//다운로드 되엇는지 한글은 깨지지 않는지 확인
					//System.out.println(html);
					
					//링크 수집을 위해서 html 파싱
					Document doc = Jsoup.parse(html);
					//선택자가 너무 길 때는 앞 쪽은 생략해도 된다.
					Elements elements = doc.select("div.t > p.tit > a");
					for(int j = 0; j < elements.size(); j++) {
						Element element = elements.get(j);
						//a 태그의 href 속성을 list에 저장
						list.add(element.attr("href"));
					}
					//System.out.println(list);
				}catch(Exception e) {
					System.err.println("현재 페이지 읽어오기 실패");
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
			
		}catch(Exception e) {
			System.err.println("기사 링크 저장 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		//현재 디렉토리에 황병헌.txt파일에 기사 내용 저장, try() 안에 만든 객체는 close를 호출할 필요가 없다.
		try(PrintWriter pw = new PrintWriter("./황병헌.txt")) {
			for(String link : list) {
				try {
					URL url = new URL(link);
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					con.setUseCaches(false);
					con.setConnectTimeout(10000);
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					StringBuilder sb = new StringBuilder();
					while(true) {
						String line = br.readLine();
						if(line == null) {
							break;
						}
						sb.append(line + "\n");
						
					}
					html = sb.toString();
					br.close();
					con.disconnect();
					
					Document document = Jsoup.parse(html);
					Elements elements = document.select("#content > div > div.article_txt");
					for(int k = 0; k < elements.size(); k++) {
						Element element = elements.get(k);
						pw.println(element.text());
						pw.flush();
					}
				}catch(Exception e) {
					System.err.println("기사 가져오기 실패");
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			System.err.println("기사 저장 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
