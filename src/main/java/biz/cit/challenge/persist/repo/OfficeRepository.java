package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {
	
	
}