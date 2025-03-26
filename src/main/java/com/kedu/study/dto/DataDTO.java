package com.kedu.study.dto;

public class DataDTO {
	private int id;
	private String data;
	
	public DataDTO(int id, String data) {
		super();
		this.id = id;
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	

}
