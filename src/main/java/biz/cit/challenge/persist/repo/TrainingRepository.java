package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, String> {
	
	
}