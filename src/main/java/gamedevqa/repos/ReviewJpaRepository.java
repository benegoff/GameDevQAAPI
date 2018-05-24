package gamedevqa.repos;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import gamedevqa.models.Review;

public interface ReviewJpaRepository extends JpaRepository<Review, Integer> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Review> findById(Integer id);
	
}
