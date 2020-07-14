package javaapp0501;

import java.io.Serializable;

//챔이언 정보를 저장할 클래스 - VO, DTO, Domain 클래스라고도 한다.
public class LolDTO implements Serializable {
	//데이터를 구성할 프로퍼티를 private으로 선언
	private int num;
	private String name;
	private int cost;
	private String aff;
	
	//이번 작업은 대부분 데이터베이스를 사용하기 전에만 수행
	//인스턴스를 빠르게 만들기 위한 생성자 추가
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getAff() {
		return aff;
	}
	public void setAff(String aff) {
		this.aff = aff;
	}
	public LolDTO(int num, String name, int cost, String aff) {
		super();
		this.num = num;
		this.name = name;
		this.cost = cost;
		this.aff = aff;
	}
	public LolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//디버깅을 위한 메소드
	//이 메소드를 만들지 않으면 인스턴스 이름을 가지고 인스턴스를 출력할 때 클래스 이름과 해시코드가 리턴 됨
	//프로퍼티의 값을 빠르게 확인하기 위해서 만드는 메소드
	@Override
	public String toString() {
		return "LolDTO [num=" + num + ", name=" + name + ", cost=" + cost + ", aff=" + aff + "]";
	}
}
