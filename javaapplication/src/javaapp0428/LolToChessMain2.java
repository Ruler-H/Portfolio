package javaapp0428;

import java.util.HashMap;

public class LolToChessMain2 {

	public static void main(String[] args) {
		// 2차원 배열 - 배열의 배열
		// 롤토체스 챔피언들의 직업별 챔피언 명단을 데이터로 작성
		String [] chensang = {"라칸", "룰루", "신짜오"};
		String [] sigonggan = {"블리츠크랭크", "쉔"};
		String [] cybernetic = {"레오나", "루시안"};
		String [] starofdark = {"럭스"};
		
		//이차원 배열 생성
		//배열에는 비교가 가능한 데이터만 저장하기 때문에 데이터 이외의 정보를 저장하지 못해서 이차원 배열을 이용하는 경우 배열의 특성을 출력할 수 없다.
		String [][] champions = {chensang, sigonggan, cybernetic, starofdark};
		
		//데이터 출력
		for(int i = 0; i < champions.length; i = i + 1) {
			if(i==0) {
				System.out.printf("%-5s", "천상 : ");
			}else if(i==1) {
				System.out.printf("%-5s", "시공간 : ");
			}else if(i==2) {
				System.out.printf("%-5s", "사이버네틱 : ");
			}
			//각 직업의 챔피언명단
			String [] temp = champions[i];
			for(String imsi : temp) {
				System.out.printf("%7s", imsi);
			}
			System.out.printf("\n");
			
			//배열을 하나로 묶어 줄 때는 Map을 만들어서 배열의 특징과 데이터를 저장하고 Map의 배열을 만들어주는 것이 좋다.
			HashMap<String, Object> map1 = new HashMap<String, Object>();
			map1.put("job", "천상");
			map1.put("champion", chensang);
			
			HashMap<String, Object> map2 = new HashMap<String, Object>();
			map1.put("job", "시공간");
			map1.put("champion", sigonggan);
			
			HashMap<String, Object> map3 = new HashMap<String, Object>();
			map1.put("job", "사이버네틱");
			map1.put("champion", cybernetic);
			
			HashMap<String, Object> map4 = new HashMap<String, Object>();
			map4.put("job", "암흑의 별");
			map4.put("champion", starofdark);
			
			HashMap [] lol = {map1, map2, map3};
			for(HashMap map : lol) {
				System.out.printf("%5s", map.get("job"));
				String [] champion = (String [])map.get("champion");
				for(String p : champion) {
					System.out.printf("%7s", p);
				}
				System.out.printf("\n");
			}
		}

	}

}
