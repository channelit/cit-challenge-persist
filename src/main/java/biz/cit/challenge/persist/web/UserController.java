package biz.cit.challenge.persist.web;

import biz.cit.challenge.persist.domain.User;
import biz.cit.challenge.persist.exception.ResourceNotFoundException;
import biz.cit.challenge.persist.repo.UserRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;

@RequestMapping("/user")
@ExposesResourceFor(User.class)
@RestController
public class UserController {

	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	UserRepository userRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public User GetUserByUserId(@PathVariable String userId) {
		Optional<User> user = userRepository.findById(userId);

		return user.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

	}

	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)
	public User addUser(@Valid @RequestBody User user) {
		return userRepository.save(user);
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.POST, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)
	public User updateUser(@PathVariable String userId, @Valid @RequestBody User updatedUser) {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found with id " + userId);
		}

		return userRepository.findById(userId).map(user -> {
			user.setFirstName(updatedUser.getFirstName());
			user.setLastName(updatedUser.getLastName());
			user.setMiddleName(updatedUser.getMiddleName());
			user.setSuffix(updatedUser.getSuffix());
			user.setUniqueIdentifier(updatedUser.getUniqueIdentifier());
			return userRepository.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.DELETE, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)	
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found with id " + userId);
		}

		return userRepository.findById(userId).map(person -> {
			userRepository.delete(person);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}
	
	@RequestMapping(path = "/assignIdentifier/{userId}", method = RequestMethod.POST, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)
	public User addUniqueIdentifier(@PathVariable String userId, @Valid @RequestBody String uniqueId) {
		if (!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found with id " + userId);
		}

		return userRepository.findById(userId).map(user -> {
			user.setUniqueIdentifier(uniqueId);
			return userRepository.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}

}
