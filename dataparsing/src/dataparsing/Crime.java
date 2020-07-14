package dataparsing;

public class Crime {
	private String classification;
	private int murder;
	private int gangdo;
	private int ganggan;
	private int juldo;
	private int pokhang;
	
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getMurder() {
		return murder;
	}
	public void setMurder(int murder) {
		this.murder = murder;
	}
	public int getGangdo() {
		return gangdo;
	}
	public void setGangdo(int gangdo) {
		this.gangdo = gangdo;
	}
	public int getGanggan() {
		return ganggan;
	}
	public void setGanggan(int ganggan) {
		this.ganggan = ganggan;
	}
	public int getJuldo() {
		return juldo;
	}
	public void setJuldo(int juldo) {
		this.juldo = juldo;
	}
	public int getPokhang() {
		return pokhang;
	}
	public void setPokhang(int pokhang) {
		this.pokhang = pokhang;
	}
	@Override
	public String toString() {
		return "Crime [classification=" + classification + ", murder=" + murder + ", gangdo=" + gangdo + ", ganggan="
				+ ganggan + ", juldo=" + juldo + ", pokhang=" + pokhang + "]";
	}
}
