package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.LanguageProficiency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageProficiencyRepository extends JpaRepository<LanguageProficiency, String> {
	
	
}