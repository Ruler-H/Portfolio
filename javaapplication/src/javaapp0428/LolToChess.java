package javaapp0428;

//챔프코드(문자열), 챔프이름(문자열), 공격속도(실수), 방어력(정수), 계열(문자열)
public class LolToChess {
	private String code;
	private String champion;
	private double attackSpeed;
	private int defence;
	private String att;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getChampion() {
		return champion;
	}
	public void setChampion(String champion) {
		this.champion = champion;
	}
	public double getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public String getAtt() {
		return att;
	}
	public void setAtt(String att) {
		this.att = att;
	}
	@Override
	public String toString() {
		return "LolToChess [code=" + code + ", champion=" + champion + ", attackSpeed=" + attackSpeed + ", defence="
				+ defence + ", att=" + att + "]";
	}
	public LolToChess(String code, String champion, double attackSpeed, int defence, String att) {
		super();
		this.code = code;
		this.champion = champion;
		this.attackSpeed = attackSpeed;
		this.defence = defence;
		this.att = att;
	}
	public LolToChess() {
		super();
		// TODO Auto-generated constructor stub
	}

}
