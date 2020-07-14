package javaapp0522;

public class CafeMain {
	private String name;
	private String region;
	private int americanocost;
	private int tablenum;
	private int plugnum;
	@Override
	public String toString() {
		return "CafeMain [name=" + name + ", region=" + region + ", americanocost=" + americanocost + ", tablenum="
				+ tablenum + ", plugnum=" + plugnum + "]";
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
	public int getAmericanocost() {
		return americanocost;
	}
	public void setAmericanocost(int americanocost) {
		this.americanocost = americanocost;
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
}
