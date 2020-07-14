package javaapp0513.datebase;

import java.sql.Date;

public class Cafe {
	private int num;
	private	String name;
	private String region;
	private int	tablenum;
	private String wifi;
	private Date opendate;
	
	//생성자 - 인스턴스를 생성하기 위해서 호출하는 메소드
	//생성자는 new로 호출
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cafe(int num, String name, String region, int tablenum, String wifi, Date opendate) {
		super();
		this.num = num;
		this.name = name;
		this.region = region;
		this.tablenum = tablenum;
		this.wifi = wifi;
		this.opendate = opendate;
	}

	//접근자 메소드 - getters & setters
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getTablenum() {
		return tablenum;
	}

	public void setTablenum(int tablenum) {
		this.tablenum = tablenum;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	//디버깅을 빠르게 하기 위한 메소드
	@Override
	public String toString() {
		return "Cafe [num=" + num + ", name=" + name + ", region=" + region + ", tablenum=" + tablenum + ", wifi="
				+ wifi + ", opendate=" + opendate + "]";
	}
	
	

}
