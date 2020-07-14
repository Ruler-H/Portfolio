package javaapp0522;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class CSVMain {

	public static void main(String[] args) {
		//현재 디렉토리에 있는 cafe.csv 파일을 읽을 수 있는 CsvReader 인스턴스 생성
		try(CsvBeanReader reader = new CsvBeanReader(new BufferedReader(new InputStreamReader(
				new FileInputStream("./cafe.csv"))), CsvPreference.STANDARD_PREFERENCE)){
			//헤더 만들기
			//첫번째 행이 열 제목이라고 설정하고 그 내용을 headers에 저장
			String [] headers = reader.getHeader(true);
			
			//확인
			/*
			for(String title : headers) {
				System.out.println(title);
			}
			*/
			//"HUGE", "가장동", 2500, 30, 20
			//첫번째 항목은 필수
			CellProcessor [] processors = new CellProcessor[] {
					new NotNull(),
					new Optional(),
					new ParseInt(),
					new ParseInt(),
					new ParseInt(new NotNull())
			};
			
			//데이터를 저장할 list 생성
			List<CafeMain> list = new ArrayList<CafeMain>();
			//순회하면서 데이터를 읽어서 list에 추가
			while(true) {
				CafeMain cafe = reader.read(CafeMain.class, headers, processors);
				//읽은 데이터가 없으면 종료
				if(cafe == null) {
					break;
				}
				//읽은 데이터가 있으면 List에 저장
				list.add(cafe);
			}
		}catch(Exception e) {
			System.err.println("csv 읽기 실패");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
