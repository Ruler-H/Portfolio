package javaapp0417;

public class Champion {
	//맨 처음 한 번만 수행
	static {
		System.out.println("처음 한 번만 수행");
	}
	//인스턴스가 만들어질 때 마다 수행
	{
		System.out.println("인스턴스가 만들어 질 때마다 수행");
	}
	//챔피언명, 계열, 공격력를 저장
	//인스턴스가 직접 핸들링할 수 없도록 private으로 생성
	//프로퍼티 값을 대입하지 않으면 숫자 데이터는 0, boolean 데이터는 false 그리고 나머지는 null
	private String Name;
	private String Synergy;
	private int StrikingPower;
	private int DefensivePower;
	
	
	//눈에 보이지는 않지만 자바가 생성해주는 생성자
	//매개변수는 없고 상위 클래스의 생성자를 호출하는 생성자
	//이렇게 매개변수가 없는 생성자를
	//default constructor라고 한다.
	//생성자는 리턴타입이 없고 이름은 클래스 이름과 같아야 한다.
	public Champion() {
		super();
		//프로퍼티에 기본값 설정
		Name = "Riot";
		Synergy = "Lol";
		StrikingPower = 100;
		DefensivePower = 100;
	}
	//생성자 오버로딩
	public Champion(String name, String synergy, int strikingPower,
			int defensivePower) {
		super();
		Name = name;
		Synergy = synergy;
		StrikingPower = strikingPower;
		DefensivePower = defensivePower;
	}
	
	
	
	//전체 제목으로 사용할 변수를 생성
	//전체가 공통된 이름을 사용하기 때문에 static
	//변경할 수 없도록 final
	private static final String title = "전략적 팀 전투 챔피언";



	//프로퍼티를 private으로 만들어서
	//인스턴스가 사용할 수 없기 때문에
	//인스턴스가 사용할 수 있도록 접근자 메소드를 생성
	//접근자 메소드 - getter. setter
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSynergy() {
		return Synergy;
	}

	public void setSynergy(String synergy) {
		Synergy = synergy;
	}

	public int getStrikingPower() {
		return StrikingPower;
	}

	public void setStrikingPower(int strikingPower) {
		StrikingPower = strikingPower;
	}

	public int getDefensivePower() {
		return DefensivePower;
	}

	public void setDefensivePower(int defensivePower) {
		DefensivePower = defensivePower;
	}

	public static String getTitle() {
		return title;
	}

	//이름, 팀이름, 연봉을 받아서 set하는 메소드
	public void setProperty(String Name, String Synergy, int StrikingPower, int DefensivePower) {
		//메소드의 매개변수가 name, synergy, strikingPower
		//프로퍼티 이름도 name, synergy, strikingPower
		//메소드 안에서 만든 지역변수가 아닌 프로퍼티를 가져올 때는 this.을 붙여서 가져오면 됨
		//this를 생략하면 메소드 안에서 찾고 없으면 프로퍼티로 감
		this.Name = Name;
		this.Synergy = Synergy;
		this.StrikingPower = StrikingPower;
		this.DefensivePower = DefensivePower;
	}
	
	//이름과 공격력, 방어력만 입력만고 시너지는 추가 설정하는 메소드
	//위에 String, String, int를 매개변수로 하는 setProperty가 이미 존재
	//String, int를 매개변수로 받는 setProperty
	//이런 경우를 MethodOverloading이라고 함
	public void setProperty(String Name, int StrikingPower, int DefensivePower) {
		this.Name = Name;
		this.StrikingPower = StrikingPower;
		this.DefensivePower = DefensivePower;
	}
	
	//챔피언과 시너지 그리고 공격력을 출력하는 메소드
	public void display() {
		System.out.println("챔피언 : " + Name + " 시너지 : " + Synergy + " 공격력 : " + StrikingPower 
				+ " 방어력 : " + DefensivePower);
		
	}
	
	

}
