package com.vti.entity.enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class RoleNameConvert implements AttributeConverter<RoleName, String>{

	@Override
	public String convertToDatabaseColumn(RoleName name) {
		if(name == null){
			return null;
			}
		return name.getValue();
	}

	@Override
	public RoleName convertToEntityAttribute(String value) {
		return RoleName.of(value);
	}

}
