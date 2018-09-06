package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.Skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String> {
	
	
}