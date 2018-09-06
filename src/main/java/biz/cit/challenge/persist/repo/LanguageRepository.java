package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, String> {
	
	
}