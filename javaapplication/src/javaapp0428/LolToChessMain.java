package javaapp0428;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class LolToChessMain {

	public static void main(String[] args) {
		// 테이블 형태의 데이터 생성
		ArrayList<LolToChess> list = new ArrayList<>();
		list.add(new LolToChess("1", "갱플랭크", 1.00, 30, "우주 해적"));
		list.add(new LolToChess("2", "그레이브즈", 0.55, 35, "우주 해적"));
		list.add(new LolToChess("3", "니코", 0.65, 33, "별 수호자"));
		
		//데이터 출력하기
		System.out.println("코드\t이름\t공격속도\t방어력\t계열\t");
		for(LolToChess loltochess : list) {
			System.out.println(
					loltochess.getCode() + "\t" +
					loltochess.getChampion() + "\t" +
					loltochess.getAttackSpeed() + "\t" +
					loltochess.getDefence() + "\t" +
					loltochess.getAtt());
		}
		ArrayList <LinkedHashMap<String, Object>> lols = new ArrayList<>();
		LinkedHashMap<String, Object> lol1 = new LinkedHashMap<>();
		lol1.put("code", "1");
		lol1.put("name", "갱플랭크");
		lol1.put("attackSpeed", 1.00);
		lol1.put("defence", 30);
		lol1.put("aff", "우주 해적");
		lols.add(lol1);
		
		for(LinkedHashMap<String, Object> map : lols) {
			Set<String>keys = map.keySet();
			System.out.print(map.keySet() + "\t\n");
			for(String key : keys) {
				System.out.print(map.get(key) + "\t");
			}
		}
		

	}

}
