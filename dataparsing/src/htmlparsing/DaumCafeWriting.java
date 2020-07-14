package htmlparsing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DaumCafeWriting {

	public static void main(String[] args) {
		try {
			//크롬을 사용하기 위한 환경설정
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\30401\\Desktop\\안드로이드&IOS 앱 개발자 양성\\chromedriver_win32\\chromedriver.exe");
			//브라우저 실행 객체 만들기
			WebDriver driver = new ChromeDriver();
			//다음 로그인 페이지 접속
			driver.get("https://logins.daum.net/accounts/signinform.do?url=https%3A%2F%2Fwww.daum.net%2F");
			//아이디 입력란을 찾기
			WebElement id = driver.findElement(By.xpath("//*[@id=\"id\"]"));
			//입력란에 아이디 입력
			id.sendKeys("gjs5515");
			//패스워드 입력란을 찾기
			WebElement pw = driver.findElement(By.xpath("//*[@id=\"inputPwd\"]"));
			//입력란에 패스워드 입력
			pw.sendKeys("qudgjs01!?");
			//로그인 버튼 찾기
			WebElement login = driver.findElement(By.xpath("//*[@id=\"loginBtn\"]"));
			//로그인 버튼 클릭
			login.click();
			//페이지 이동이 많을 때는 과부하를 방지하기 위해서 중간중간 sleep을 추가
			Thread.sleep(3000);
			//카페로 이동       
			driver.get("http://cafe.daum.net/javadbeaver");
			Thread.sleep(3000);
			//프레임으로 이동
			driver.switchTo().frame("down");
			//게시판 버튼 찾기
			WebElement board = driver.findElement(By.xpath("//*[@id=\"fldlink_AFPc_314\"]"));
			Thread.sleep(3000);
			board.click();
			//게시물 버튼 찾기
			WebElement gle = driver.findElement(By.xpath("//*[@id=\"article-list\"]/tr/td[3]/span/strong/span/a"));
			Thread.sleep(3000);
			gle.click();
			//게시물 입력
			WebElement memo = driver.findElement(By.xpath("//*[@id=\"comment-list\"]/div[5]/div/div[1]/textarea"));
			memo.sendKeys("댓글을 입력합니다.");
			//등록 버튼 찾기
			WebElement registerbutton = driver.findElement(By.xpath("//*[@id=\"comment-list\"]/div[5]/div/div[2]/div[2]/div/button"));
			Thread.sleep(3000);
			registerbutton.click();
			
			
		}catch(Exception e) {
			System.err.println("다음 카페 글쓰기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
