package com.vti.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.reflect.TypeToken;
import com.vti.dto.UserDto;
import com.vti.entity.User;
import com.vti.services.IUserServices;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IUserServices services;

//	public UserDto convertToDto(User user) {
//		UserDto userDto = modelMapper.map(user, UserDto.class);
//		return userDto;
//	}
//
//	public User converToEntity(UserDto userDto) {
//		User user = modelMapper.map(userDto, User.class);
//		return user;
//	}

	@GetMapping()
	public ResponseEntity<?> getAllUser(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "2") Integer pageSize, @RequestParam(defaultValue = "userId") String sortBy) {
		// get data
		List<User> entities = services.getAllUser(pageSize, pageSize, sortBy);
		// convert dto
		@SuppressWarnings("serial")
		Type type = new TypeToken<List<UserDto>>() {
		}.getType();
		List<UserDto> dtos = modelMapper.map(entities, type);
		return new ResponseEntity<List<UserDto>>(dtos, HttpStatus.OK);
	}

	@SuppressWarnings("serial")
	@GetMapping(value = "/{userName}")
	public ResponseEntity<?> getUserByuserName(@PathVariable(name = "userName") String userName) {
		// get data
		User entities = services.getUserByuserName(userName);
		// convert dto
		Type type = new TypeToken<UserDto>() {
		}.getType();
		UserDto dtos = modelMapper.map(entities, type);
		return new ResponseEntity<UserDto>(dtos, HttpStatus.OK);
	}

//	@PostMapping()
//	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto dtos) {
//		services.save(dtos);
//		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
//	}

//	@PostMapping()
//	@ResponseStatus(HttpStatus.CREATED)
//	public UserDto createUser(@RequestBody UserDto userdto) {
//		User user = converToEntity(userdto);
//		User usercreated = services.createUser(user);
//		return convertToDto(usercreated);
//	}

//	@PostMapping()
//	public ResponseEntity<?> createUser(@RequestBody User users) {
//		services.createUser(users);
//		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
//	}

//	@PostMapping
//	public ResponseEntity<?> addUser(@RequestBody UserDtoForAdd dtos){
//		services.save(dtos);
//		return new ResponseEntity<String>("success", HttpStatus.OK);
//	}
//	
//	@PostMapping(value = "/{RoleName}/role")
//	public ResponseEntity<?> AddRoleToUser(@PathVariable(name = "RoleName") RoleName RoleName,
//			@RequestBody  RoleDTO RoleDTO) throws ParseException {
//		RoleDTO role  =new RoleDTO(RoleName);
//		User user= services.getCarById(carPK);
//		Accessory accessory=dtoAccessoryForAddAndUpdate.toEntity();
//		accessory.setCar(car);
//		carService.addOrUpdateCarAccessories(accessory);
//		return new ResponseEntity<String>("save car's accessory successfully!", HttpStatus.OK);
//	}

	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User user1 = services.addUser(user);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateUser(@PathVariable(name = "id") short id, @RequestBody User user) {
		user.setUserId(id);
		services.updateUser(user);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name = "id") short id) {
		services.deleteUser(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
