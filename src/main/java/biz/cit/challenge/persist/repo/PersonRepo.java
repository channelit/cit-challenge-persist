package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, String> {
	
	
}