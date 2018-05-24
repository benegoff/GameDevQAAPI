package gamedevqa.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import gamedevqa.models.Suggestion;

public interface SuggestionJpaRepository extends JpaRepository<Suggestion, Integer>  {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Suggestion> findById(Integer id);
	
}
