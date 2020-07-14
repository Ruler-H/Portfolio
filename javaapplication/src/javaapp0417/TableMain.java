package javaapp0417;

public class TableMain {

	public static void main(String[] args) {
		//3개의 Row 데이터를 저장할 배열을 생성
		Row [] data = new Row[3];
		//기본형 배열이 아니므로 인스턴스를 직접 생성해서 대입
		data[0] = new Row();
		data[0].setName("황병헌");
		
		data[1] = new Row();
		data[1].setName("최황연");
		
		data[2] = new Row();
		data[2].setName("김종준");
		
		//배열의 데이터 출력
		for(int i=0; i<data.length; i=i+1) {
			//i번째 데이터를 가져와서 imsi에 대입
			Row imsi = data[i];
			System.out.println(imsi.getNum() + ":" + imsi.getName());
		}

	}

}
