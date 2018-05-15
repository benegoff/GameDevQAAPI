package gamedevqa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gamedevqa.models.Suggestion;

public interface SuggestionJpaRepository extends JpaRepository<Suggestion, Integer>  {

}
