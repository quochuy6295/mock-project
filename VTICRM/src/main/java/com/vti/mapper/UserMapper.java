//package com.vti.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import com.vti.dto.UserDto;
//import com.vti.entity.Role;
//import com.vti.entity.User;
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//	@Mapping(target = "id", ignore = true)
//	@Mapping(target = "password",source = "UserDtoForAdd.password")
//	User map(UserDto userdtos, Role role);
//}