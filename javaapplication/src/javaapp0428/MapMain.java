package javaapp0428;

import java.util.HashMap;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		// 해시 맵 인스턴스 생성
		HashMap<String, Object> map = new HashMap<>();
		//데이터 저장
		map.put("name", "갱플랭크");
		map.put("cost", "5");
		map.put("job", "우주 해적");
		map.put("att", "폭파광");
		
		//데이터 꺼내오기 - 없는 key를 사용하면 null
		System.out.println(map.get("name"));
		System.out.println(map.get("team"));
		
		//데이터 수정 - 존재하는 key에 데이터를 삽입하면 수정
		System.out.println(map.get("att"));
		map.put("att", "용병");
		System.out.println(map.get("att"));
		
		//데이터 삭제
		map.remove("att");
		
		//toString호출
		System.out.println(map);
		
		//Map의 전체 데이터 순회
		//key 전체를 Set으로 리턴
		Set <String> keys = map.keySet();
		//key 값을 이용해서 전체 데이터를 출력
		for(String key : keys) {
			System.out.println(key + ":" + map.get(key));
		}

	}

}
