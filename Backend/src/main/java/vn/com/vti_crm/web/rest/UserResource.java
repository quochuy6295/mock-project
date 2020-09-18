package vn.com.vti_crm.web.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vti_crm.domain.User;
import vn.com.vti_crm.service.UserService;
import vn.com.vti_crm.web.rest.error.exception.ResourceNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class UserResource {

	private final Logger log = LoggerFactory.getLogger(UserResource.class);

	@Autowired
	UserService userService;

	@PostMapping(value = "/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) throws URISyntaxException {
		log.debug("REST request to save User : {}", user);
		user = userService.createUser(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@Valid @PathVariable int userId) throws URISyntaxException {
		log.debug("REST request to save User : {}", userId);
		Optional<User> user = userService.getUserById(userId);
		return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
	}

	@PutMapping(value = "/users/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "userId") int userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userService.getUserById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setEmail(userDetails.getEmail());
		user.setName(userDetails.getName());
		user.setPassword(userDetails.getPassword());
		user.setRole(userDetails.getRole());
		final User updatedUser = userService.updateUser(user);
		return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping(value = "/users/{userId}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "userId") int userId)
			throws ResourceNotFoundException {
		User user = userService.getUserById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		userService.deleteUser(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
