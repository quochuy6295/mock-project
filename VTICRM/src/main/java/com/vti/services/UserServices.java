package com.vti.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.repository.IRoleRepository;
import com.vti.repository.IUserRepository;

@Service
public class UserServices implements IUserServices {

	@Autowired
	private IUserRepository repository;

	@Autowired
	private IRoleRepository irepository;

	public List<User> getAllUser(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		Page<User> pageResult = repository.findAll(paging);
		if (pageResult.hasContent()) {
			return pageResult.getContent();
		} else {
			return new ArrayList<User>();
		}
	}

	public User getUserByuserName(String userName) {
		return repository.findByuserName(userName);
	}

	public User addUser(User user) {
		Role role = irepository.findByroleId(user.getRole().getRoleId());
		role.setName(user.getRole().getName());
		user.setRole(role);
		return repository.save(user);
	}

//	public void a(UserDto dtos) {
//		UserDto userdtos = new UserDto(dtos);
//		//convert dto sang entity
//		@SuppressWarnings("serial")
//		Type type = new TypeToken<User>() {
//		}.getType();
//		User user = modelMapper.map(userdtos, type);
//		repository.save(user);
//	}

//	public void save(UserDtoForAdd dtos) {
//		Role role =  irepository.findById(dtos.getRoleId());
//		User user = 
//	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}

	public boolean isUserexistsByuserName(String userName) {
		return repository.existsByuserName(userName);
	}

	@Override
	public void updateUser(User user) {
		repository.save(user);

	}
}
