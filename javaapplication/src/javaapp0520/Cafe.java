package javaapp0520;


public class Cafe {
	@Override
	public String toString() {
		return "Cafe [num=" + num + ", name=" + name + ", region=" + region + ", tablenum=" + tablenum + ", plugnum="
				+ plugnum + ", americanocost=" + americanocost + ", refill=" + refill + "]";
	}
	private int num;
	private String name;
	private String region;
	private int tablenum;
	private int plugnum;
	private int americanocost;
	private String refill;
	
	public int getNum() {
		return num;
	}
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cafe(int num, String name, String region, int tablenum, int plugnum, int americanocost, String refill) {
		super();
		this.num = num;
		this.name = name;
		this.region = region;
		this.tablenum = tablenum;
		this.plugnum = plugnum;
		this.americanocost = americanocost;
		this.refill = refill;
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
	public int getPlugnum() {
		return plugnum;
	}
	public void setPlugnum(int plugnum) {
		this.plugnum = plugnum;
	}
	public int getAmericanocost() {
		return americanocost;
	}
	public void setAmericanocost(int americanocost) {
		this.americanocost = americanocost;
	}
	public String getRefill() {
		return refill;
	}
	public void setRefill(String refill) {
		this.refill = refill;
	}

}
