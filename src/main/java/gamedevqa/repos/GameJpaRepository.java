package gamedevqa.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import gamedevqa.models.Game;

public interface GameJpaRepository extends JpaRepository<Game, Integer> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Game> findById(Integer id);
	
}
