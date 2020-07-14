package javaapp0501;

import java.io.Serializable;

//챔피언 코드(문자열), 챔피언 이름(문자열), 챔피언 공격속도(실수)를 저장하는 
public class DTO implements Serializable{
	private String chmcode;
	private String chmName;
	private double chmattspeed;
	public DTO(String chmcode, String chmName, double chmattspeed) {
		super();
		this.chmcode = chmcode;
		this.chmName = chmName;
		this.chmattspeed = chmattspeed;
	}
	public String getChmcode() {
		return chmcode;
	}
	public void setChmcode(String chmcode) {
		this.chmcode = chmcode;
	}
	public String getChmName() {
		return chmName;
	}
	public void setChmName(String chmName) {
		this.chmName = chmName;
	}
	public double getChmattspeed() {
		return chmattspeed;
	}
	public void setChmattspeed(double chmattspeed) {
		this.chmattspeed = chmattspeed;
	}
	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DTO [chmcode=" + chmcode + ", chmName=" +
				chmName + ", chmattspeed=" + chmattspeed + "]";
	}
}
