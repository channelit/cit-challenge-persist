package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Long> {
}