package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.TrainingType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingTypeRepository extends JpaRepository<TrainingType, String> {
	
	
}