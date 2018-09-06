package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, String> {
	
	
}