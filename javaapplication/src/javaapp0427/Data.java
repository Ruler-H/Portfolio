package javaapp0427;

import java.util.ArrayList;

// 번호, 이름, 비용, 계열, 직업, DPS 정보를 갖는 클래스
// 번호는 정수, 번호를 제외하고는 전부 문자열
public class Data {
	private int num;
	private String name;
	private String cost;
	private String aff;
	private String job;
	private String dps;
	public Data(int num, String name, String cost, String aff, String job, String dPS) {
		super();
		this.num = num;
		this.name = name;
		this.cost = cost;
		this.aff = aff;
		this.job = job;
		this.dps = dPS;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Data [num=" + num + ", name=" + name + ", cost=" + cost + ", aff=" + aff + ", job=" + job + ", DPS="
				+ dps + "]";
	}
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
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getAff() {
		return aff;
	}
	public void setAff(String aff) {
		this.aff = aff;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDPS() {
		return dps;
	}
	public void setDPS(String dPS) {
		dps = dPS;
	}
	

}
