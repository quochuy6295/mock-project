package com.vti.entity.enumerate;

public enum RoleId {
	Teamlead("1"), Telesale("2");

	private String value;

	private RoleId(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static RoleId of(String value) {
		if(value == null) {
			return null;
		}
		
		for (RoleId name : RoleId.values()){
			if(name.getValue().equals(value)){
				return name;
			}
		}
		return null;
	}
}
