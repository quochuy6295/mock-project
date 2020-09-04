package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class RoleIdConvert implements AttributeConverter<RoleId, String>{

	@Override
	public String convertToDatabaseColumn(RoleId name) {
		if (name == null) {
		return null;
		}
		return name.getValue();
	}

	@Override
	public RoleId convertToEntityAttribute(String value) {
		return RoleId.of(value);
	}

}
