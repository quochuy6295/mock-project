package com.vti.util;

//import lombok.Getter;
//import lombok.Setter;

public class Sortting {
	
	private String sortFiled;
	private String sortType;
	
	public Sortting(String sortFiled, String sortType) {
		this.sortFiled = sortFiled;
		this.sortType = sortType;
	}

	public String getSortFiled() {
		return sortFiled;
	}

	public void setSortFiled(String sortFiled) {
		this.sortFiled = sortFiled;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public Sortting() {
	}
	
}
