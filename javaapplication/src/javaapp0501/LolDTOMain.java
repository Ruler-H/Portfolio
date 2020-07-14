package javaapp0501;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LolDTOMain{

	public static void main(String[] args) {
		// LolDTO 클래스의 인스턴스 2개 만들기
		LolDTO obj1 = new LolDTO(1, "갱플랭크", 5, "우주 해적");
		LolDTO obj2 = new LolDTO();
		obj2.setNum(2);
		obj2.setName("그레이브즈");
		obj2.setCost(1);
		obj2.setAff("우주 해적");
		
		//위의 2개를 배열로 묶기
		LolDTO [] ar = {obj1, obj2};
		
		//ArrayList로 묶어주기
		ArrayList<LolDTO> list = new ArrayList<> ();
		list.add(obj1);
		list.add(obj2);
		
		
		//오늘 날짜를 문자열로 만들기
		Date date = new Date();
		//날짜를 원하는 포맷의 문자열로 만들어주는 인스턴스
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		//System.out.println(today);
		
		//파일에 기록
		//ObjectOutputStream
		//FileOutputStream 인스턴스를 이용해서 생성
		//파일의 경로를 가지고 생성
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(today + ".dat"))){
			//파일에 기록
			oos.writeObject(list);
		}catch(Exception e) {
			
		}

	}

}
