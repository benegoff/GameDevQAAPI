package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Review;

public interface ReviewJpaRepository extends JpaRepository<Review, Integer> {

}
