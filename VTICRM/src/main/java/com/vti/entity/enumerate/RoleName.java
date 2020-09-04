package com.vti.entity.enumerate;

public enum RoleName {
	Teamlead("Teamlead"), Telesale("Telesale");

	private String value;

	private RoleName(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static RoleName of(String value) {
		{
			if (value == null) {
				return null;
			}

			for (RoleName name : RoleName.values()) {
				if (name.getValue().equals(value)) {
					return name;
				}
			}
			return null;
		}
	}
}
