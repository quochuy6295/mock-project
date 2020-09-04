package com.vti.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
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

	@GetMapping()
	public ResponseEntity<?> getAllUser() {
		// get data

		List<User> entities = services.getAllUser();
		// convert dto
		Type type = new TypeToken<List<UserDto>>() {}.getType();
		List<UserDto> dtos = modelMapper.map(entities, type);

		return new ResponseEntity<List<UserDto>>(dtos, HttpStatus.OK);
	}

	@GetMapping(value = "/{userName}")
	public ResponseEntity<?> getUserByuserName(@PathVariable(name = "userName") String userName) {
		return new ResponseEntity<User>(services.getUserByuserName(userName), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody User user) {
		services.createUser(user);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
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
