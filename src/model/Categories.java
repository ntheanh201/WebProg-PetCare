package model;

public class Categories {
	private int id;
	private String name;
	private int cate_id;
	
	public int getCate_id() {
		return cate_id;
	}
	
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
