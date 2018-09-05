package biz.cit.challenge.persist.web;

import biz.cit.challenge.persist.domain.Person;
import biz.cit.challenge.persist.repo.PersonRepo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.ResponseEntity;

@RequestMapping("/person")
@ExposesResourceFor(Person.class)
@RestController
public class PersonController {

	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	PersonRepo personRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<Person> getAllUsers() {
		return personRepository.findAll();

	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Person GetPersonByUserId(@PathVariable String userId) {
		Optional<Person> person = personRepository.findById(userId);

		return person.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

	}

	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)
	public Person addUser(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)
	public Person updateUser(@PathVariable String userId, @Valid @RequestBody Person user) {
		if (!personRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found with id " + userId);
		}

		return personRepository.findById(userId).map(person -> {
			person.setFirstName(user.getFirstName());
			person.setLastName(user.getLastName());
			person.setMiddleName(user.getMiddleName());
			person.setSuffix(user.getSuffix());
			person.setUniqueIdentifier(user.getUniqueIdentifier());
			return personRepository.save(person);
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}

	@RequestMapping(path = "/", method = RequestMethod.DELETE, consumes = APPLICATION_JSON,  produces = APPLICATION_JSON)	
	public ResponseEntity<?> deleteUser(@PathVariable String userId) {
		if (!personRepository.existsById(userId)) {
			throw new ResourceNotFoundException("User not found with id " + userId);
		}

		return personRepository.findById(userId).map(person -> {
			personRepository.delete(person);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
	}

}
