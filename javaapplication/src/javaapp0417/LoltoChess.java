package javaapp0417;

public class LoltoChess {

	public static void main(String[] args) {
		Champion chm1 = new Champion();
		chm1.setName("제라스");
		chm1.setSynergy("암흑의 별");
		chm1.setStrikingPower(60);
		chm1.setDefensivePower(20);
		chm1.display();
		
		//새로운 인스턴스를 만들고 데이터 저장
		Champion chm2 = new Champion();
		chm2.setName("에코");
		chm2.setSynergy("사이버네틱");
		chm2.setStrikingPower(60);
		chm2.setDefensivePower(30);
		chm2.display();
		
		Champion chm3 = new Champion();
		chm3.setProperty("아우렐리온 솔", "반군", 10, 35);
		chm3.display();
		
		Champion chm4 = new Champion();
		chm4.setProperty("쓰레쉬", 50, 35);
		chm4.display();
		
		//chm2의 DefensivePower를 가져와서 30을 더한 후 다시 설정
		//값을 설정할 때는set, 가져올 때는 get
		int temp = chm2.getDefensivePower();
		chm2.setDefensivePower(temp + 30);
		Champion chm5 = new Champion();
		Champion chm6 = new Champion();
		chm6.setName("미스 포츈");
		chm6.setSynergy("발키리");
		chm6.setStrikingPower(60);
		chm6.setDefensivePower(20);
		Champion chm7 = new Champion("룰루", "천상", 45, 25);
		
		System.out.println(chm5.getName());
		

	}

}
