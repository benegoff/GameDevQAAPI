package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Game;

public interface GameJpaRepository extends JpaRepository<Game, Integer> {

}
