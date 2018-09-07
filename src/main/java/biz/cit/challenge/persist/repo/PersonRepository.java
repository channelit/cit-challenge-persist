package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.UserRole;
import biz.cit.challenge.persist.domain.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
	
	public List<Person> findByRole(UserRole role);
	
}