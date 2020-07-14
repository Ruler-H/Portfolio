package htmlparsing;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		try {
			//크롬을 사용하기 위한 환경 설정
			System.setProperty("webdriver.chrome.driver", 
					"C:\\Users\\30401\\Desktop\\안드로이드&IOS 앱 개발자 양성\\chromedriver_win32\\chromedriver.exe");
			//크롬 실행 객체 만들기
			WebDriver driver = new ChromeDriver();
			//페이지 접속
			driver.get("https://www.naver.com");
		}catch(Exception e) {
			System.err.println("크롬 실행 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
