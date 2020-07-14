package dataparsing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CSVMain {

	public static void main(String[] args) {
		try(
				//CSV 파일 읽기 개체 만들기
				CsvBeanReader reader = new CsvBeanReader(new BufferedReader(new InputStreamReader(new FileInputStream
						("C:\\Users\\30401\\Desktop\\JavaApplication\\javaapp0522\\2018년 관서별 청소년 5대범죄 현황.csv")))
						, CsvPreference.STANDARD_PREFERENCE);
				){
			//파일 읽기 개체가 생성되었는지 확인
			//System.out.println(reader);
			
			//첫번째 줄이 헤더인지 여부를 설정
			//헤더를 설정하면 첫번째 줄은 읽지 않음
			reader.getHeader(true);
			
			//DTO 클래스의 변수들을 순서대로 문자열 배열로 생성
			//이 부분을 가지고 한 줄의 데이터를 읽었을 때 변수에 대입
			String [] headers = {"classification","murder","gangdo","ganggan","juldo","pokhang"};
			
			//제약조건 생성
			CellProcessor [] processors = new CellProcessor[] {
				new Optional(),
				new ParseInt(new Optional()),
				new ParseInt(new Optional()),
				new ParseInt(new Optional()),
				new ParseInt(new Optional()),
				new ParseInt(new Optional()),
			};
			
			//읽은 데이터를 저장할 DTO의 List를 생성
			List<Crime> list = new ArrayList<Crime>();
			
			//데이터를 읽어서 저장
			while(true) {
				Crime crime = reader.read(
						Crime.class, headers, processors);
				//더 이상 읽지 못하면 종료
				if(crime == null) {
					break;
				}
				
				//읽은 경우에는 list에 추가
				list.add(crime);
			}
			
			//데이터 사용
			for(Crime crime : list) {
				System.out.println(crime.getClassification() + ":" + crime.getJuldo());
			}
		}catch(Exception e) {
			System.err.println("csv 읽기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
