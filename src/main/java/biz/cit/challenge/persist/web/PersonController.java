package biz.cit.challenge.persist.web;

import biz.cit.challenge.persist.domain.Office;
import biz.cit.challenge.persist.domain.Person;
import biz.cit.challenge.persist.exception.ResourceNotFoundException;
import biz.cit.challenge.persist.repo.OfficeRepository;
import biz.cit.challenge.persist.repo.PersonRepository;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RequestMapping("/people")
@RestController
public class PersonController {

	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	PersonRepository personRepository;

	@Autowired
	OfficeRepository officeRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<Person> getAllPersons() {
		return personRepository.findAll();

	}

	@RequestMapping(path = "/{personId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Person GetPersonByPersonId(@PathVariable String personId) {
		Optional<Person> person = personRepository.findById(personId);

		return person.orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));

	}

	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Person addPerson(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}

	@RequestMapping(path = "/{personId}", method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Person updatePerson(@PathVariable String personId, @Valid @RequestBody Person updatedPerson) {
		if (!personRepository.existsById(personId)) {
			throw new ResourceNotFoundException("Person not found with id " + personId);
		}

		return personRepository.findById(personId).map(person -> {
			person.setFirstName(updatedPerson.getFirstName());
			person.setLastName(updatedPerson.getLastName());
			person.setMiddleName(updatedPerson.getMiddleName());
			person.setSuffix(updatedPerson.getSuffix());
			person.setUniqueIdentifier(updatedPerson.getUniqueIdentifier());
			return personRepository.save(person);
		}).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
	}

	@RequestMapping(path = "/{personId}", method = RequestMethod.DELETE, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public ResponseEntity<?> deletePerson(@PathVariable String personId) {
		if (!personRepository.existsById(personId)) {
			throw new ResourceNotFoundException("Person not found with id " + personId);
		}

		return personRepository.findById(personId).map(person -> {
			personRepository.delete(person);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
	}

	@RequestMapping(path = "/assignIdentifier", method = RequestMethod.POST)
	public Person addUniqueIdentifier(@RequestParam("personId") String personId, @RequestParam("uniqueId") String uniqueId) {
		if (!personRepository.existsById(personId)) {
			throw new ResourceNotFoundException("Person not found with id " + personId);
		}

		return personRepository.findById(personId).map(person -> {
			person.setUniqueIdentifier(uniqueId);
			return personRepository.save(person);
		}).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
	}

	@RequestMapping(path = "/assignOffice", method = RequestMethod.POST)
	public Person assignOffice(@RequestParam("personId") String personId, @RequestParam("officeId") String officeId) {
		if (!personRepository.existsById(personId)) {
			throw new ResourceNotFoundException("Person not found with id " + personId);
		}

		if (!officeRepository.existsById(officeId)) {
			throw new ResourceNotFoundException("Office not found with id " + officeId);
		}

		Office office = officeRepository.findById(officeId)
				.orElseThrow(() -> new ResourceNotFoundException("Office not found with id " + officeId));

		return personRepository.findById(personId).map(person -> {
			person.setOffice(office);
			return personRepository.save(person);
		}).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
	}

}
