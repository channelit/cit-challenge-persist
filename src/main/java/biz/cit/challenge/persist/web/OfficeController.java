package biz.cit.challenge.persist.web;

import biz.cit.challenge.persist.domain.Office;
import biz.cit.challenge.persist.domain.Office;
import biz.cit.challenge.persist.exception.ResourceNotFoundException;
import biz.cit.challenge.persist.repo.OfficeRepository;
import biz.cit.challenge.persist.repo.OfficeRepository;

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

@RequestMapping("/office")
@RestController
public class OfficeController {

	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	OfficeRepository officeRepository;

	@RequestMapping(path = "/", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public List<Office> getAllOffices() {
		return officeRepository.findAll();

	}

	@RequestMapping(path = "/{officeId}", method = RequestMethod.GET, produces = APPLICATION_JSON)
	public Office GetOfficeByOfficeId(@PathVariable String officeId) {
		return officeRepository.findById(officeId)
				.orElseThrow(() -> new ResourceNotFoundException("Office not found with id " + officeId));

	}

	@RequestMapping(path = "/", method = RequestMethod.PUT, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Office addOffice(@Valid @RequestBody Office office) {
		return officeRepository.save(office);
	}

	@RequestMapping(path = "/{officeId}", method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public Office updateOffice(@PathVariable String officeId, @Valid @RequestBody Office updatedOffice) {
		if (!officeRepository.existsById(officeId)) {
			throw new ResourceNotFoundException("Office not found with id " + officeId);
		}

		return officeRepository.findById(officeId).map(office -> {
			office.setCode(updatedOffice.getCode());
			office.setName(updatedOffice.getName());
			return officeRepository.save(office);
		}).orElseThrow(() -> new ResourceNotFoundException("Office not found with id " + officeId));
	}

	@RequestMapping(path = "/{officeId}", method = RequestMethod.DELETE, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	public ResponseEntity<?> deleteOffice(@PathVariable String officeId) {
		if (!officeRepository.existsById(officeId)) {
			throw new ResourceNotFoundException("Office not found with id " + officeId);
		}

		return officeRepository.findById(officeId).map(office -> {
			officeRepository.delete(office);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Office not found with id " + officeId));
	}
}
