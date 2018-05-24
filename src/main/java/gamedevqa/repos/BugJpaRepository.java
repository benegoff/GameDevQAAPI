package gamedevqa.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import gamedevqa.models.Bug;

public interface BugJpaRepository extends JpaRepository<Bug, Integer> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Bug> findById(Integer id);
	
}
