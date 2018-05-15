package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Genre;

public interface GenreJpaRepository extends JpaRepository<Genre, Integer> {

}
