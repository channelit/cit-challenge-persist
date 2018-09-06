package biz.cit.challenge.persist.repo;

import biz.cit.challenge.persist.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
}