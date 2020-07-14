package javaapp0427;

import java.util.ArrayList;
import java.util.Comparator;

public class UserDefineClassListSortMain {

	public static void main(String[] args) {
		// Data 여러 개 저장하는 ArrayList 생성
		ArrayList<Data> chm = new ArrayList<>();

		// 데이터 추가
		chm.add(new Data(1, "갱플랭크", "5", "우주 해적", "용병, 폭파광", "60"));
		chm.add(new Data(2, "그레이브즈", "1", "우주 해적", "총잡이", "30"));
		chm.add(new Data(3, "니코", "3", "별 수호자", "수호자", "33"));
		chm.add(new Data(4, "다리우스", "2", "우주 해적", "마나 약탈자", "39"));
		chm.add(new Data(5, "제라스", "5", "암흑의 별", "마법사", "54"));
		chm.add(new Data(6, "에코", "5", "사이버네틱", "잠입자", "54"));
		chm.add(new Data(7, "아우렐리온 솔", "5", "반군", "우주선", "8"));
		chm.add(new Data(8, "쓰레쉬", "5", "시공간", "마나 약탈자", "48"));
		chm.add(new Data(9, "미스 포츈", "5", "발키리", "용병, 총잡이", "60"));
		chm.add(new Data(10, "룰루", "5", "천상", "신비술사", "36"));
		chm.add(new Data(11, "케일", "4", "발키리", "검사", "48"));
		chm.add(new Data(12, "초가스", "4", "공허", "싸움꾼", "42"));
		chm.add(new Data(13, "징크스", "4", "반군", "총잡이", "53"));
		chm.add(new Data(14, "진", "4", "암흑의 별", "저격수", "81"));
		chm.add(new Data(15, "이렐리아", "4", "사이버네틱", "검사, 마나 약탈자", "60"));
		chm.add(new Data(16, "오공", "4", "시공간", "선봉대", "38"));
		chm.add(new Data(17, "소라카", "4", "별 수호자", "신비술사", "34"));

		chm.sort(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}

		});
		// 데이터 출력
		for (Data data : chm) {
			System.out.println(data);
		}
		System.out.println("\n");
		chm.sort(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return o2.getName().compareTo(o1.getName());
			}

		});
		for (Data data : chm) {
			System.out.println(data);
		}
		System.out.println("\n");

		chm.sort(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// TODO Auto-generated method stub
				return o1.getNum() - o2.getNum();
			}

		});
		// 데이터 출력
		for (Data data : chm) {
			System.out.println(data);
		}
		System.out.println("\n");

		chm.sort(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				// cost의 오름차순으로 정렬하고 cost가 같다면 이름의 오름차순 정렬
				if (o1.getCost().compareTo(o2.getCost()) == 0) {
					return o1.getName().compareTo(o2.getName());
				} else {
					return o1.getCost().compareTo(o2.getCost());
				}
			}

		});
		// 데이터 출력
		for (Data data : chm) {
			System.out.println(data);
		}
		System.out.println("\n");

	}

}
