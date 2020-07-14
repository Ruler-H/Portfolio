package javaapp0428;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateMain {

	public static void main(String[] args) {
		// 1986년 5월 5일을 Calendar클래스의 인스턴스로 생성
		GregorianCalendar meetDay = new GregorianCalendar(1986, 4, 5);
		//년도만 가져오기
		System.out.println(meetDay.get(Calendar.YEAR));
		//Date로 변환
		//Calendar가 날짜는 정확한데 데이터베이스와 연동은 Date로 해야 한다.
		Date date = new Date(meetDay.getTimeInMillis());
		System.out.println(date);
		
		//현재 날짜 및 시간 만들기
		GregorianCalendar today = new GregorianCalendar();
		System.out.println(today);
		
		//날짜 차이 계산
		long gap = today.getTimeInMillis() - meetDay.getTimeInMillis();
		gap = gap / 1000;
		gap = gap / 86400;
		System.out.println("만난지" + gap + "일 째"); 

	}

}
