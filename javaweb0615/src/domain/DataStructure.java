package domain;

public class DataStructure {
	//프로퍼티 선언
	private String name;
	private String description;

	public DataStructure(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public DataStructure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//디버깅을 위한 메소드
	@Override
	public String toString() {
		return "DataStructure [name=" + name + ", description=" + description + "]";
	}
	
}
