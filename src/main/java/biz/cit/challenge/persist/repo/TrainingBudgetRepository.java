package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.TrainingBudget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingBudgetRepository extends JpaRepository<TrainingBudget, String> {
	
	
}